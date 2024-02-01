package com.mxf.project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    private static RedisUtils redisUtils ;

    @PostConstruct
    public void init(){
        redisUtils = this ;
        redisUtils.redisTemplate = this.redisTemplate ;
    }

    /**
     * redis存入数据
     * @param key 键名
     * @param value  值
     * @param time 保存时间
     * @param timeUnit  时间单位
     * */
    public static void saveValue(String key, Object value, int time, TimeUnit timeUnit){
        redisUtils.redisTemplate.opsForValue().set(key,value,time,timeUnit);
    }

    /**
     * 获取redis中的值
     * @param key 键名
     * */
    public static Object getValue(String key){
        return redisUtils.redisTemplate.opsForValue().get(key);
    }


}