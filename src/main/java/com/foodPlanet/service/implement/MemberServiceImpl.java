package com.foodPlanet.service.implement;

import com.foodPlanet.dto.request.member.LogInRequestDto;
import com.foodPlanet.dto.request.member.SignUpRequestDto;
import com.foodPlanet.dto.response.ResponseDto;
import com.foodPlanet.dto.response.member.LogInResponseDto;
import com.foodPlanet.dto.response.member.SignUpResponseDto;
import com.foodPlanet.entity.Member;
import com.foodPlanet.provider.JwtProvider;
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
    private final JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try {
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

        } catch (Exception err) {
            err.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super LogInResponseDto> logIn(LogInRequestDto dto) {
        String token = null;

        try {
            String email = dto.getEmail();
            Member member = memberRepository.findByEmail(email);
            if(member == null) return LogInResponseDto.logInFail();

            String password = dto.getPassword();
            String encodedPw = member.getPassword();
            boolean isMatched = passwordEncoder.matches(password, encodedPw);
            if (!isMatched) return LogInResponseDto.logInFail();

            token = jwtProvider.create(email);

        } catch (Exception err) {
            err.printStackTrace();
            return ResponseDto.databaseError();
        }
        return LogInResponseDto.success(token);
    }
}
