package com.hzframework.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.StringWriter;

/**
 * Created by paul on 15-6-8.
 */
public class XStreamHandler {
    public static String toXml(Object obj) {
        XStream xstream = new XStream(new DomDriver("utf8"));
        xstream.processAnnotations(obj.getClass()); // 识别obj类中的注解

        // 以压缩的方式输出XML
        StringWriter sw = new StringWriter();
        xstream.marshal(obj, new CompactWriter(sw));
        return sw.toString();

        // 以格式化的方式输出XML
        //return xstream.toXML(obj);
    }

    public static <T> T toBean(String xmlStr, Class<T> cls) {
        XStream xstream = new XStream(new DomDriver("utf8"));
        xstream.processAnnotations(cls);
       // xstream.ignoreUnknownElements();//忽略多余的xml节点 
        @SuppressWarnings("unchecked")
        T t = (T) xstream.fromXML(xmlStr);
        return t;
    }
}
