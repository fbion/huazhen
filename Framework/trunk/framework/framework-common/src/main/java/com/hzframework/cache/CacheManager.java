package com.hzframework.cache;


/**
 * Created by paul on 15-2-12.
 */
public class CacheManager {
    private static final String prefix = "Common";

    public static <T extends Object> T get(String key, Class<T> c) {
        return (T) CommonCacheService.getInstance().get(prefix, key);
    }

    public static Object get(String key) {
        return CommonCacheService.getInstance().get(prefix, key);
    }

    public static boolean set(String key, int expire, Object obj) {
        return CommonCacheService.getInstance().set(prefix, key, expire, obj);
    }

    public static boolean remove(String key) {
        return CommonCacheService.getInstance().remove(prefix, key);
    }
}
