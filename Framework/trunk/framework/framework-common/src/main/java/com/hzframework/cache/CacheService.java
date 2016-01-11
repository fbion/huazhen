package com.hzframework.cache;

/**
 * Created by paul on 14-12-30.
 */
public interface CacheService {
    public boolean set(String prefix, String key, int expire, Object obj);

    public <T extends Object> T get(String prefix, String key, Class<T> c);

    public Object get(String prefix, String key);

    public boolean remove(String prefix, String key);
    
    
}
