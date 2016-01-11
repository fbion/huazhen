package com.hzframework.io;

import com.hzframework.helper.StringHelper;

/**
 * Created by paul on 15-2-23.
 */
public class PathUtils {
    public static String GetExtensionName(String path){
        if (StringHelper.isNullOrEmpty(path))
        {
            return "";
        }

        int lastPos = path.lastIndexOf('.');
        if (lastPos == -1)
        {
            return path;
        }

        return path.substring(lastPos+1);
    }

    public static String GetDirectoryName(String path)
    {
        if (StringHelper.isNullOrEmpty(path))
        {
            return "";
        }

        int lastPos = path.lastIndexOf('/');
        if (lastPos == -1)
        {
            return path;
        }

        return path.substring(0, lastPos);
    }

    public static String GetFileName(String path)
    {
        if (StringHelper.isNullOrEmpty(path))
        {
            return "";
        }

        int lastPos = path.lastIndexOf('/');
        if (lastPos == -1)
        {
            return path;
        }

        return path.substring(lastPos+1);
    }

    public static String UrlPathCombine(String... pathArray)
    {
        if (pathArray == null || pathArray.length == 0)
        {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String path : pathArray)
        {
            if (!StringHelper.isNullOrEmpty(path))
            {
                if (sb.length() > 0)
                {
                    if (!path.startsWith("/"))
                    {
                        sb.append("/");
                    }
                }

                sb.append(path);
            }
        }

        return sb.toString();
    }

}
