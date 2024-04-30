package com.foodPlanet.service.implement;

import com.foodPlanet.dto.request.member.SignUpRequestDto;
import com.foodPlanet.dto.response.ResponseDto;
import com.foodPlanet.dto.response.member.SignUpResponseDto;
import com.foodPlanet.entity.Member;
import com.foodPlanet.repository.MemberRepository;
import com.foodPlanet.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp (SignUpRequestDto dto) {

        try{
            String email = dto.getEmail();
            boolean existedEmail = memberRepository.existsByEmail(email);
            if (existedEmail) return SignUpResponseDto.duplicateEmail();

            String nickname = dto.getNickname();
            boolean existedNickname = memberRepository.existsByNickname(nickname);
            if (existedNickname) return SignUpResponseDto.duplicateNickname();

            String phone = dto.getPhone();
            boolean existedPhone = memberRepository.existsByPhone(phone);
            if (existedPhone) return SignUpResponseDto.duplicatePhone();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            Member member = new Member(dto);
            memberRepository.save(member);

        }catch (Exception err){
            err.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }
}
