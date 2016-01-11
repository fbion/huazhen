package com.hzfh.o2o.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class UserCacheModel implements Serializable {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
