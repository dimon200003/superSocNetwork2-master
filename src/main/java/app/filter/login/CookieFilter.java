package app.filter.login;


import app.entity.User;
import app.util.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/userlist", "/useradd", "/useredit" , "/userdelete" })
    public class CookieFilter implements Filter {

    public CookieFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User userInSession = MyUtils.getLoginedUser(session);
        System.out.println(12321);
        if (userInSession != null) {

//            request.getRequestDispatcher("/login").forward(request, response);
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;

        } else {
            request.getRequestDispatcher("/login").forward(request, response);
        }
        request.getRequestDispatcher("http://localhost:8080/superSocNetwork");


    }
}