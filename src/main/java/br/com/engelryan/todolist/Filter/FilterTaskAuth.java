package br.com.engelryan.todolist.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //Get User and Password for Auth
        var authorization  = request.getHeader("Authorization");
        System.out.println("Authorization: " + authorization);





        filterChain.doFilter(request, response);

        //Validate User

        //Validate Password


    }
}
