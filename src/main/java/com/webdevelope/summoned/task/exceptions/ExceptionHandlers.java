package com.webdevelope.summoned.task.exceptions;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.webdevelope.summoned.task.utils.JsonUtils;
import com.webdevelope.summoned.task.utils.WebResultUtil;
import com.webdevelope.summoned.task.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.common.base.Throwables;
import com.google.common.collect.Maps;

/**
 * Spring 全局异常处理器
 * <p>
 * Write the code. Change the world.
 *
 * @author LingChen
 */
@RestControllerAdvice
public class ExceptionHandlers {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ResponseBody
    @ExceptionHandler(SeniorPermissionRequiredException.class)
    public ResponseEntity<String> seniorPermissionRequiredHandler(){
        return WebResultUtil.buildResult(ResponseVo.permissionDenied("您还未登录！"), HttpStatus.FORBIDDEN);
    }

    @ResponseBody
    @ExceptionHandler(AdminPermissionRequiredException.class)
    public ResponseEntity<String> adminPermissionRequiredHandler(){
        return WebResultUtil.buildResult(ResponseVo.permissionDenied("您需要管理员权限来执行此操作！"), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleThrowable(HttpServletRequest request, Throwable e) {
        printStackTrace(request, e);
        Throwable rootCause = Throwables.getRootCause(e);
        return WebResultUtil.buildResult(ResponseVo.fail(rootCause),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 打印异常信息
     */
    private void printErrorMsg(Throwable e) {
        logger.error("handle:{}, msg:{}", e.getClass().getName(), e.getMessage());
    }

    /**
     * 打印异常信息和入参
     */
    private void printErrorMsg(HttpServletRequest request, Throwable e) {
        Map<String, String[]> params = request.getParameterMap();
        Map<String, Object> map = Maps.transformValues(
                params, arr -> (arr == null || arr.length == 0) ? null : arr.length == 1 ? arr[0] : arr
        );
        logger.error("handle:{}, msg:{}, params:{}", e.getClass().getName(), e.getMessage(), JsonUtils.toJson(map));
    }

    /**
     * 打印异常堆栈和入参
     */
    private void printStackTrace(HttpServletRequest request, Throwable e) {
        Map<String, String[]> params = request.getParameterMap();
        Map<String, Object> map = Maps.transformValues(
                params, arr -> (arr == null || arr.length == 0) ? null : arr.length == 1 ? arr[0] : arr
        );
        logger.error("handle:{},  msg: {}, params:{}", e.getClass().getName(), e.getMessage(), JsonUtils.toJson(map), e);
    }

}