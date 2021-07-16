package com.xxx.web.utils;

import com.xxx.web.domain.User;

import javax.servlet.http.HttpServletRequest;

public class RequestHolder {
    private static final ThreadLocal<User> SysUserHolder = new ThreadLocal<User>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(User SysUser) {
        SysUserHolder.set(SysUser);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static User getCurrentSysUser() {
        return SysUserHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        SysUserHolder.remove();
        requestHolder.remove();
    }
}