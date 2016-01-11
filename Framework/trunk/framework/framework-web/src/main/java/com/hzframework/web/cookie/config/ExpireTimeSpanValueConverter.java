package com.hzframework.web.cookie.config;

import com.hzframework.helper.StringHelper;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

/**
 * Created by paul on 15-4-15.
 */
public class ExpireTimeSpanValueConverter extends AbstractSingleValueConverter {

    @Override
    public boolean canConvert(Class type) {
        return type.equals(int.class) || type.equals(Integer.class);
    }

    @Override
    public String toString(Object obj) {
        int second = Integer.parseInt(String.valueOf(obj));
        int day = second / 24 * 60 * 60;
        second = second % 24 * 60 * 60;

        int hour = second / 60 * 60;
        second = second % 60 * 60;

        int minute = second / 60;
        second = second % 60;

        return String.format("%02d.%02d:%02d:%02d", day, hour, minute, second);
    }

    @Override
    public Object fromString(String str) {
        String[] expireDaysAndTime = str.split("\\.");
        if (expireDaysAndTime.length != 2)
            return 0;

        int day = 0;
        if (StringHelper.canConvertToNumber(expireDaysAndTime[0])) {
            day = Integer.parseInt(expireDaysAndTime[0]);
        }

        String[] expireTime = expireDaysAndTime[1].split(":");
        if (expireTime.length != 3) {
            return day * 24 * 60 * 60;
        }

        int hour = 0;
        if (StringHelper.canConvertToNumber(expireTime[0])) {
            hour = Integer.valueOf(expireTime[0]);
        }

        int minute = 0;
        if (StringHelper.canConvertToNumber(expireTime[1])) {
            minute = Integer.valueOf(expireTime[1]);
        }

        int second = 0;
        if (StringHelper.canConvertToNumber(expireTime[2])) {
            second = Integer.valueOf(expireTime[2]);
        }

        return day * 24 * 60 * 60 + hour * 60 * 60 + minute * 60 + second;
    }
}
