package com.hzframework.helper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by paul on 15-1-6.
 */
public class PropertyHelper  extends  PropertyPlaceholderConfigurer {

    private static Map<String, Object> ctxPropertiesMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        ctxPropertiesMap = new HashMap<String, Object>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    public static Object getContextProperty(String name) {
        return ctxPropertiesMap.get(name);
    }
    
    public static String getParamProperty(String key){
    	InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/params.properties");
    	Properties p = new Properties();
    	try {
    		p.load(inputStream);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return p.getProperty(key);
    }
}