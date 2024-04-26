//package com.foodPlanet.config;
//
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.util.Optional;
//
//// AuditorAware : 감사(audit) 정보를 캡쳐하기 위하여 JPA에서 제공해주는 인터페이스
//public class AuditorAwareImpl implements AuditorAware<String> {
//    @Override
//    public Optional<String> getCurrentAuditor() {
//        // SecurityContextHolder : 현재 접속자의 보안 관련 정보를 저장하고 관리해주는 역할을 합니다.
//        // 인증 정보 및 권한 정보를 전역적으로 접근할 수 있습니다.
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        String userId = "" ;
//        if(authentication != null){
//            userId = authentication.getName();
//        }
//
//        return Optional.of(userId);
//    }
//}
