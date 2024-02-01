package com.mxf.project.config;

import com.mxf.project.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengmq
 * @date 2021年06月24日 17:45
 * 拦截器配置文件
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private List<String> urls = new ArrayList<>();


    /**
     * 添加拦截器的方式，可直接new一个对象，
     * registry.addInterceptor(new ParamInterceptor())，
     * 但通过手动new出来的拦截器中，无法使用@Autowired 和 @Value 加载对象和配置文件参数。
     *
     * 所以需要在添加拦截器此处，通过@Bean 注解，意味着将这个对象
     * 交给spring管理。那么该拦截器才可以使用@Value等spring管理的注解
     * @return
     */
    @Bean
    public JWTInterceptor jwtInterceptor(){
        return new JWTInterceptor();
    }

    /**
     * 注册拦截器
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        urls = ignoreUrlsConfig().getUrls();
        System.out.println(ignoreUrlsConfig().getUrls());
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**") //拦截的地址
                .excludePathPatterns(urls); //不需要拦截的地址，如登录接口
    }


    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }
}