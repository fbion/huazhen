package com.hzframework.web.xml;

import com.hzframework.cache.CacheManager;
import com.hzframework.helper.StringHelper;
import com.hzframework.annotation.XmlPath;
import com.thoughtworks.xstream.XStream;

import java.io.*;

/**
 * Created by paul on 15-4-15.
 */
public class XmlHelper {

    static {
        ConfigWatcher configWatcher = new ConfigWatcher();
        Thread thread = new Thread(configWatcher);
        thread.start();
    }

    private static <T> T getSingleConfig(Class<T> c, String path) {

        File file = new File(path);

        T t;
        try {
            InputStream input = new FileInputStream(file);
            XStream stream = new XStream(new AnnotationJavaReflectionProvider());
            stream.alias("root", c);
            stream.processAnnotations(c);
            t = (T) stream.fromXML(input);
        } catch (FileNotFoundException e1) {
            t = null;
        } finally {

        }
        return t;
    }

    private static <T extends Object> T getMultiConfig(Class<T> c, String path) {
        File file = new File(path);
        try {
            T t = c.newInstance();

            File[] files = file.listFiles();

            if (files == null)
                return null;

            for (File f : files) {
                if (f.isDirectory())
                    continue;
                if (!f.getName().toLowerCase().endsWith(".xml"))
                    continue;

                InputStream input = new FileInputStream(f);

                XStream stream = new XStream(new AnnotationJavaReflectionProvider());
                stream.alias("root", c);
                stream.processAnnotations(c);
                t = (T) stream.fromXML(input, t);
            }
            return t;
        } catch (FileNotFoundException e) {
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T getConfig(Class<T> c) {
        String key = c.getName();
        T t = CacheManager.get(key, c);
        if (t != null)
            return t;

        System.out.println("not hit cache");

        String path = getAbsolutePath(c.getAnnotation(XmlPath.class).value());

        t = getXmlConfig(c, path);
        CacheManager.set(key, 1000 * 60 * 60 * 24, t);
        return t;
    }

    static String getAbsolutePath(String path) {
        String rootPath = XmlHelper.class.getResource("/").getPath();
        if (rootPath.contains(":"))
            rootPath = StringHelper.trimStart(rootPath,"/");
        return StringHelper.trimEnd(rootPath, "/") + "/../../" + path;
//        String temp = StringHelper.trimEnd(rootPath, "/");
//        temp = temp.substring(0, temp.lastIndexOf("/"));
//        return temp.substring(0, temp.lastIndexOf("/"))+"/" + path;
    }

    static <T> T getXmlConfig(Class<T> c, String path) {
        if (path.endsWith("*.xml"))
            return getMultiConfig(c, path.substring(0, path.lastIndexOf("/")));
        else
            return getSingleConfig(c, path);
    }

//    private static <T> void startWatch(final Class<T> c, final String path) {
//        try {
//            new ConfigWatchService(path).handleEvents(new EventsCallBack() {
//                @Override
//                public void ChangeEvent(String fileName) {
//                    File file = new File(path);
//                    if (file.getName().equals(fileName) || file.getName().equals("*.xml")) {
//                        T t = getXmlConfig(c, path);
//                        CacheManager.set(c.getName(), 1000 * 60 * 60 * 24, t);
//                    }
//                }
//            });
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
