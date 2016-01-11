import com.hzframework.cache.CacheManager;
import org.junit.Test;

/**
 * Created by paul on 15-2-22.
 */
public class CacheTest {
    @Test
    public void cacheTest(){
        String str ="aaa";
        CacheManager.set("mycache",60,str);

        System.out.println(CacheManager.get("mycache").toString());
        System.out.println(CacheManager.get("mycache",String.class));


        str ="aba";
        CacheManager.set("mycache",10,str);

        System.out.println(CacheManager.get("mycache").toString());
        System.out.println(CacheManager.get("mycache",String.class));


        System.out.println(String.valueOf(CacheManager.get("mycache")));
        System.out.println(CacheManager.get("mycache",String.class));

    }
}
