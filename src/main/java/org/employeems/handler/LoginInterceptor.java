package org.employeems.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.employeems.common.constant.MessageConstant;
import org.employeems.common.result.Result;
import org.employeems.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        // 获取请求头中的 Token
        String token = request.getHeader("Authorization");

        // 检查 Token 是否存在
        if (token == null || token.isEmpty()) {
            writeErrorResponse(response, Result.error(MessageConstant.TOKEN_NOT_EXIST));
            return false;
        }

        // 验证 Token 是否有效
        if (!JwtUtil.validateToken(token)) {
            writeErrorResponse(response, Result.error(MessageConstant.TOKEN_INVALID));
            return false;
        }

        // 如果验证通过，放行
        return true;
    }

    private void writeErrorResponse(HttpServletResponse response, Result<?> result) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(result);
        response.getWriter().write(jsonResult);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
