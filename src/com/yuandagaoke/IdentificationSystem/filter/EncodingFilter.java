package com.yuandagaoke.IdentificationSystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:16
 */
//主要用来进行乱码的转码
@WebFilter(value = "/ny/*",initParams = @WebInitParam(name = "encode",value = "UTF-8"))
public class EncodingFilter implements Filter {
    private String encode ;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对表单提交过来的中文进行过滤
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        request.setCharacterEncoding(encode);//只对请求正文中的文件有效,因而只对请求
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Encodeconfig start");
        encode = config.getInitParameter("encode");
    }

}
