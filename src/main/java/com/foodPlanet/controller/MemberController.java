package com.foodPlanet.controller;

import com.foodPlanet.dto.request.member.LogInRequestDto;
import com.foodPlanet.dto.request.member.SignUpRequestDto;
import com.foodPlanet.dto.response.member.LogInResponseDto;
import com.foodPlanet.dto.response.member.SignUpResponseDto;
import com.foodPlanet.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/insert")
    public ResponseEntity<? super SignUpResponseDto> signup(@RequestBody @Valid SignUpRequestDto requestBody){
        ResponseEntity<? super SignUpResponseDto> response = memberService.signUp(requestBody);
        return response;
    }

    @PostMapping("login")
    public ResponseEntity<? super LogInResponseDto> login(@RequestBody @Valid LogInRequestDto requestBody){
        ResponseEntity<? super LogInResponseDto> response = memberService.logIn(requestBody);
        return response;
    }
}
