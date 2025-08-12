package com.works.configs;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getSession() != null) {
            request.changeSessionId();
        }
        filterChain.doFilter(request, servletResponse);
    }

}
