package com.foodPlanet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // JPA Audit 기능을 사용하겠습니다.
public class AuditConfig {
    @Bean // 등록자, 수정자, 등록 시간, 수정 시간 등을 처리해주는 AuditorAware 구현체를 Bean으로 등록 시켜 줍니다.
    public AuditorAware<String> auditorProvider(){
        return new AuditorAwareImpl();
    }
}
