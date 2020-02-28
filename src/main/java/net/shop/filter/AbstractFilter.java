package net.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.shop.util.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AbstractFilter implements Filter {
	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI();
		if(UrlUtils.isMediaUrl(url) || UrlUtils.isStaticUrl(url)) {
			chain.doFilter(request, response);
		} else {
			doFilter(req, resp, chain);
		}
	}
	
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException; //? Как работает

	@Override
	public void destroy() {

	}
}
