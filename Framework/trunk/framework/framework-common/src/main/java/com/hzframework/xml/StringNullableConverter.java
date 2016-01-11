package com.hzframework.xml;

import com.hzframework.helper.StringHelper;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

/**
 * Created by paul on 15-6-29.
 */
public class StringNullableConverter  extends AbstractSingleValueConverter {
    @Override
    public boolean canConvert(Class type) {
        return true;
    }

    @Override
    public Object fromString(String str) {
        if (StringHelper.isNullOrEmpty(str))
            return "";
        return str;
    }
}