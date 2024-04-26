package com.foodPlanet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // 이 파일은 설정용 파일로 사용하겠습니다.
@EnableWebSecurity // Spring Security 설정을 활성화시켜 주는 역할을 합니다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // SecurityConfig01 시작
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // SecurityConfig02 시작
        // 인증(Authentication) 관련 설정
        http.cors().and()
                .formLogin()
                .loginPage("/member/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/member/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/");
    }
}
//        ;
//        // Cannot create a session after the response has been committed 오류 발생시
//        //.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) 문장을 추가하면 됩
//        // SecurityConfig02 끝
//
//
//        // SecurityConfig03 시작
//        // 인가(Authorization) 설정
//        http.authorizeRequests()
//                .mvcMatchers("/", "/member/**", "/product/**", "/images/**", "/thymeleaf/**").permitAll()
//                .mvcMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated();
//
//        // authenticationEntryPoint : 인증을 받지 못하고 실패했을 때 수해할 커스텀 로직을 지정해 주는 메소드입니다.
//        http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
//
//        // SecurityConfig03 끝
//    }
//
//    // SecurityConfig03 시작
//    @Override // static 디렉토리의 하위 파일은 인증을 무시하도록 합니다.
//    public void configure(WebSecurity web) throws Exception{
//        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
//    }
//    // SecurityConfig03 끝
//
//    @Bean("pe") // PasswordEncoder는 비밀 번호를 암호화 시켜 주는 인터페이스입니다.
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    // SecurityConfig01 끝
//
//    // SecurityConfig02 시작
//    @Autowired
//    private MemberService ms ;
//
//    // AuthenticationManagerBuilder 클래스는 인증 관리자(AuthenticationManager) 객체를 생성합니다.
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(ms).passwordEncoder(passwordEncoder());
//    }
//    // SecurityConfig02 끝
//}