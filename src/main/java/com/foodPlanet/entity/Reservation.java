package com.foodPlanet.entity;

import com.foodPlanet.constant.ReservationStatus;
import com.foodPlanet.constant.ReservationType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
@Getter @Setter @ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id", nullable = false)
    private Long id;
    // 예약한 회원 정보와의 관계 (다대일 관계)
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // 예약된 가게 정보와의 관계 (다대일 관계)
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    // 예약 상태 (예: 확정, 취소 등)
    @Column(name = "reservation_status")
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    // 예약 유형 (예: 개인, 그룹 등)
    @Column(name = "reservation_type")
    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;

    /*==================================================================*/

    // 예약자 이름
    @Column(name = "reserver")
    private String reserver;

    // 방문자 이름
    @Column(name = "visitor")
    private String visitor;

    // 예약자 전화번호
    @Column(name = "phone")
    private String phone;

    // 방문자 전화번호
    @Column(name = "visitor_phone")
    private String visitorPhone;

    // 예약 날짜
    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    // 예약 시간
    @Column(name = "reservation_time")
    private LocalTime reservationTime;

    // 수용 가능한 인원 수
    @Column(name = "capacity")
    private Integer capacity;

    // 특별 요청사항
    @Column(name = "requests")
    private String requests;



}
