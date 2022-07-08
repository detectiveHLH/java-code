package com.leonsh.java.code.framework.springservicedemo.util;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanCopierUtils工具类
 *
 * @author leonsh
 * @date 2020-12-18 23:53
 **/
@Component
public class BeanCopierUtils {

    /**
     * BeanCopier缓存
     */
    public static Map<String, BeanCopier> beanCopierCacheMap = new HashMap<>();

    public static void copyProperties(Object source, Object target) {
        BeanCopier beanCopier;
        String cacheKey = source.getClass().toString() + target.getClass().toString();
        if (!beanCopierCacheMap.containsKey(cacheKey)) {
            synchronized (BeanCopierUtils.class) {
                if (!beanCopierCacheMap.containsKey(cacheKey)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierCacheMap.put(cacheKey, beanCopier);
                } else {
                    beanCopier = beanCopierCacheMap.get(cacheKey);
                }
            }
        } else {
            beanCopier = beanCopierCacheMap.get(cacheKey);
        }

        beanCopier.copy(source, target, null);
    }
}
