package weixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hzfh.weixin.model.common.helper.UrlHelper;

import weixin.pojo.Button;
import weixin.pojo.ComplexButton;
import weixin.pojo.Menu;
import weixin.pojo.Token;
import weixin.pojo.ViewButton;
import weixin.util.CommonUtil;
import weixin.util.Constant;
import weixin.util.MenuUtil;
/**
 * 菜单管理器类
 * @author Administrator
 *	@date 2015-11-19
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);
	/**
	 * 定义菜单结构
	 * @return
	 */
	private static Menu getMenu(){
		ViewButton btn11 = new ViewButton();
		btn11.setName("网站首页");
		btn11.setType("view");
		btn11.setUrl(UrlHelper.bulidWinXinBackUrl("index"));
		
		
		
		ViewButton btn21 = new ViewButton();
		btn21.setName("我的预约");
		btn21.setType("view");
		btn21.setUrl(UrlHelper.bulidWinXinBackUrl("customer/myReservation"));
		
		ViewButton btn22 = new ViewButton();
		btn22.setName("我的投资");
		btn22.setType("view");
		btn22.setUrl(UrlHelper.bulidWinXinBackUrl("customer/myInvestment"));
		
		ViewButton btn23 = new ViewButton();
		btn23.setName("手机注册");
		btn23.setType("view");
		btn23.setUrl(UrlHelper.bulidWinXinBackUrl("customer/newRegister"));
		
		ViewButton btn24 = new ViewButton();
		btn24.setName("登录/注册");
		btn24.setType("view");
		btn24.setUrl(UrlHelper.bulidWinXinBackUrl("customer/login"));
		
		ViewButton btn31 = new ViewButton();
		btn31.setName("联系我们");
		btn31.setType("view");
		btn31.setUrl(UrlHelper.bulidWinXinBackUrl("product/productFeatures?name=connection"));
		
		ViewButton btn32 = new ViewButton();
		btn32.setName("关于我们");
		btn32.setType("view");
		btn32.setUrl(UrlHelper.bulidWinXinBackUrl("product/productFeatures?name=introduce"));
		
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("账户中心");
		mainBtn2.setSub_button(new Button[]{ btn21,btn22,btn23,btn24});
		
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("公司信息");
		mainBtn3.setSub_button(new Button[]{ btn31,btn32});
		
		Menu menu = new Menu();
		menu.setButton(new Button[]{btn11,mainBtn2,mainBtn3});
		
		return menu;
	}
	
	public String createMenu(){
		
		Token token = CommonUtil.getToken(Constant.APPID, Constant.APPSECRET);
		if(token!=null){
			//创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			if(result){
				log.info("菜单创建成功！");
				System.out.println("菜单创建成功！");
			}
			else {
				log.info("菜单创建失败！");
			}
		}
		return null;
	}
}
