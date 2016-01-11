import com.hzframework.web.config.Config;
import com.hzframework.web.cookie.config.CookieConfig;
import com.hzframework.web.cookie.config.CookieConfigHelper;
import com.hzframework.web.resources.config.WebResourceConfigHelper;
import com.hzframework.web.resources.config.css.Css;
import com.hzframework.web.resources.config.css.CssConfig;
import com.hzframework.web.resources.config.page.PageConfig;
import com.hzframework.web.resources.config.script.Script;
import com.hzframework.web.resources.config.script.ScriptConfig;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by paul on 14-12-17.
 */
public class ResoucreConfigTest {
    @Test
    public void getScriptConfigTest() {
//        ScriptConfig scriptConfig = WebResourceConfigHelper.getScriptConfig("/Users/paul/config");
//        List<Script> scriptList = scriptConfig.getScriptListInPage("productList");
        ScriptConfig scriptConfig = WebResourceConfigHelper.getScriptConfig();

        System.out.println(scriptConfig);
    }

    @Test
    public void getCssConfigTest() {
        CssConfig cssConfig = WebResourceConfigHelper.getCssConfig();
        List<Css> cssList = cssConfig.getCssListInPage("Login");

        System.out.println(cssConfig);
    }

    @Test
    public void getCookieTest() throws InterruptedException {
        File directory = new File("");//设定为当前文件夹
        try {
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
        } catch (Exception e) {
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("+++++++++++index+++++++++++");
            System.out.println(i);
            System.out.println("+++++++++++CookieConfig+++++++++++");
            CookieConfig cookieConfig = CookieConfigHelper.getCookieConfig();
            System.out.println(cookieConfig.getCookeInfo("LoginInfo").isTopLevelDomain());

            System.out.println("+++++++++++ScriptConfig+++++++++++");
            ScriptConfig scriptConfig = WebResourceConfigHelper.getScriptConfig();
            List<Script> scriptList = scriptConfig.getScriptListInPage("register");
            for (Script script:scriptList){
                System.out.println(script.getName());
            }
            System.out.println("+++++++++++CssConfig+++++++++++");
            CssConfig cssConfig = WebResourceConfigHelper.getCssConfig();
            List<Css> cssList = cssConfig.getCssListInPage("Home");
            for (Css css:cssList){
                System.out.println(css.getName());
            }

            Thread.sleep(1000*10);
        }
    }

    @Test
    public void getPageConfigTest() {

        PageConfig pageConfig = Config.getPageConfig();
        System.out.println(pageConfig);
    }
}
