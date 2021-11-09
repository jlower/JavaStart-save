package com.lowo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author lowo
 * @Email
 * @Date 2021/11/6
 * @Description JavaStart
 */
public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println(1);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(2);
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("username"));
        System.out.println(filterConfig.getInitParameter("url"));
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * doFilter方法,专门用于拦截请求。可以做权限检查
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(3);
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        // 如果等于 null，说明还没有登录
        if (user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }
        else {
            //让程序继续往下走
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println(4);
    }
}
