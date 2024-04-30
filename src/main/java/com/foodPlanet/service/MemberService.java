package com.foodPlanet.service;

import com.foodPlanet.dto.request.member.LogInRequestDto;
import com.foodPlanet.dto.request.member.SignUpRequestDto;
import com.foodPlanet.dto.response.member.LogInResponseDto;
import com.foodPlanet.dto.response.member.SignUpResponseDto;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);

    ResponseEntity<? super LogInResponseDto> logIn(LogInRequestDto dto);

}
