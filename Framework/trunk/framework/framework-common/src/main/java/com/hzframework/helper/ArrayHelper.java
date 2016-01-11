package com.hzframework.helper;

import java.util.Collection;

/**
 * Created by paul on 15-2-11.
 */
public class ArrayHelper {
    public static <T> boolean isNullOrEmpty(Collection<T> tCollection) {
        if (tCollection == null || tCollection.size() == 0)
            return true;
        else
            return false;

    }
}
