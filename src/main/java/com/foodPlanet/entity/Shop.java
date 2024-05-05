package com.foodPlanet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
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

    @Column(name = "offer")
    private String offer;

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

    public Shop() {
    }

    public Shop(Long id, Member member,
                ShopCategory shopCategory,
                String shopName, String address,
                String addressDetail, String openTime,
                String closeTime, String breakTime,
                String comment, String notice,
                String parking, String facilities,
                Integer maxCapacity, String shopImage01,
                String shopImage02, String shopImage03,
                String shopImage04, String shopImage05) {
        this.id = id;
        this.member = member;
        this.shopCategory = shopCategory;
        this.shopName = shopName;
        this.address = address;
        this.addressDetail = addressDetail;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.breakTime = breakTime;
        this.comment = comment;
        this.notice = notice;
        this.parking = parking;
        this.facilities = facilities;
        this.maxCapacity = maxCapacity;
        this.shopImage01 = shopImage01;
        this.shopImage02 = shopImage02;
        this.shopImage03 = shopImage03;
        this.shopImage04 = shopImage04;
        this.shopImage05 = shopImage05;
    }
}

