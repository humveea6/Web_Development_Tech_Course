package com.webdevelope.summoned.task.interceptors;

import com.webdevelope.summoned.task.annotations.AdminPermissionRequired;
import com.webdevelope.summoned.task.annotations.SeniorPermissionRequired;
import com.webdevelope.summoned.task.exceptions.AdminPermissionRequiredException;
import com.webdevelope.summoned.task.exceptions.SeniorPermissionRequiredException;
import com.webdevelope.summoned.task.model.LoginToken;
import com.webdevelope.summoned.task.service.UserInfoService;
import com.webdevelope.summoned.task.utils.CookieUtils;
import com.webdevelope.summoned.task.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Base64;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author LingChen
 * Created on 2020-09-18
 */
public class AdminPerimissionRequiredInteceptor implements HandlerInterceptor {

    private final String APPROVAL_TOKEN_NAME = "userIsLogIn";

    private final Logger logger = LoggerFactory.getLogger(AdminPerimissionRequiredInteceptor.class);

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            logger.info("AdminPerimissionRequiredInteceptor enter log interceptor hnadler 233");
            AdminPermissionRequired record = findAnnotation((HandlerMethod) handler, AdminPermissionRequired.class);
            if(record != null){
                logger.info("AdminPerimissionRequiredInteceptor method has annotation!");
                String cookie = CookieUtils.getCookie(request, APPROVAL_TOKEN_NAME);
                logger.info("cookie :"+JsonUtils.toJson(cookie));
                if (isEmpty(cookie)) {
                    throw new AdminPermissionRequiredException();
                }
                try {
                    LoginToken loginToken = JsonUtils.fromJson(new String(Base64.getDecoder().decode(cookie)), LoginToken.class);
                    logger.info("AdminPerimissionRequiredInteceptor request record,url:{},method:{},user:{}",
                            request.getRequestURL()+"?"+request.getQueryString(),request.getMethod(), JsonUtils.toJson(loginToken));

                    return userInfoService.isAdmin(loginToken.getUserId());
                } catch (Exception e) {
                    logger.error("AdminPerimissionRequiredInteceptor cookie解析失败，默认未登录"+e);
                    throw new AdminPermissionRequiredException();
                }
            }
            else{
                System.out.println("method has no annotation 233333!");
                return true;
            }
        }
        return true;
    }

    private <T extends Annotation> T findAnnotation(HandlerMethod handler, Class<T> annotationType) {
        T annotation = handler.getBeanType().getAnnotation(annotationType);
        if (annotation != null) {
            return annotation;
        }
        return handler.getMethodAnnotation(annotationType);
    }
}
