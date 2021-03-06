package com.webdevelope.summoned.task.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-11
 */
public final class CookieUtils {
    public CookieUtils() {
    }

    public static String getCookie(HttpServletRequest request, String key) {
        return getCookie(request.getCookies(), key);
    }

    public static String getCookie(Cookie[] cookies, String key) {
        return ArrayUtils.isEmpty(cookies) ? null : (String) Stream.of(cookies).filter((c) -> {
            return StringUtils.equals(c.getName(), key);
        }).map(Cookie::getValue).findAny().orElse(null);
    }

    public static List<String> getCookies(HttpServletRequest request, String key) {
        return getCookies(request.getCookies(), key);
    }

    public static List<String> getCookies(Cookie[] cookies, String key) {
        return ArrayUtils.isEmpty(cookies) ? Collections.emptyList() : (List)Stream.of(cookies).filter((c) -> {
            return StringUtils.equals(c.getName(), key);
        }).map(Cookie::getValue).filter(StringUtils::isNotBlank).collect(Collectors.toList());
    }

    public static void saveCookie(HttpServletResponse response, String key, String value, int second, String domain, String path, boolean secure) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath(path);
        cookie.setMaxAge(second);
        if (StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
        }

        cookie.setHttpOnly(true);
        cookie.setSecure(secure);
        response.addCookie(cookie);
    }
}

