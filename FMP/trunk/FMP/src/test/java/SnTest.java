import com.hzfh.api.workFlow.service.ActHiProcinstService;
import com.hzfh.fmp.model.employee.EmployeeModel;
import com.hzfh.fmp.model.workFlow.ActHiProcinstModel;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzfh.api.baseInfo.model.helper.SnEnum;
import com.hzfh.api.baseInfo.service.SnService;

import java.util.ArrayList;
import java.util.List;


public class SnTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/hessian-baseInfo.xml");
		SnService snService = (SnService) context.getBean("snService");
		System.out.println(snService.getSn(SnEnum.SN_ENTERPRISEREGISTER));
	}
	@Test
	public void test2(){
		System.out.println(Byte.valueOf("1"));
	}

	@Test
	public void test3(){
		List<Integer> leaderList = new ArrayList<>();
		leaderList = getLeaderList(1001,leaderList);
		for (int empployeeNo:leaderList){
			System.out.println(empployeeNo);
		}
	}


	public List<Integer> getLeaderList(int empNo,List<Integer> leaderList){
		int leaderNo = EmployeeModel.getInfo(empNo).getParentNo();
		leaderList.add(leaderNo);
		if(leaderNo != 0){
			getLeaderList(leaderNo,leaderList);
		}
		return leaderList;
	}

	@Test
	public void getHiTaskinstPa(){
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ActHiProcinstService atHiProcinstService = (ActHiProcinstService)context.getBean("actHiProcinstService");
		atHiProcinstService.getInfo(687634);*/
		ActHiProcinstModel.getInfo(687634);
	}

}
