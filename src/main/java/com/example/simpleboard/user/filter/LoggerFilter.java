package com.example.simpleboard.user.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
@Component
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        // 진입 전
        // log.info(">>>>> 진입");

        // var req = new HttpServletRequestWrapper((HttpServletRequest) request);
        // var res = new HttpServletResponseWrapper((HttpServletResponse) request);

        // var req = new ContentCachingRequestWrapper((HttpServletRequest) request);
        // var res = new ContentCachingResponseWrapper((HttpServletResponse) response);

        // var br = req.getReader();
        // var list = br.lines().collect(Collectors.toList());

        /*
        list.forEach(it -> {
            log.info("{}", it);
        });
         */

        // chain.doFilter(req, res);

        // var reqJson = new String(req.getContentAsByteArray());
        // log.info("req : {}", reqJson);

        // var resJson = new String(res.getContentAsByteArray());
        // log.info("res : {}", resJson);

        // log.info("<<<<< 진입");
        // 진입 후

        // res.copyBodyToResponse();
    }


}
