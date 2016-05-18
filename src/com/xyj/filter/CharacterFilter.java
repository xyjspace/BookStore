package com.xyj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter {
	
	private FilterConfig fc;

	public void init(FilterConfig fc) throws ServletException {
		this.fc = fc;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain ch)
			throws IOException, ServletException {
		String encoding = fc.getInitParameter("encoding");
		if(encoding==null){
			encoding = "utf-8";
		}
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=UTF-8");
		ch.doFilter(request, response);
	}
	
	public void destroy() {

	}

}
