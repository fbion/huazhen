package com.hzframework.web.cookie;

import com.hzframework.helper.StringHelper;
import com.hzframework.web.config.Config;
import com.hzframework.web.cookie.config.CookieConfig;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by paul on 15-4-15.
 */
public class CookieManager {
    private String topDomain;

    public CookieManager(String topDomain) {
        this.topDomain = topDomain;
    }

    private Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }

        return null;
    }

    public String getCookieValues(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);
        if (cookie == null)
            return null;
        return cookie.getValue();
    }

    public void setCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);

        CookieConfig cookieConfig = Config.getCookieConfig();
        if (cookieConfig != null) {
            com.hzframework.web.cookie.config.Cookie cookieInfo = cookieConfig.getCookeInfo(name);
            if (cookieInfo != null) {
                cookie.setSecure(cookieInfo.isSecureOnly());
                if (!StringHelper.isNullOrEmpty(this.topDomain) && cookieInfo.isTopLevelDomain())
                    cookie.setDomain(this.topDomain);
                if (cookieInfo.getExpiresAfter() != 0)
                    cookie.setMaxAge(cookieInfo.getExpiresAfter());
                cookie.setPath(cookieInfo.getPath());
            }
        }
        response.addCookie(cookie);
    }

    //
//    public void setCookie(HttpServletResponse response, String name, String value, String path, boolean secure) {
//        Cookie cookie = new Cookie(name, value);
//        cookie.setPath(path);
//        cookie.setSecure(secure);
//        response.addCookie(cookie);
//    }
//
//    public void setCookie(HttpServletResponse response, String name, String value, int maxAge, String path, boolean secure) {
//        Cookie cookie = new Cookie(name, value);
//        cookie.setPath(path);
//        cookie.setMaxAge(maxAge);
//        cookie.setSecure(secure);
//        response.addCookie(cookie);
//    }
//
//    public void setCookie(HttpServletResponse response, String name, String value, String domain, String path, boolean secure) {
//        Cookie cookie = new Cookie(name, value);
//        cookie.setPath(path);
//        cookie.setDomain(domain);
//        cookie.setSecure(secure);
//        response.addCookie(cookie);
//    }
//
//    public void setCookie(HttpServletResponse response, String name, String value, int maxAge, String domain, String path, boolean secure) {
//        Cookie cookie = new Cookie(name, value);
//        cookie.setPath(path);
//        cookie.setDomain(domain);
//        cookie.setMaxAge(maxAge);
//        cookie.setSecure(secure);
//        response.addCookie(cookie);
//    }
//
    public void deleteAllCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return;

        CookieConfig cookieConfig = Config.getCookieConfig();

        for (Cookie cookie : cookies) {
            com.hzframework.web.cookie.config.Cookie cookieInfo = cookieConfig.getCookeInfo(cookie.getName());
            if (cookieInfo != null) {
                cookie.setPath(cookieInfo.getPath());
                if (!StringHelper.isNullOrEmpty(this.topDomain) && cookieInfo.isTopLevelDomain())
                    cookie.setDomain(this.topDomain);
                cookie.setSecure(cookieInfo.isSecureOnly());
            }
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    public void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, "");

        CookieConfig cookieConfig = Config.getCookieConfig();
        if (cookieConfig != null) {
            com.hzframework.web.cookie.config.Cookie cookieInfo = cookieConfig.getCookeInfo(name);
            if (cookieInfo != null) {
                cookie.setSecure(cookieInfo.isSecureOnly());
                if (!StringHelper.isNullOrEmpty(this.topDomain) && cookieInfo.isTopLevelDomain())
                	cookie.setDomain(this.topDomain);
                cookie.setPath(cookieInfo.getPath());
            }
        }
        cookie.setMaxAge(0);
        response.addCookie(cookie);

    }
}
