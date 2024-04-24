package com.foodPlanet.entity;

import com.foodPlanet.constant.PaymentMethod;
import com.foodPlanet.constant.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payment")
@Getter
@Setter
@ToString
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id", nullable = false)
    private Long id; // 결제 식별자

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member; // Member 조인

    @ManyToOne
    @JoinColumn(name = "reservation_no", nullable = false)
    private Reservation reservation; // Reservation 조인

    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; //결제 종류(카드, 현장결제) Enum 타입

    @Column(name = "payment_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus; //결제 상태 (완료, 취소 등) Enum 타입

    /*==============================================================================*/

    @Column(name = "amount", nullable = false)
    private BigDecimal amount; // 결제 금액


    @Column(name = "transaction_id", nullable = false)
    private String transactionId; // 거래 식별자 (결제 게이트웨이에서 제공하는 거래 번호)


    @Column(name = "additional_data")
    private String additionalData; //추가적인 데이터 (예: 상품 정보)


    // Getters and setters
}