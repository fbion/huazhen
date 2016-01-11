package com.hzframework.helper;

import java.util.List;

/**
 * Created by paul on 15-1-7.
 */
public class StringHelper {
    public static boolean isNullOrEmpty(String str) {
        if (str == null)
            return true;
        if (str.isEmpty())
            return true;
        return false;
    }

    public static String initialToUpperName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);

    }

    public static String listToString(List list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 == list.size()) {
                result += list.get(i).toString();
            } else {
                result += list.get(i).toString() + ",";
            }
        }
        return result;
    }

    public static String trimEnd(String src, String trimString) {
        if (StringHelper.isNullOrEmpty(src))
            return null;

        if (src.endsWith(trimString)) {
            return src.substring(0, src.lastIndexOf(trimString));
        } else
            return src;
    }

    public static String trimStart(String src, String trimString) {
        if (StringHelper.isNullOrEmpty(src))
            return null;

        if (src.startsWith(trimString)) {
            return src.substring(trimString.length());
        } else
            return src;
    }

    public static String join(String separator, String[] stringarray)
    {
        if (stringarray == null)
            return null;
        else
            return join(separator, stringarray, 0, stringarray.length);
    }

    public static String join(String separator, String[] stringarray, int startindex, int count)
    {
        String result = "";

        if (stringarray == null)
            return null;

        for (int index = startindex; index < stringarray.length && index - startindex < count; index++)
        {
            if (separator != null && index > startindex)
                result += separator;

            if (stringarray[index] != null)
                result += stringarray[index];
        }

        return result;
    }

    public static String trimEnd(String string, Character... charsToTrim)
    {
        if (string == null || charsToTrim == null)
            return string;

        int lengthToKeep = string.length();
        for (int index = string.length() - 1; index >= 0; index--)
        {
            boolean removeChar = false;
            if (charsToTrim.length == 0)
            {
                if (Character.isWhitespace(string.charAt(index)))
                {
                    lengthToKeep = index;
                    removeChar = true;
                }
            }
            else
            {
                for (int trimCharIndex = 0; trimCharIndex < charsToTrim.length; trimCharIndex++)
                {
                    if (string.charAt(index) == charsToTrim[trimCharIndex])
                    {
                        lengthToKeep = index;
                        removeChar = true;
                        break;
                    }
                }
            }
            if ( ! removeChar)
                break;
        }
        return string.substring(0, lengthToKeep);
    }

    public static String trimStart(String string, Character... charsToTrim)
    {
        if (string == null || charsToTrim == null)
            return string;

        int startingIndex = 0;
        for (int index = 0; index < string.length(); index++)
        {
            boolean removeChar = false;
            if (charsToTrim.length == 0)
            {
                if (Character.isWhitespace(string.charAt(index)))
                {
                    startingIndex = index + 1;
                    removeChar = true;
                }
            }
            else
            {
                for (int trimCharIndex = 0; trimCharIndex < charsToTrim.length; trimCharIndex++)
                {
                    if (string.charAt(index) == charsToTrim[trimCharIndex])
                    {
                        startingIndex = index + 1;
                        removeChar = true;
                        break;
                    }
                }
            }
            if ( ! removeChar)
                break;
        }
        return string.substring(startingIndex);
    }

    public static String trim(String string, Character... charsToTrim)
    {
        return trimEnd(trimStart(string, charsToTrim), charsToTrim);
    }

    public static boolean stringsEqual(String s1, String s2)
    {
        if (s1 == null && s2 == null)
            return true;
        else
            return s1 != null && s1.equals(s2);
    }

    public static boolean canConvertToNumber(String str){
        if(!StringHelper.isNullOrEmpty(str) && str.matches("[0-9]+")){
            return true;
        }else{
            return false;
        }
    }

    public static String turnSQLVariable(String variable){
        String result="";
        for (int i = 0; i < variable.length(); i++) {
            char c = variable.charAt(i);
            if (Character.isUpperCase(c)){
                result = result + "_" + Character.toLowerCase(c);
            }
            else{
                result +=c;
            }
        }
        return result;
    }

}
