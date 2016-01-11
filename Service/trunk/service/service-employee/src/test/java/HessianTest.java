import com.caucho.hessian.client.HessianProxyFactory;
import com.hzfh.api.employee.model.Employee;
import com.hzfh.api.employee.service.EmployeeService;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by paul on 14-12-24.
 */
public class HessianTest {
    @Test
    public void hessianTest() throws MalformedURLException {//main(String[] args) throws MalformedURLException {
        //String url = "http://localhost:8080/hessian/productQuery";
//        String url = "http://192.168.1.232:8080/service-product/product";
    	String url = "http://localhost:8080/service-employee/employee";
        HessianProxyFactory factory = new HessianProxyFactory();
        EmployeeService employeeService = (EmployeeService) factory.create(EmployeeService.class, url);
        List<Employee> empList = employeeService.getList();
        for (Employee employee : empList) {
        	System.out.println(employee.getId() + ":========>"+ employee.getName()+":========>");
		}
        
        
    }
}
