package com.hzfh.fmp.model.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by 磊 on 2015/12/29.
 */
@Repository("redisResource")
public class RedisResource {
    @Autowired
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedis getRedis(){
        try {
            return shardedJedisPool.getResource();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void returnResource(ShardedJedis shardedJedis,boolean broken){
        if(broken){
            shardedJedisPool.returnBrokenResource(shardedJedis);
        }else {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
}
