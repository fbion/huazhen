package com.hzframework.web.xml;

import com.hzframework.annotation.XmlPath;
import com.hzframework.cache.CacheManager;
import com.hzframework.config.ConfigWatchService;
import com.hzframework.config.EventsCallBack;
import com.hzframework.web.cookie.config.CookieConfig;
import com.hzframework.web.resources.config.css.CssConfig;
import com.hzframework.web.resources.config.script.ScriptConfig;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;


/**
 * Created by paul on 15-5-22.
 */
class ConfigWatcher implements Runnable {
    public void run() {
        try {

            //Map<String, String> pathMap = new HashMap<String, String>();
            List<String> pathList = new ArrayList<String>();

            final String cookiePath = XmlHelper.getAbsolutePath(CookieConfig.class.getAnnotation(XmlPath.class).value());
            //pathMap.put(CookieConfig.class.getName(), cookiePath);
            pathList.add(cookiePath);

            final String scriptPath = XmlHelper.getAbsolutePath(ScriptConfig.class.getAnnotation(XmlPath.class).value());
            //pathMap.put(ScriptConfig.class.getName(), scriptPath);
            pathList.add(scriptPath);

            final String cssPath = XmlHelper.getAbsolutePath(CssConfig.class.getAnnotation(XmlPath.class).value());
            //pathMap.put(CssConfig.class.getName(), cssPath);
            pathList.add(cssPath);

            new ConfigWatchService(pathList).handleEvents(new EventsCallBack() {
               
                public void ChangeEvent(String key) {
                    //File cookieConfig = new File(cookiePath);
                    if (cookiePath.equals(key)) {
                        CookieConfig t = XmlHelper.getXmlConfig(CookieConfig.class, cookiePath);
                        CacheManager.set(CookieConfig.class.getName(), 1000 * 60 * 60 * 24, t);
                        return;
                    }

                    //File scriptConfig = new File(scriptPath);
                    if (scriptPath.equals(key)) {
                        ScriptConfig t = XmlHelper.getXmlConfig(ScriptConfig.class, scriptPath);
                        CacheManager.set(ScriptConfig.class.getName(), 1000 * 60 * 60 * 24, t);
                        return;
                    }

                    //File cssConfig = new File(cssPath);
                    if (cssPath.equals(key)) {
                        CssConfig t = XmlHelper.getXmlConfig(CssConfig.class, cssPath);
                        CacheManager.set(CssConfig.class.getName(), 1000 * 60 * 60 * 24, t);
                        return;
                    }
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
