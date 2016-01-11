package com.hzframework.web.xml;

import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;

import java.lang.reflect.Field;

/**
 * Created by paul on 14-12-31.
 */
public class AnnotationJavaReflectionProvider extends PureJavaReflectionProvider {
    @Override
    public void writeField(Object object, String fieldName, Object value, Class definedIn) {
        Field field = fieldDictionary.field(object.getClass(), fieldName, definedIn);
        validateFieldAccess(field);
        try {
            if (value instanceof String)
                field.set(object, ((String)value).trim());
            else field.set(object, value);
        } catch (IllegalArgumentException e) {
            throw new ObjectAccessException("Could not set field " + object.getClass() + "." + field.getName(), e);
        } catch (IllegalAccessException e) {
            throw new ObjectAccessException("Could not set field " + object.getClass() + "." + field.getName(), e);
        }
    }
}