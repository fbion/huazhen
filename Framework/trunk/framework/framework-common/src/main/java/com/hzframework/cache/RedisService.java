package com.hzframework.cache;


import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 磊 on 2015/12/28.
 */
public interface RedisService {
    String set(String key, String value);

    String get(String key);

    Boolean exists(String key);

    Long expire(String key, int seconds);

    Long expireAt(String key, long unixTime);

    Long ttl(String key);

    String getSet(String key, String value);

    String setex(String key, int seconds, String value);

    Long append(String key, String value);

    Long hset(String key, String field, String value);

    String hget(String key, String field);

    String hmset(String key, Map<String, String> hash);

    List<String> hmget(String key, String... fields);

    Boolean hexists(String key, String field);

    Long del(String key);

    Long hdel(String key, String field);

    Set<String> hkeys(String key);

    List<String> hvals(String key);

    Map<String, String> hgetAll(String key);

    Long rpush(String key, String value);

    Long lpush(String key, String value);

    List<String> lrange(String key, long start, long end);

    String lset(String key, long index, String value);

    Long lrem(String key, long count, String value);

    String lpop(String key);

    String rpop(String key);

    Long sadd(String key, String member);

    Long srem(String key, String member);

    Long zadd(String key, double score, String member);

    Long zrem(String key, String member);

}
