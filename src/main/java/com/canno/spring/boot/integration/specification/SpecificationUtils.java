package com.canno.spring.boot.integration.specification;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Gin
 * @since 2019/6/10 17:13
 */
class SpecificationUtils {
    /**
     * 将注解转换为自定义查询条件
     *
     * @param o
     *
     * @return
     */
    static List<CustomCondition> getCustomConditions(Object o) {
        List<CustomCondition> customConditions = new ArrayList<>();
        Map<String, Method> properties = getPropertiesAndGetter(o.getClass());

        // 仅获取当前类的属性，不获取父类属性
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(SpecificationIgnore.class) != null) {
                continue;
            }

            SpecificationQuery custom = field.getAnnotation(SpecificationQuery.class);
            if (custom != null) {

                // Arrays.asList()转化后是个内部的List,且未实现add方法，故长度固定
                List<String> columns = new ArrayList<>(Arrays.asList(custom.property()));
                if (columns.size() == 0) {
                    columns.add(field.getName());
                }

                Object propertyValue = invoke(properties.get(field.getName()), o);
                if (propertyValue == null) {
                    continue;
                }

                if (propertyValue instanceof String) {
                    if ("".equals(propertyValue)) {
                        continue;
                    }
                }

                int i = 1;
                CustomCondition customCondition = null;
                for (String columnName : columns) {
                    if (i == 1) {
                        customCondition = new CustomCondition(columnName, field.getName(), propertyValue, custom.compare());
                        customCondition.setIgnoreCase(custom.ignoreCase());
                        customCondition.setLinkedType(custom.operator());
                        customCondition.setJoinName(custom.join());
                        customConditions.add(customCondition);
                    } else {
                        customCondition.inNames.add(columnName);
                        customCondition.inLinkedType = custom.multiOperator();
                    }
                    i++;
                }
            }
        }

        return customConditions;
    }

    static Map<String, Object> getProperties(Object target) {
        if (target == null) {
            return new HashMap<>();
        }

        Map<String, Method> getterMap = getPropertiesAndGetter(target.getClass());

        // 仅获取当前类的属性，不获取父类属性
        Field[] fields = target.getClass().getDeclaredFields();
        return Arrays.stream(fields).filter(field -> field.getAnnotation(SpecificationIgnore.class) == null)
                .collect(HashMap::new, (m, f) -> {
                    try {
                        m.put(f.getName(), getterMap.get(f.getName()).invoke(target));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }, HashMap::putAll);

        // Collectors.toMap 底层使用HashMap.merge实现，当value == null时，抛出NPE
        // 方法不符合预期，也可能是个bug, 慎用
        // .collect(Collectors.toMap(Field::getName, field -> getFieldValue(field, target), (a, b) -> b));
    }

    private static Object invoke(Method method, Object target) {
        try {
            return method.invoke(target);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反射获取field值
     *
     * @param field
     * @param target
     *
     * @return
     */
    @Deprecated
    private static Object getFieldValue(Field field, Object target) {
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

    static Map<String, Method> getPropertiesAndGetter(Class target) {
        PropertyDescriptor[] propertyDescriptors = new PropertyDescriptor[0];
        try {
            propertyDescriptors = Introspector.getBeanInfo(target).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }

        Map<String, Method> getterMap = new HashMap<>();

        Arrays.asList(propertyDescriptors)
                .forEach(propertyDescriptor -> getterMap.put(propertyDescriptor.getName(), propertyDescriptor.getReadMethod()));

        return getterMap;

    }

}
