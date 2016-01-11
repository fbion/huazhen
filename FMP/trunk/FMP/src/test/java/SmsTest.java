
import com.hzfh.api.baseInfo.model.Letter;
import com.hzfh.fmp.facade.baseInfo.LetterFacade;
import com.hzfh.fmp.model.baseInfo.LetterModel;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SmsTest {

	@Test
	public void testSms() throws Exception {
        String a = "2015-10-25";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = simpleDateFormat.parse(a);

        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int i = c.get(Calendar.WEEK_OF_YEAR);
        System.out.println(i);
	}
    @Test
    public void addReminds() {
       LetterModel.addReminds("javatest","测试",192);
    }

}
