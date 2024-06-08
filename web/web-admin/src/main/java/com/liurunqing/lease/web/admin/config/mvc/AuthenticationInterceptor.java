package com.liurunqing.lease.web.admin.config.mvc;

import com.liurunqing.lease.common.context.AdminUser;
import com.liurunqing.lease.common.context.AdminUserContext;
import com.liurunqing.lease.common.exception.LeaseException;
import com.liurunqing.lease.common.result.ResultCodeEnum;
import com.liurunqing.lease.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("access_token");
        if (token == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        } else {
            Claims claims = JwtUtil.parseToken(token);
            AdminUser user = new AdminUser();
            user.setUserId(claims.get("userId", Long.class));
            user.setUsername(claims.get("username", String.class));
            AdminUserContext.set(user);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AdminUserContext.remove();
    }
}
