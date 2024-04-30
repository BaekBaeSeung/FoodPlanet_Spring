package com.foodPlanet.service;

import com.foodPlanet.dto.request.member.SignUpRequestDto;
import com.foodPlanet.dto.response.member.SignUpResponseDto;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    ResponseEntity<? super SignUpResponseDto> signUp (SignUpRequestDto dto);

}
