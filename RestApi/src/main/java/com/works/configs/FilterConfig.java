package com.works.configs;

import com.works.entities.Info;
import com.works.repositories.InfoRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class FilterConfig implements Filter {

    final private InfoRepository infoRepo;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =  (HttpServletRequest) servletRequest;
        HttpServletResponse res =  (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        String sessionId = req.getSession().getId();
        String username = "";
        String role = "";
        String agent = req.getHeader("User-Agent");
        String ip = req.getRemoteAddr();
        long time = System.currentTimeMillis();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            username = auth.getName();
            role = auth.getAuthorities().toString();
        }

        Info i = new Info(null, url, sessionId, username, role, agent, ip, time);
        Runnable rn = () -> {
            infoRepo.save(i);
        };
        new Thread(rn).start();

        res.setHeader("session", sessionId);
        filterChain.doFilter(req,res);
    }


}
