package com.hzfh.fmp.model.common.cache;

import com.hzframework.cache.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.ShardedJedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 磊 on 2015/12/25.
 */
@Service
public class RedisCachedService implements RedisService {
    @Autowired
    private RedisResource redisResource;

    private boolean broken = false;

    /**
     * 设置一个key的value值
     *
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 获取key的值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 查询一个key是否存在
     *
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 设置一个key的过期的秒数
     *
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(String key, int seconds) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.expire(key, seconds);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 设置一个UNIX时间戳的过期时间
     *
     * @param key
     * @param unixTime
     * @return
     */
    public Long expireAt(String key, long unixTime) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.expireAt(key, unixTime);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 获取key的有效时间（单位：秒）
     *
     * @param key
     * @return
     */
    public Long ttl(String key) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.ttl(key);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 设置一个key的value，并获取设置前的值
     *
     * @param key
     * @param value
     * @return
     */
    public String getSet(String key, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.getSet(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 设置key-value并设置过期时间（单位：秒）
     *
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public String setex(String key, int seconds, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.setex(key, seconds, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 追加一个值到key上
     *
     * @param key
     * @param value
     * @return
     */
    public Long append(String key, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.append(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 设置hash里面一个字段的值
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hset(String key, String field, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.hset(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 读取哈希域的的值
     *
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.hget(key, field);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }


    /**
     * 设置hash字段值
     *
     * @param key
     * @param hash
     * @return
     */
    public String hmset(String key, Map<String, String> hash) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.hmset(key, hash);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 获取hash里面指定字段的值
     *
     * @param key
     * @param fields
     * @return
     */
    public List<String> hmget(String key, String... fields) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.hmget(key, fields);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }


    /**
     * 判断给定域是否存在于key
     *
     * @param key
     * @param field
     * @return
     */
    public Boolean hexists(String key, String field) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.hexists(key, field);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 删除一个key
     *
     * @param key
     * @return
     */
    public Long del(String key) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 删除一个或多个哈希域
     *
     * @param key
     * @param field
     * @return
     */
    public Long hdel(String key, String field) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.hdel(key, field);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }


    /**
     * 获取hash的所有字段
     *
     * @param key
     * @return
     */
    public Set<String> hkeys(String key) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.hkeys(key);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 获得hash的所有值
     *
     * @param key
     * @return
     */
    public List<String> hvals(String key) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.hvals(key);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 从哈希集中读取全部的域和值
     *
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(String key) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.hgetAll(key);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;

    }

    /**
     * 从队列的右边入队一个元素
     *
     * @param key
     * @param value
     * @return
     */
    public Long rpush(String key, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.rpush(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 从队列的左边入队一个或多个元素
     *
     * @param key
     * @param value
     * @return
     */
    public Long lpush(String key, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.lpush(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 从列表中获取指定返回的元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> lrange(String key, long start, long end) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.lrange(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 设置队列里面一个元素的值
     *
     * @param key
     * @param index
     * @param value
     * @return
     */
    public String lset(String key, long index, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.lset(key, index, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 从列表中删除元素
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    public Long lrem(String key, long count, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.lrem(key, count, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 从队列的左边出队一个元素
     *
     * @param key
     * @return
     */
    public String lpop(String key) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.lpop(key);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 从队列的右边出队一个元素
     *
     * @param key
     * @return
     */
    public String rpop(String key) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.rpop(key);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 添加一个或者多个元素到集合(set)里
     *
     * @param key
     * @param member
     * @return
     */
    public Long sadd(String key, String member) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.sadd(key, member);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 从集合里删除一个或多个key
     *
     * @param key
     * @param member
     * @return
     */
    public Long srem(String key, String member) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.srem(key, member);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }


    /**
     * 添加到有序set的一个或多个成员，或更新的分数，如果它已经存在
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public Long zadd(String key, double score, String member) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.zadd(key, score, member);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

    /**
     * 从排序的集合中删除一个或多个成员
     *
     * @param key
     * @param member
     * @return
     */
    public Long zrem(String key, String member) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.zrem(key, member);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }


    /**
     * 在列表中的另一个元素之前或之后插入一个元素
     *
     * @param key
     * @param where
     * @param pivot
     * @param value
     * @return
     */
    public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        ShardedJedis shardedJedis = redisResource.getRedis();
        try {
            return shardedJedis.linsert(key, where, pivot, value);
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            redisResource.returnResource(shardedJedis, broken);
        }
        return null;
    }

}
