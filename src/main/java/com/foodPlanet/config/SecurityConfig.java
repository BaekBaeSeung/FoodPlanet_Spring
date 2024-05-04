package com.foodPlanet.config;

import com.foodPlanet.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configurable
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().and()
                .csrf().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/", "/member/**", "/search/**","/shops/**", "/file/**").permitAll()
                .antMatchers(HttpMethod.GET, "/board/**").permitAll()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(new FailedAuthenticationEntryPoint());

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
//    @Bean
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .cors().and()
//                .csrf().disable()
//                .httpBasic().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests()
//                .antMatchers("/", "/member/**", "/search/**", "/file/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/board/**").permitAll()
//                .mvcMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated().and()
//                .exceptionHandling().authenticationEntryPoint(new FailedAuthenticationEntryPoint());
//
//        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return httpSecurity.build();
//    }
//}


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 인증(Authentication) 관련 설정
//        http.cors().and()
//                .formLogin()
//                .loginPage("/member/login")
//                .defaultSuccessUrl("/")
//                .usernameParameter("email")
//                .failureUrl("/member/login/error")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
//                .logoutSuccessUrl("/");
//
//        // Cannot create a session after the response has been committed 오류 발생시
//        // .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//        // 문장을 추가하면 됨
//        // 인가(Authorization) 설정
//        http.authorizeRequests()
//                .mvcMatchers("/", "/member/**").permitAll()
//                .mvcMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated();
//
//        // authenticationEntryPoint : 인증을 받지 못하고 실패했을 때 수행할 커스텀 로직을 지정해 주는 메소드입니다.
//        http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
//    }
//    @Bean("pe") // PasswordEncoder는 비밀 번호를 암호화 시켜 주는 인터페이스입니다.
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    private MemberService ms ;
//
//    // AuthenticationManagerBuilder 클래스는 인증 관리자(AuthenticationManager) 객체를 생성합니다.
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(ms).passwordEncoder(passwordEncoder());
//    }
//
////    @Override // static 디렉토리의 하위 파일은 인증을 무시하도록 합니다.
////    public void configure(WebSecurity web) throws Exception{
////        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
////    }
//}