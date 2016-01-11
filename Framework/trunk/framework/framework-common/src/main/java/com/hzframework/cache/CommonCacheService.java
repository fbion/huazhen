package com.hzframework.cache;

import com.hzframework.helper.DateHelper;

import java.util.HashMap;

/**
 * Created by paul on 15-4-16.
 */
public class CommonCacheService implements CacheService {
    private static HashMap<String, Cache> cacheMap = new HashMap<String, Cache>();

    private static class SingletonHolder
    {
        public final static CommonCacheService instance = new CommonCacheService();
    }

    public static CommonCacheService getInstance()
    {
        return SingletonHolder.instance;
    }


    private CommonCacheService() {
        super();
    }

    public <T extends Object> T get(String prefix, String key, Class<T> c) {
        return (T) get(prefix, key);
    }

    public synchronized Object get(String prefix, String key) {
        Cache cache = (Cache) cacheMap.get(prefix + key);
        if (cache == null)
            return null;

        if (DateHelper.getCurrentTime().after(cache.getExpireTime())) {
            cacheMap.remove(prefix + key);
            return null;
        }

        return cache.getValue();
    }

    public synchronized boolean set(String prefix, String key, int expire, Object obj)
    {
        Cache cache = new Cache();
        cache.setKey(prefix + key);
        cache.setValue(obj);
        cache.setExpireTime(DateHelper.addSecond(DateHelper.getCurrentTime(),expire));

        cacheMap.put(prefix + key,cache);

        return true;
    }

    public synchronized boolean remove(String prefix, String key)
    {
        cacheMap.remove(prefix + key);
        return true;
    }
}
