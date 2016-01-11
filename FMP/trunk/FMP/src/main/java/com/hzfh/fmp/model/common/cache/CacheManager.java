package com.hzfh.fmp.model.common.cache;

import com.hzframework.cache.CacheService;

/**
 * Created by paul on 14-12-30.
 */

public class CacheManager {
    private static CacheManager instance;
    public void init(){
        instance = this;
    }


    private CacheService cacheService;

    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public static boolean set(String prefix, String key, int expire, Object obj) {
        return instance.cacheService.set(prefix,key,expire,obj);
    }

    /*
     * prefix 前缀
     * key
     */

    public static Object get(String prefix, String key) {
        return instance.cacheService.get(prefix, key);
    }


    public static boolean remove(String prefix, String key) {
        return instance.cacheService.remove(prefix, key);
    }

    public static <T extends Object> T get(String prefix, String key, Class<T> c) {
        return (T) instance.get(prefix, key);
    }
}
