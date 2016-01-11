package com.hzframework.web.resources.config;

import java.util.Comparator;

/**
 * Created by paul on 14-12-31.
 */
public class ComparatorResource<T extends BaseItem> implements Comparator {
    public int compare(Object arg0, Object arg1) {
        T t0 = (T) arg0;
        T t1 = (T) arg1;

        int flag = t0.getOrder() > t1.getOrder() ? 1 : 0;

        return flag;
    }
}
