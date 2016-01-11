import com.hzframework.helper.ArrayHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 15-2-11.
 */
public class ArrayHelperTest {
    @Test
    public void isNullOrEmptyTest() {
        List<String> strings = null;
        System.out.println(ArrayHelper.isNullOrEmpty(strings));

        strings = new ArrayList<String>();
        System.out.println(ArrayHelper.isNullOrEmpty(strings));

        strings.add("aa");
        System.out.println(ArrayHelper.isNullOrEmpty(strings));
    }
}
