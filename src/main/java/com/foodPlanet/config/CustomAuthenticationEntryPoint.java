package com.foodPlanet.config;//package com.foodPlanet.config;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        // 요청하신 리소스에 대한 유효한 인증 자격 증명이 없어서 요청이 불가능합니다.
//        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//
//        String message ;
//        int statusCode = response.getStatus();
//
//        if (statusCode == HttpServletResponse.SC_UNAUTHORIZED){ // 미로그인.
//            message = "로그인이 필요합니다.";
//            System.out.println(message);
//            response.sendRedirect("/member/login");
//
//        }else if (statusCode == HttpServletResponse.SC_FORBIDDEN){ // 로그인 했지만 권한이 없음
//            message = "요청하신 정보를 이용할 수 없습니다.";
//            System.out.println(message);
//            response.sendRedirect("/");
//        }else{
////
//        }
//    }
//}