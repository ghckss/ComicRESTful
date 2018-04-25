package com.triangle.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.filter.OncePerRequestFilter;
 
public class CorsFilter extends OncePerRequestFilter {
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE");
        response.addHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept, Origin, Content-Length, X-Requested-With");
        response.addHeader("Access-Control-Max-Age", "1728000");
        
        filterChain.doFilter(request, response);
    }
}