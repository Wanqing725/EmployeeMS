package org.employeems.handler;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.employeems.common.result.Result;
import org.employeems.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BaseException.class)
    public Result baseExceptionHandler(BaseException e) {
        log.error("异常信息:{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 捕获@Validated注解校验异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> errorMessages = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }
        log.error("异常信息:{}", errorMessages.toString());
        return Result.error(errorMessages.toString());
    }

//    /**
//     * 捕获Jwt过滤器异常
//     *
//     * @param e
//     * @return
//     */
//    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(JwtTokenAuthenticationFilterException.class)
//    public Result JwtTokenAuthenticationFilterExceptionHandler(JwtTokenAuthenticationFilterException e) {
//        log.error("异常信息:{}", e.getMessage());
//        return Result.error(e.getMessage());
//    }

//    /**
//     * 捕获Jwt拦截器异常
//     *
//     * @param e
//     * @return
//     */
//    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(JwtTokenInterceptorException.class)
//    public Result JwtTokenInterceptorExceptionHandler(JwtTokenInterceptorException e) {
//        log.error("异常信息:{}", e.getMessage());
//        return Result.error(e.getMessage());
//    }

    /**
     * 捕获身份验证异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public Result authenticationExceptionHandler(AuthenticationException e) {
        log.error("身份验证异常:{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 捕获权限不足异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public Result accessDeniedExceptionHandler(AccessDeniedException e) {
        log.error("权限不足异常:{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 其它异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e, HttpServletRequest request) {
        log.error("异常信息:{}", e.getMessage());
        log.error("异常路径:{}", request.getRequestURI());
        return Result.error("服务器内部错误，请联系管理员");
    }
}
