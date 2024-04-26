package com.foodPlanet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // @Configuration : 이 파일은 설정용으로 사용되는 파일입니다.(필수로 적어야 함)
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Override // Cors 교차 출처 리소스 공유 정책
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("OPTIONS", "GET", "PUT", "POST", "DELETE");

    }

}
