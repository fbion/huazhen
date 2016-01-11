package com.hzfh.fmp.model.common.cache;

import com.hzframework.cache.RedisService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by paul on 14-12-30.
 */

public class RedisManager {
    private static RedisManager instance;

    public void init() {
        instance = this;
    }

    private RedisService redisService;

    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    public static String set(String key, String value, int expire) {
        if (expire > 0) {
            return instance.redisService.setex(key, expire, value);
        }
        return instance.redisService.set(key, value);
    }

    public static String getSet(String key, String value) {
        return instance.redisService.getSet(key, value);
    }

    public static Long append(String key, String value) {
        return instance.redisService.append(key, value);
    }

    public static Long del(String key) {
        return instance.redisService.del(key);
    }

    public static Long hdel(String key, String field) {
        return instance.redisService.hdel(key, field);
    }

    public static Long hset(String key, String field, String value, int expire) {
        Long result = instance.redisService.hset(key, field, value);
        if (expire > 0) {
            result = instance.redisService.expire(key, expire);
        }
        return result;
    }

    public static Object hmset(String key, Map<String, String> hash, int expire) {
        Object result = instance.redisService.hmset(key, hash);
        if (expire > 0) {
            result = instance.redisService.expire(key, expire);
        }
        return result;
    }

    public static String hget(String key, String field) {
        return instance.redisService.hget(key, field);
    }

    public static Set<String> hkeys(String key) {
        return instance.redisService.hkeys(key);
    }

    public static List<String> hvals(String key) {
        return instance.redisService.hvals(key);
    }

    public static Map<String, String> hgetAll(String key) {
        return instance.redisService.hgetAll(key);
    }

    public static Long rpush(String key, String value) {
        return instance.redisService.rpush(key, value);
    }

    public static Long lpush(String key, String value) {
        return instance.redisService.lpush(key, value);
    }

    public static Long sadd(String key, String value, int expire) {
        Long result = instance.redisService.sadd(key, value);
        if (expire > 0) {
            result = instance.redisService.expire(key, expire);
        }
        return result;
    }

    public static Long srem(String key, String member) {
        return instance.redisService.srem(key, member);
    }

    public static Long zadd(String key, double score, String member, int expire) {
        Long result = instance.redisService.zadd(key, score, member);
        if (expire > 0) {
            result = instance.redisService.expire(key, expire);
        }
        return result;
    }

    public static Long zrem(String key, String member) {
        return instance.redisService.zrem(key, member);
    }


}
