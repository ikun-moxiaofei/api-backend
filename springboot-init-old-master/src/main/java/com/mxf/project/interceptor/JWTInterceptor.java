package com.mxf.project.interceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mxf.project.model.entity.User;
import com.mxf.project.util.JwtUtils;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengmq
 * @date 2021年06月24日 17:16
 * Jwt拦截器
 */
public class JWTInterceptor implements HandlerInterceptor {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        Map<Object, Object> map = new HashMap<>();
        //如果是OPTIONS请求 直接放行
        String method = request.getMethod();
        try {
            if(method.equals("OPTIONS")){
                return  true;
            }
            //从请求中获取令牌
            String jwtToken = request.getHeader(tokenHeader);
            if(String.valueOf(jwtToken).equals("null")){
                throw new SignatureException("令牌不合法");
            }

            if (jwtToken.startsWith(tokenHead)){
                jwtToken = jwtToken.substring(tokenHead.length());// The part after "Bearer " 前端的安全规则会在token前自动生成 Bearer 字符串前缀,共7个字符,需要删掉
            }

            //验证token
            User user  = JwtUtils.verifyJwtToken(jwtToken);
//            System.out.println("user:::);
            //验证成功后,如果令牌有效时间<=5分钟,则签发新的令牌,刷新令牌时间
            if(user != null){
                if(user.getExpireTime() - System.currentTimeMillis() <= 1000L * 60 * 5){
                    JwtUtils.refreshToken(user);
                }
                return  true ;
            }else{
                map.put("success",false);
                map.put("code",401);
                map.put("message","令牌已失效,请重新登录");
            }
        }catch(SignatureException e){
            e.printStackTrace();
            map.put("message","令牌不合法");
            map.put("code",401);
            map.put("success",false);
        }catch (Exception e) {
            e.printStackTrace();
            map.put("message","令牌验签失败:"+e.getMessage());
            map.put("success",false);
        }
        String jsonMap = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(jsonMap);
        return false;
    }
}