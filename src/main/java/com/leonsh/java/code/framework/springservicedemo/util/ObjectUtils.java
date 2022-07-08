package com.leonsh.java.code.framework.springservicedemo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象工具类
 *
 * @author leonsh
 * @date 2020-12-28 19:34
 **/
public class ObjectUtils {
    /**
     * 转换集合
     *
     * @param sourceObject 源对象
     * @param targetClazz  目标集合元素类型
     * @return 转换后的集合
     */
    public static <T> T convert(AbstractObject sourceObject, Class<T> targetClazz) throws Exception {
        return sourceObject.clone(targetClazz);
    }

    public static <T> List<T> convertList(List<? extends AbstractObject> sourceList, Class<T> targetClazz) throws Exception {
        List<T> targetList = new ArrayList<>();
        for (AbstractObject sourceObject : sourceList) {
            targetList.add(sourceObject.clone(targetClazz));
        }
        return targetList;
    }

    /**
     * 转换集合-深度克隆
     *
     * @param sourceList  源集合
     * @param targetClazz 目标集合元素类型
     * @return 转换后的集合
     */
    public static <T> List<T> convertList(List<? extends AbstractObject> sourceList,
                                          Class<T> targetClazz, Integer cloneDirection) throws Exception {
        List<T> targetList = new ArrayList<>();
        for (AbstractObject sourceObject : sourceList) {
            targetList.add(sourceObject.clone(targetClazz, cloneDirection));
        }
        return targetList;
    }
}
