package com.web01.demo.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CRS
 * 在web开发中，中文乱码是一个比较麻烦的事情，使用过滤器来统一编码是比较好的办法
 */
public class EncodingFilter implements Filter {
    private String encoding;
    private Map<String, String> params = new HashMap<String, String>();

    @Override
    public void destroy() {
        //System.out.println("end do the encoding filter!");
        params=null;
        encoding=null;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        //UtilTimerStack.push("EncodingFilter_doFilter:");
        //System.out.println("before encoding " + encoding + " filter");
        req.setCharacterEncoding(encoding);
        // resp.setCharacterEncoding(encoding);
        // resp.setContentType("text/html;charset="+encoding);
        chain.doFilter(req, resp);
        //System.out.println("after encoding " + encoding + " filter");
        //System.err.println("----------------------------------------");
        //UtilTimerStack.pop("EncodingFilter_doFilter:");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        //System.out.println("begin do the encoding filter!");
        //获取 web.xml 中的 config:  encoding
        encoding = config.getInitParameter("encoding");
        for (Enumeration e = config.getInitParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            String value = config.getInitParameter(name);
            params.put(name, value);
        }
    }
}