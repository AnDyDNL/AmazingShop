package com.oracle.shop.web.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	private String encoding;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
				HttpServletRequest req=(HttpServletRequest)request;
				HttpServletResponse resp=(HttpServletResponse)response;
				req.setCharacterEncoding(encoding);	
				resp.setCharacterEncoding(encoding);
				resp.setContentType("text/html;charset=utf-8");
				arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		 encoding = config.getInitParameter("encoding");

	}

}
