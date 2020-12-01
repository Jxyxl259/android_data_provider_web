package com.jiang.android.web.filter;

import com.jiang.android.entity.ThreadLocalReqAndResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class XssFilter
 */
public class XssFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Default constructor. 
     */
    public XssFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest)request);
		ThreadLocalReqAndResp.setRequest(xssRequest);
		ThreadLocalReqAndResp.setSession(((HttpServletRequest)request).getSession());
		chain.doFilter(xssRequest, response);
		ThreadLocalReqAndResp.closeRequest();
		ThreadLocalReqAndResp.closeSession();

		((HttpServletResponse) response).setHeader("Pragma","No-cache");
		((HttpServletResponse) response).setHeader("Cache-Control","no-cache");
		((HttpServletResponse) response).setDateHeader("Expires", 0);
	}

	/**
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
