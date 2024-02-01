package com.mxf.project.util;


import com.mxf.project.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author mxf
 */
@Component
public class JwtUtils {

    /**
     * 自定义秘钥
     * */
    private static String sign;

    /**
     * jwtToken的默认有效时间 单位分钟
     * */
    private static int expireTime;

    @Value("${jwt.sign}")
    public void setSign(String sign1){
        JwtUtils.sign = sign1;
    }

    @Value("${jwt.expireTime}")
    public void setExpireTime(int expireTime1){
        JwtUtils.expireTime = expireTime1;
    }

    /**
     * 生成jwt token
     * @param map  要存放负载信息
     * */
    public static String createJwtToken(Map<String,Object> map){
        return  Jwts.builder()
                .setClaims(map) //放入payLoad部分的信息
                .signWith(SignatureAlgorithm.HS512,sign)
                .compact();

    }


    /**
     * 从令牌中获取数据,就是payLoad部分存放的数据。如果jwt被改，该函数会直接抛出异常
     * @param token  令牌
     * */
    public static Claims  parseToken(String token){
        System.out.println(token);
        return Jwts.parser()
                .setSigningKey(sign)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 验证用户信息
     * @param token  jwtToken
     * */
    public static User verifyJwtToken(String token){
        Claims claims = parseToken(token);
        System.out.println("claims:::"+claims.toString());
        String id = String.valueOf(claims.get("id"));
        System.out.println("id:::"+id);
        //从redis中获取用户信息
        Object user = RedisUtils.getValue(id);
        User user1 = (User) user;

        return user1 ;
    }


    /**
     * 刷新令牌时间，刷新redis缓存时间
     * @param  user 用户信息
     * */
    public static void refreshToken(User user){
        //重新设置User对象的过期时间，再刷新缓存
        user.setExpireTime(System.currentTimeMillis()+1000L * 60 * expireTime);
        RedisUtils.saveValue(user.getId()+"",user,expireTime,TimeUnit.MINUTES);
    }

    /**
     * 设置用户的登录时间和令牌有效时间
     * @param user
     * @return
     */
    public static User setTime(User user){
        user.setExpireTime(System.currentTimeMillis()+1000L * 60 * expireTime);
        user.setLoginTime(System.currentTimeMillis());
        return user;
    }
}