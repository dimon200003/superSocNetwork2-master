package app.util;

import app.entity.Admin;


import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class MyAdminUtils {


    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

    private static final String ATT_NAME_ADMIN_LOGIN = "ATTRIBUTE_FOR_STORE_ADMIN_LOGIN_IN_COOKIE";

    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }


    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }


    public static void storeLoginedAdmin(HttpSession session, Admin loginedAdmin) {
        session.setAttribute("loginedAdmin", loginedAdmin);
        System.out.println("logined");
    }


    public static Admin getLoginedAdmin(HttpSession session) {
        Admin loginedAdmin = (Admin) session.getAttribute("loginedAdmin");
        System.out.println("logined121");
        return loginedAdmin;
    }


    public static void storeAdminCookie(HttpServletResponse response, Admin admin) {
        System.out.println("Store user cookie");
        Cookie cookieAdminLogin = new Cookie(ATT_NAME_ADMIN_LOGIN, admin.getAdminLogin());
        cookieAdminLogin.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieAdminLogin);
    }

    public static String getAdminLoginInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_ADMIN_LOGIN.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void deleteAdminCookie(HttpServletResponse response) {
        Cookie cookieAdminLogin = new Cookie(ATT_NAME_ADMIN_LOGIN, null);

        cookieAdminLogin.setMaxAge(0);
        response.addCookie(cookieAdminLogin);
    }
}
