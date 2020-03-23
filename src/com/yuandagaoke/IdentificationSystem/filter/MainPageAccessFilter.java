package com.yuandagaoke.IdentificationSystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:21
 */
//主要用来进行主页面访问权限的控制
@WebFilter(value = "/*")
public class MainPageAccessFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("AccessFilter start");
    }

}
