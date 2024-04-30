package com.foodPlanet.entity;

import com.foodPlanet.constant.Role;
import com.foodPlanet.dto.request.member.SignUpRequestDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "members")
@Getter @Setter @ToString
public class Member {

    // 회원 ID (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    // 회원 역할 (예: ADMIN, USER 등)
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    // 회원 이메일 (고유한 값, 중복 불가)
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    // 비밀번호
    @Column(name = "password", nullable = false)
    private String password;

    // 회원 이름
    @Column(nullable = false)
    private String nickname;

    // 회원 전화번호
    @Column(name = "phone", nullable = false)
    private String phone;

    // 회원 생년월일
    @Column(name = "birth", nullable = false)
    private String birth;

    // 알레르기 정보
    @Column(name = "allergy")
    private String allergy;

    // 회원 성별
    @Column(name = "gender", nullable = false)
    private String gender;

    // 회원 프로필 이미지 경로 (길이 제한: 255)
    @Column(name = "member_image", length = 255)
    private String memberImage;

    // 약관 동의
    @Column(nullable = false)
    private boolean agreedPersonal;
    public Member(SignUpRequestDto dto) {
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.phone = dto.getPhone();
        this.birth = dto.getBirth();
        this.gender = "남자";
        this.role = dto.getRole();
//        this.agreedPersonal = dto.getAgreedPersonal();

    }
}
