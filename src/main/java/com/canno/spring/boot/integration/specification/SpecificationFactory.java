package com.canno.spring.boot.integration.specification;

import com.canno.spring.boot.integration.entity.BaseEntity;
import com.canno.spring.boot.integration.utils.TypeConversionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.canno.spring.boot.integration.specification.SpecificationUtils.getCustomConditions;
import static com.canno.spring.boot.integration.specification.SpecificationUtils.getFields;

/**
 * @author Gin
 * @since 2019/4/2 19:06
 */
@SuppressWarnings({"uncheck", "rawtypes", "cast", "all"})
public class SpecificationFactory {
    private static Logger logger = LoggerFactory.getLogger(SpecificationFactory.class);

    public static <T extends BaseEntity> Specification<T> getConditions(Object queryCondition, Class<T> entityClass) {
        return getConditions(queryCondition, entityClass, null);
    }

    /**
     * @param queryCondition
     *         查询条件TO
     * @param entityClass
     *         查询实体
     * @param conditions
     *         自定义查询条件
     * @param <T>
     *         对应查询实体
     *
     * @return
     */
    public static <T extends BaseEntity> Specification<T> getConditions(Object queryCondition, Class<T> entityClass, List<CustomCondition> customConditions) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 仅加载所有未删除的记录
                Predicate predicate = criteriaBuilder.equal(root.get("deleted"), false);

                // 查询TO属性
                Map<String, Object> conditionMap = getFields(queryCondition);
                // 对应实体属性
                Map<String, Object> entityMap = new HashMap<>();
                try {
                    entityMap = TypeConversionUtil.json2Object(TypeConversionUtil.object2Json(entityClass.newInstance()), HashMap.class);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                // 内部类 此处customConditions 值被 static final 修饰，此处新建一个List 对其进行条件初始化
                List<CustomCondition> conditions = customConditions;
                if (conditions == null) {
                    conditions = new ArrayList<>();
                }

                // 把有注解的字段转换为查询条件
                conditions.addAll(getCustomConditions(queryCondition));

                // 自定义条件转换
                if (conditions != null && conditions.size() > 0) {
                    for (CustomCondition condition : conditions) {
                        if (!entityMap.containsKey(condition.columnName)) {
                            throw new RuntimeException("未知字段:" + condition.columnName);
                        }
                        logger.debug("查询字段：{}={}", condition.columnName, condition.value);

                        Predicate tmp = getPredicate(condition, criteriaBuilder, root);
                        tmp = getInPredicate(tmp, condition, criteriaBuilder, root);

                        switch (condition.linkedType) {
                            case AND: {
                                predicate = criteriaBuilder.and(predicate, tmp);
                                break;
                            }

                            // TODO: 2019/7/23 bug-fixed
                            case OR: {
                                predicate = criteriaBuilder.or(predicate, tmp);
                                break;
                            }

                            default:
                                break;
                        }

                        // 移除已处理的条件
                        conditionMap.remove(condition.name);
                    }
                }

                for (Map.Entry<String, Object> entry : conditionMap.entrySet()) {
                    // 判断是否字段名与entity一致，不一致可能需要某种转换
                    if (entry.getValue() != null) {
                        if (entry.getValue() instanceof String && "".equals(entry.getValue())) {
                            continue;
                        }

                        if (entityMap.containsKey(entry.getKey())) {
                            logger.debug("查询字段：{}={}", entry.getKey(), entry.getValue());
                            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue()));
                        } else {
                            // 非目标key 可能需要特殊处理，例如 updateTime, updateTimeDesc 按照特定规则转换
                            // 此处不处理，对于特殊转换用自定义转换类处理 [CustomCondition]
                            logger.error("未知查询字段:{}", entry.getKey());
                            throw new RuntimeException("未知查询字段:" + entry.getKey());
                        }

                    }
                }

                return query.where(predicate).getRestriction();
            }
        };
    }

    /**
     * 根据操作符组合查询语句
     *
     * @param condition
     * @param criteriaBuilder
     * @param root
     * @param <T>
     *
     * @return
     */
    private static <T> Predicate getPredicate(CustomCondition condition, CriteriaBuilder criteriaBuilder, Root<T> root) {
        Predicate predicate;
        switch (condition.operatorType) {
            // 小于等于
            case LESS_THAN_OR_EQUAL:
                predicate = criteriaBuilder.lessThanOrEqualTo(root.get(condition.columnName), (Comparable) condition.value);
                break;

            // 包含
            case CONTAIN:
                if (condition.ignoreCase) {
                    predicate = (criteriaBuilder.like(criteriaBuilder.lower(root.get(condition.columnName)), "%" + ((String) condition.value).toLowerCase() + "%"));
                } else {
                    predicate = criteriaBuilder.like(root.get(condition.columnName), "%" + condition.value + "%");
                }
                break;

            // 小于
            case LESS_THAN:
                predicate = criteriaBuilder.lessThan(root.get(condition.columnName), (Comparable) condition.value);
                break;

            // 大于
            case GRATER_THAN:
                predicate = criteriaBuilder.greaterThan(root.get(condition.columnName), (Comparable) condition.value);
                break;

            // 大于等于
            case GRATER_THAN_OR_EQUAL:
                predicate = criteriaBuilder.greaterThanOrEqualTo(root.get(condition.columnName), (Comparable) condition.value);
                break;

            // 默认等于
            case EQUAL:
            default:
                predicate = criteriaBuilder.equal(root.get(condition.columnName), condition.value);
                break;
        }

        return predicate;
    }

    private static <T> Predicate getInPredicate(Predicate predicate, CustomCondition condition, CriteriaBuilder criteriaBuilder, Root<T> root) {
        if (condition.inNames.size() == 0) {
            return predicate;
        }

        List<Predicate> predicates = new ArrayList<>();
        for (String name : condition.inNames) {
            CustomCondition newCondition = new CustomCondition(name, name, condition.value, condition.operatorType);
            predicates.add(getPredicate(newCondition, criteriaBuilder, root));
        }

        predicates.add(predicate);

        switch (condition.inLinkedType) {
            case AND:
                return criteriaBuilder.and(criteriaBuilder.and(predicates.toArray(new Predicate[]{})));

            case OR:
                return criteriaBuilder.or(criteriaBuilder.or(predicates.toArray(new Predicate[]{})));
        }

        return predicate;
    }

}
