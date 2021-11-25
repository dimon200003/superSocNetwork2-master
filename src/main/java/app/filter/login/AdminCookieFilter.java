package app.filter.login;


import app.entity.Admin;
import app.util.MyAdminUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "adminCookieFilter", urlPatterns = {"/adminlist", "/adminedit", "/admindelete", "/adminadd"})
public class AdminCookieFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        Admin adminInSession = MyAdminUtils.getLoginedAdmin(session);
        System.out.println(12321);
        if (adminInSession != null) {


            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;

        } else {
            request.getRequestDispatcher("/adminlogin").forward(request, response);
        }
        request.getRequestDispatcher("http://localhost:8080/superSocNetwork");


    }
}

