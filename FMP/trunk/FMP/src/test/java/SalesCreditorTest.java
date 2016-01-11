import com.hzfh.api.customer.model.CustomerPersonal;
import com.hzfh.api.customer.model.P2pCustomer;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.report.model.PaymentReport;
import com.hzfh.api.report.model.PaymentReportDeatil;
import com.hzfh.api.sales.model.Creditor;
import com.hzfh.api.sales.model.Sales;
import com.hzfh.api.sales.model.SalesCreditor;
import com.hzfh.fmp.model.common.enumeration.PaymentExamineStatusType;
import com.hzfh.fmp.model.common.helper.UserHelper;
import com.hzfh.fmp.model.customer.CustomerPersonalModel;
import com.hzfh.fmp.model.customer.P2pCustomerModel;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzfh.fmp.model.report.PaymentReportDeatilModel;
import com.hzfh.fmp.model.report.PaymentReportModel;
import com.hzfh.fmp.model.sales.CreditorModel;
import com.hzfh.fmp.model.sales.SalesCreditorModel;
import com.hzfh.fmp.model.sales.SalesModel;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2015/8/31.
 */
public class SalesCreditorTest {

    public static int distributionCreditor(int salesNo){
        Sales sales = SalesModel.getInfo(salesNo);
        double surplusSalesMoney = sales.getMoney();
        double salesCreditorMoney = 0;
        while(surplusSalesMoney!=0){
            Creditor creditor = CreditorModel.getInfoEffectiveByProductNo(sales.getProductNo());
            if(surplusSalesMoney > creditor.getRemainAmount()){ //未分配债权的金额 大于 房子可抵用的金额 （即不够分配）
                salesCreditorMoney = creditor.getRemainAmount(); //分配金额 为 房子的全款
                surplusSalesMoney = surplusSalesMoney-creditor.getRemainAmount(); //
            }else{ //未分配债权金额大于 房子可抵用的金额 （够分配）
                salesCreditorMoney = surplusSalesMoney; //分配金额为未分配全部债权的金额
                surplusSalesMoney = 0;
            }
            CreditorModel.updateRemainAmountById(creditor.getId(),salesCreditorMoney);
            SalesCreditor salesCreditor = new SalesCreditor();
            salesCreditor.setCreditorNo(creditor.getId());
            salesCreditor.setSalesNo(salesNo);
            salesCreditor.setMoney(salesCreditorMoney);
            salesCreditor.setCreditorName(creditor.getProjectName()+creditor.getRoomNumber());
            SalesCreditorModel.add(salesCreditor);
        }
        return 1;
    }


    @Test
    public void test(){

    }

}
