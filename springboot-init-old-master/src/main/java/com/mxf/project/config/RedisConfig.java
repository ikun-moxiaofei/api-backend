package com.mxf.project.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置类
 * Created by mxf
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}