package com.hzfh.fmp.model.employee;

import com.hzfh.api.employee.model.Payment;
import com.hzfh.api.employee.model.query.PaymentCondition;
import com.hzfh.api.payment.model.PaymentRefund;
import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.fmp.facade.employee.PaymentFacade;
import com.hzfh.fmp.model.payment.PaymentRefundModel;
import com.hzframework.contract.PagedList;
import com.hzframework.helper.DateHelper;
import com.hzframework.helper.MathHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PaymentModel {
    public static PagedList<Payment> getPagingList(PaymentCondition paymentCondition) {
        return PaymentFacade.getPagingList(paymentCondition);
    }

    public static int add(Payment payment) {
        return PaymentFacade.add(payment);
    }

    public static int update(Payment payment) {
        return PaymentFacade.update(payment);
    }

    public static List<Payment> getList() {
        return PaymentFacade.getList();
    }

    public static Payment getInfo(int id) {
        return PaymentFacade.getInfo(id);
    }

}
