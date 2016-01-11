package com.hzfh.o2o.model.common.cache;

import com.hzframework.cache.CacheService;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

/**
 * Created by paul on 15-4-16.
 */
@Service
class MemCachedService implements CacheService {
    @Autowired
    private MemcachedClient memcachedClient;

    /*
    * prefix 前缀
    * key
    * expire 过期时间，秒
    * Object value
    */
    @Override
    public boolean set(String prefix, String key, int expire, Object obj) {
        try {
            return this.memcachedClient.set(prefix + key, expire, obj);
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (MemcachedException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * prefix 前缀
     * key
     */
    @Override
    public Object get(String prefix, String key) {
        try {
            return this.memcachedClient.get(prefix + key);
        } catch (TimeoutException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (MemcachedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(String prefix, String key) {
        try {
            return this.memcachedClient.delete(prefix + key);
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (MemcachedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public <T extends Object> T get(String prefix, String key, Class<T> c) {
        return (T) get(prefix, key);
    }
}
