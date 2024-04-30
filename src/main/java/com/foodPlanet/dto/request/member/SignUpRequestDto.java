package com.foodPlanet.dto.request.member;

import com.foodPlanet.constant.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    private String gender = "남자";

    @Enumerated(EnumType.STRING)
    private Role role;

//    @NotNull @AssertTrue
//    private Boolean agreedPersonal;
}
