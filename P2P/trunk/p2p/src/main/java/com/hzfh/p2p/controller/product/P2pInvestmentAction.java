package com.hzfh.p2p.controller.product;

import com.hzfh.api.product.model.P2pProduct;
import com.hzfh.p2p.controller.common.CommonAction;
import com.hzfh.p2p.model.product.P2pProductModel;

/**
 * Created by Administrator on 2015/6/8.
 */
public class P2pInvestmentAction extends CommonAction {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private P2pProduct p2pProduct;

    public P2pProduct getP2pProduct() {
        return p2pProduct;
    }

    public void setP2pProduct(P2pProduct p2pProduct) {
        this.p2pProduct = p2pProduct;
    }
    @Override
    public String execute(){
        p2pProduct = P2pProductModel.getInfo(this.id);
        return SUCCESS;
    }
}
