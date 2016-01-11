import com.hzfh.fmp.model.common.cache.RedisManager;
import org.junit.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.*;

/**
 * Created by 磊 on 2015/12/25.
 */
public class TestRedis {

    @org.junit.Test
    public void redis(){
        //1、初始化
        Jedis jedis = new Jedis("192.168.1.232");
//        jedis.auth("huazhen@123");
        String key = "IT";
        jedis.set(key,"hull");
        System.out.println(jedis.get("IT"));
    }

    @Test
    public void redisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1500);
        config.setMaxIdle(200);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);

        JedisPool jedisPool = new JedisPool(config,"192.168.1.232",6379);
        Jedis jedis = jedisPool.getResource();
        for (int i=0;i<10;i++){
            jedis.set("test1"+i,"test");
        }
    }
}
