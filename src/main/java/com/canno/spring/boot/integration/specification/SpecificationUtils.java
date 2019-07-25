package com.canno.spring.boot.integration.specification;

import com.canno.spring.boot.integration.utils.DateUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Gin
 * @since 2019/6/10 17:13
 */
public class SpecificationUtils {
    /**
     * 将注解转换为自定义查询条件
     *
     * @param o
     *
     * @return
     */
    protected static List<CustomCondition> getCustomConditions(Object o) {
        List<CustomCondition> customConditions = new ArrayList<>();
        // 仅获取当前类的属性，不获取父类属性
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(QueryIgnore.class) != null) {
                continue;
            }

            QueryCustom custom = field.getAnnotation(QueryCustom.class);
            if (custom != null) {
                List<String> colums = new ArrayList<>();

                // Arrays.asList()转化后是个内部的List,且未实现add方法，故长度固定
                colums.addAll(Arrays.asList(custom.column()));
                if (colums.size() == 0) {
                    colums.add(field.getName());
                }

                if (getFieldValue(field, o) == null) {
                    continue;
                }

                if (getFieldValue(field, o) instanceof String) {
                    if ("".equals(getFieldValue(field, o))) {
                        continue;
                    }
                }
                int i = 1;
                CustomCondition customCondition = null;
                for (String columnName : colums) {
                    Object value = null;
                    switch (custom.castType()) {
                        case DATE:
                            value = DateUtils.dateFormat((String) getFieldValue(field, o));
                            break;
                        case END_DATE:
                            value = DateUtils.endDateFormat((String) getFieldValue(field, o));
                            break;
                        default:
                            value = getFieldValue(field, o);
                    }

                    if (i == 1) {
                        customCondition = new CustomCondition(columnName, field.getName(), value, custom.operator());
                        customCondition.setIgnoreCase(custom.ignoreCase());
                        customCondition.setLinkedType(custom.linkedType());
                        customConditions.add(customCondition);
                    } else {
                        customCondition.inNames.add(columnName);
                        customCondition.inLinkedType = custom.multiLinkedType();
                    }
                    i++;
                }
            }
        }

        return customConditions;
    }

    protected static Map<String, Object> getFields(Object target) {
        if (target == null) {
            return new HashMap<>();
        }

        // 仅获取当前类的属性，不获取父类属性
        Field[] fields = target.getClass().getDeclaredFields();
        return Arrays.stream(fields).filter(field -> field.getAnnotation(QueryIgnore.class) == null)
                .collect(HashMap::new, (m, f) -> m.put(f.getName(), getFieldValue(f, target)), HashMap::putAll);

        // Collectors.toMap 底层使用HashMap.merge实现，当value == null时，抛出NPE
        // 方法不符合预期，也可能是个bug, 慎用
        // .collect(Collectors.toMap(Field::getName, field -> getFieldValue(field, target), (a, b) -> b));
    }


    /**
     * 反射获取field值
     *
     * @param field
     * @param target
     *
     * @return
     */
    protected static Object getFieldValue(Field field, Object target) {
        // TODO: 2019/7/24 可以优化通过get/set方式
        if (field.isAccessible()) {
            try {
                return field.get(target);
            } catch (IllegalAccessException e) {
                // ignore
            }
        } else {
            try {
                field.setAccessible(true);
                return field.get(target);
            } catch (IllegalAccessException e) {
                // ignore
            } finally {
                field.setAccessible(false);
            }
        }

        return null;
    }

}
