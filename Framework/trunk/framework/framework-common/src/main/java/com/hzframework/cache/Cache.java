package com.hzframework.cache;

import java.sql.Timestamp;

/**
 * Created by paul on 15-2-12.
 */
public class Cache {
    private String key;//cache ID
    private Object value;//cache data
    private Timestamp expireTime;//Expiration time

    public Cache() {
        super();
    }

    public Cache(String key, Object value, Timestamp expireTime) {
        this.key = key;
        this.value = value;
        this.expireTime = expireTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }
}
