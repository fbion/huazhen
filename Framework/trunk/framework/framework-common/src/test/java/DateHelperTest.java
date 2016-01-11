import com.hzframework.helper.DateHelper;
import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;

/**
 * Created by paul on 15-1-26.
 */
public class DateHelperTest {

    @Test
    public void parseTest() throws ParseException {
        Date date = DateHelper.parse("2015-01-26");
    }

    @Test
    public void getCurrentTimeTest() {
        System.out.print(DateHelper.getCurrentTime());
    }

    @Test
    public void addMinuteTest(){System.out.print(DateHelper.addMinute(DateHelper.getCurrentTime(),10));}
}
