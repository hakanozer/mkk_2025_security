package com.works.configs;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession() != null) {
            request.changeSessionId();
        }

        String url = request.getRequestURI();
        String[] urls = {"/", "/login"};
        boolean loginStatus = false;
        for (String item : urls) {
            if (item.equals(url)) {
                loginStatus = true;
                break;
            }
        }

        if (loginStatus) {
            // session control - yapma
            filterChain.doFilter(request, servletResponse);
        }else {
            // session control - yap
            Object loginObj = request.getSession().getAttribute("user");
            if (loginObj != null) {
                filterChain.doFilter(request, servletResponse);
            }else {
                response.sendRedirect("/");
            }
        }

    }

}

// SMS ->
// 12345 -> jkhj34h53kj4h53k4
// 12345 -> 12345
