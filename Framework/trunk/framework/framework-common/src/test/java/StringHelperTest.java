import com.hzframework.helper.StringHelper;
import org.junit.Test;

/**
 * Created by paul on 15-2-11.
 */
public class StringHelperTest {
    @Test
    public void trimEndTest(){
        String src = "560123456";

        System.out.println(StringHelper.trimEnd(src,"56"));

        System.out.println(StringHelper.trimEnd(src,"7"));

        System.out.println(StringHelper.trimEnd(src,"57"));

        System.out.println(StringHelper.trimEnd(src,"67"));

        System.out.println(StringHelper.trimEnd(src,"45"));
    }

    @Test
    public void trimStartTest(){
        String src = "560123456";

        System.out.println(StringHelper.trimStart(src,"56"));

        System.out.println(StringHelper.trimStart(src,"7"));

        System.out.println(StringHelper.trimStart(src,"57"));

        System.out.println(StringHelper.trimStart(src,"67"));

        System.out.println(StringHelper.trimStart(src,"60"));
    }
}
