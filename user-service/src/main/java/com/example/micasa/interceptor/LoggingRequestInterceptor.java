package com.example.micasa.interceptor;

import com.example.micasa.constants.UserServiceConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Slf4j
public class LoggingRequestInterceptor implements HandlerInterceptor {
    private static final String CORRELATION_ID_LOG_VAR_NAME = "correlationId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String correlationId = request.getHeader(UserServiceConstants.CORRELATION_ID_HEADER_NAME);
        if(null == correlationId)
        {
            correlationId = UUID.randomUUID().toString();
            log.info("No correlation-id present in headers, generated new correlation-id: {}",correlationId);
        }
        MDC.put(CORRELATION_ID_LOG_VAR_NAME, correlationId);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
