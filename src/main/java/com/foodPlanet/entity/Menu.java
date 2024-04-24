package com.foodPlanet.entity;

import com.foodPlanet.constant.MenuCategory;
import com.foodPlanet.constant.ProductStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "menus")
@Getter @Setter @ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "menu_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @Column(name = "product_status")
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private MenuCategory menuCategory;

    /*=======================================================*/

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "description")
    private String description;

    @Column(name = "allergy")
    private String allergy;

    @Column(name = "order_tracking")
    private Integer orderTracking;//해당 메뉴 선택해서 주문시 +1

    @Column(name = "recommended_menu", nullable = false)
    private boolean recommendedMenu;// 이거는 메뉴 등록할 때 체크박스 체크하면 true 반환

    @Column(name = "menu_image01", nullable = false) // 메뉴이미지 3개까지는 필수입력
    private String menuImage01;

    @Column(name = "menu_image02", nullable = false) // 이미지 5개로 줄임.
    private String menuImage02;

    @Column(name = "menu_image03", nullable = false)
    private String menuImage03;

    @Column(name = "menu_image04")
    private String menuImage04;

    @Column(name = "menu_image05")
    private String menuImage05;



    // 생성자, 게터, 세터, toString() 등은 생략
}
