package br.org.transportar.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(value = {"/import/*", "/operation/*", "/register/*", "/report/*", "/home.jsf"})
public class AuthenticationUserFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            
            try {
                boolean auth = httpRequest.getSession().getAttribute(SessionContext.KEY) != null;
                if (!auth && !httpRequest.getRequestURL().toString().contains("login.jsf") ) {
                    SessionContext.logoutContext();                    
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsf");
                } else {
                    httpResponse.setHeader("Expires", "Sat, 1 Jan 1990 12:00:00 GMT");
                    httpResponse.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
                    httpResponse.addHeader("Cache-Control", "post-check=0, pre-check=0");
                    httpResponse.setHeader("Pragma", "no-cache");
                    chain.doFilter(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	
}
