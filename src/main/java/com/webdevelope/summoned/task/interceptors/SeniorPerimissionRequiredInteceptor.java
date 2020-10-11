package com.webdevelope.summoned.task.interceptors;

import com.webdevelope.summoned.task.annotations.SeniorPermissionRequired;
import com.webdevelope.summoned.task.exceptions.SeniorPermissionRequiredException;
import com.webdevelope.summoned.task.model.LoginToken;
import com.webdevelope.summoned.task.utils.CookieUtils;
import com.webdevelope.summoned.task.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author LingChen
 * Created on 2020-09-18
 */
public class SeniorPerimissionRequiredInteceptor implements HandlerInterceptor {

    private final String APPROVAL_TOKEN_NAME = "userIsLogIn";

    private final Logger logger = LoggerFactory.getLogger(SeniorPerimissionRequiredInteceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            System.out.println("SeniorPerimissionRequiredInteceptor enter log interceptor hnadler 233");
            SeniorPermissionRequired record = findAnnotation((HandlerMethod) handler, SeniorPermissionRequired.class);
            if(record != null){
                System.out.println("SeniorPerimissionRequiredInteceptor method has annotation!");
                String cookie = CookieUtils.getCookie(request, APPROVAL_TOKEN_NAME);
                if (isEmpty(cookie)) {
                    throw new SeniorPermissionRequiredException();
                }
                try {
                    LoginToken loginToken = JsonUtils.fromJson(new String(Base64.getDecoder().decode(cookie)), LoginToken.class);
                    logger.info("SeniorPerimissionRequiredInteceptor request record,url:{},method:{},user:{}",
                            request.getRequestURL()+"?"+request.getQueryString(),request.getMethod(), JsonUtils.toJson(loginToken));
//                    if(seniorUserIdSet.contains(loginToken.getUid())) {
//                        return true;
//                    }
//                    else{
//                        throw new SeniorPermissionRequiredException();
//                    }
                    return true;
                } catch (Exception e) {
                    logger.error("SeniorPerimissionRequiredInteceptor cookie解析失败，默认未登录"+e);
                    throw new SeniorPermissionRequiredException();
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
