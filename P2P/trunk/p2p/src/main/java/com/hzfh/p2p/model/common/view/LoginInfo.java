package com.hzfh.p2p.model.common.view;

import com.hzfh.api.customer.model.P2pCustomer;
import sunw.io.Serializable;

/**
 * Created by paul on 15-3-14.
 */
public class LoginInfo implements Serializable {
    private P2pCustomer p2pCustomer;
    private String userName;
    private int p2pCustomerId;

    public P2pCustomer getP2pCustomer() {
        return p2pCustomer;
    }

    public void setP2pCustomer(P2pCustomer p2pCustomer) {
        this.p2pCustomer = p2pCustomer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getP2pCustomerId() {
        return p2pCustomerId;
    }

    public void setP2pCustomerId(int p2pCustomerId) {
        this.p2pCustomerId = p2pCustomerId;
    }
}
