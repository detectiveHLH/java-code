package com.leonsh.java.code.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 基础POJO类
 *
 * @author leonsh
 * @date 2020-12-28 19:31
 **/
public class AbstractObject {
    /**
     * 浅度克隆
     *
     * @param clazz 类
     * @return 范型
     * @throws Exception 业务异常
     */
    public <T> T clone(Class<T> clazz) throws Exception {
        T target = clazz.newInstance();
        BeanCopierUtils.copyProperties(this, target);
        return target;
    }

    /**
     * 浅度克隆
     *
     * @param target 拷贝对象
     * @return 范型
     * @throws Exception 业务异常
     */
    public <T> T clone(T target) throws Exception {
        BeanCopierUtils.copyProperties(this, target);
        return target;
    }

    /**
     * 深度克隆
     *
     * @param clazz          目标对象class
     * @param cloneDirection 克隆方向
     * @return 克隆后的对象
     * @throws Exception 业务异常
     */
    public <T> T clone(Class<T> clazz, Integer cloneDirection) throws Exception {
        // 基础字段的深拷贝
        T target = clazz.newInstance();
        BeanCopierUtils.copyProperties(this, target);

        Class<?> thisClazz = this.getClass();

        Field[] fields = thisClazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            // 判断某个字段是否为list
            if (field.getType() == List.class) {
                // 获取List中的泛型的实际参数类型
                Class<?> listGenericClazz = getListGenericType(field);
                Class<?> cloneTargetClazz = getCloneTargetClazz(listGenericClazz, cloneDirection);

                // 将list集合克隆到目标list集合中去
                List clonedList = new ArrayList();
                // List<RelationDTO>集合
                List<?> list = (List<?>) field.get(this);
                cloneList(list, clonedList, cloneTargetClazz, cloneDirection);

                // 获取设置克隆好的list的方法名称
                Method setFieldMethod = getSetCloneListFieldMethodName(field, clazz); // setRelations
                // target是CategoryVO对象，此时就是调用CategoryVO的setRelations方法，将克隆好的List<CategoryVO>给设置进去
                setFieldMethod.invoke(target, clonedList);
            }
        }

        return target;
    }

    /**
     * 将一个list克隆到另外一个list
     *
     * @param sourceList       被克隆的list
     * @param targetList       克隆之后的list
     * @param cloneTargetClazz 被克隆的对象类
     * @param cloneDirection   拷贝目标
     * @throws Exception 业务异常
     */
    private void cloneList(List sourceList, List targetList, Class cloneTargetClazz, Integer cloneDirection) throws Exception {
        for (Object object : sourceList) {
            AbstractObject targetObject = (AbstractObject) object;
            // 将集合中的RelationDTO，调用其clone()方法，将其往RelationVO去克隆
            AbstractObject clonedObject = (AbstractObject) targetObject.clone(cloneTargetClazz, cloneDirection);
            // RelationVO的集合
            targetList.add(clonedObject);
        }
    }

    /**
     * 获取list集合的泛型类型
     *
     * @param field 字段
     * @return 泛型类型
     */
    private Class<?> getListGenericType(Field field) {
        Type genericType = field.getGenericType();

        // ParameterizedType 指带有类型参数的类型, 也就是泛型
        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            return (Class<?>) parameterizedType.getActualTypeArguments()[0];
        }

        return null;
    }

    /**
     * 获取目标类名
     *
     * @param clazz          克隆对象的类
     * @param cloneDirection 克隆方向
     * @return 克隆对象的类
     * @throws Exception 业务异常
     */
    private Class<?> getCloneTargetClazz(Class<?> clazz, Integer cloneDirection) throws Exception {
        String cloneTargetClassName = null;

        String className = clazz.getName();

        if (cloneDirection.equals(CloneDirection.FORWARD)) {
            if (className.endsWith(DomainType.VO)) {
                cloneTargetClassName = className.substring(0, className.length() - 2) + "DTO";
            } else if (className.endsWith(DomainType.DTO)) {
                cloneTargetClassName = className.substring(0, className.length() - 3) + "DO";
            }
        }

        if (cloneDirection.equals(CloneDirection.OPPOSITE)) {
            if (className.endsWith(DomainType.DO)) {
                cloneTargetClassName = className.substring(0, className.length() - 2) + "DTO";
            } else if (className.endsWith(DomainType.DTO)) {
                cloneTargetClassName = className.substring(0, className.length() - 3) + "VO";
            }
        }

        return Class.forName(cloneTargetClassName);
    }

    /**
     * 获取设置克隆好的list的方法名称
     *
     * @param field 字段
     * @param clazz 字段所属的类
     * @return 对应字段的方法
     * @throws Exception 业务异常
     */
    private Method getSetCloneListFieldMethodName(Field field, Class<?> clazz) throws Exception {
        String name = field.getName();
        String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);

        Method setFieldMethod = null;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(setMethodName)) {
                setFieldMethod = method;
                break;
            }
        }

        return setFieldMethod;
    }

}
