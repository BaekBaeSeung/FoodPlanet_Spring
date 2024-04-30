package com.foodPlanet.dto.response.member;

import com.foodPlanet.common.ResponseCode;
import com.foodPlanet.common.ResponseMessage;
import com.foodPlanet.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class LogInResponseDto extends ResponseDto {

    private String token;
//    private int expirationTime;

    public LogInResponseDto(String token) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.token = token;
//        this.expirationTime = 3600;
    }

    public static ResponseEntity<LogInResponseDto> success(String token) {
        LogInResponseDto result = new LogInResponseDto(token);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> logInFail() {
        ResponseDto result = new ResponseDto(ResponseCode.LOGIN_FAIL, ResponseMessage.LOGIN_FAILED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
