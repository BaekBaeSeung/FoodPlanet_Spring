package com.foodPlanet.entity;

import com.foodPlanet.constant.ShopCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "shops")
@Getter @Setter @ToString
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "shopCategory", nullable = false)
    @Enumerated(EnumType.STRING)
    private ShopCategory shopCategory;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "addressDetail", nullable = false)
    private String addressDetail;

    @Column(name = "openTime", nullable = false)
    private String openTime;

    @Column(name = "closeTime", nullable = false)
    private String closeTime;

    @Column(name = "breakTime", nullable = false)
    private String breakTime;

    @Lob // CLOB(Character Large OBject), BLOB(Binary Large OBject)
    @Column(name = "comment")
    private String comment;

    @Lob // CLOB(Character Large OBject), BLOB(Binary Large OBject)
    @Column(name = "notice")
    private String notice;

    @Column(name = "parking", nullable = false)
    private String parking;

    @Column(name = "facilities")
    private String facilities;

    @Column(name = "maxCapacity", nullable = false)
    private Integer maxCapacity;

    @Column(name = "shop_image01", nullable = false)
    private String shopImage01;

    @Column(name = "shop_image02", nullable = false)
    private String shopImage02;

    @Column(name = "shop_image03")
    private String shopImage03;

    @Column(name = "shop_image04")
    private String shopImage04;

    @Column(name = "shop_image05")
    private String shopImage05;

    // 생성자, 게터, 세터 등은 생략
}

