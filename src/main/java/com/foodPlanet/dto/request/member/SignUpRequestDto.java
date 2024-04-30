package com.foodPlanet.dto.request.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
@Getter
@Setter
public class SignUpRequestDto {

    @NotBlank @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String nickname;

    @NotBlank @Pattern(regexp="^[0-9]{11}$")
    private String phone;

    @NotBlank
    private String birth;

    @NotNull @AssertTrue
    private Boolean agreedPersonal;
}
