package com.foodPlanet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Getter @Setter @ToString
public class Review {

    // 리뷰 ID (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id", nullable = false)
    private Long id;

    // 해당 리뷰를 작성한 회원 (다대일 관계)
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // 해당 샵에대한 리뷰 (다대일 관계)
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    // 식당 이름
    @Column(name = "dining_name", nullable = false)
    private String diningName;

    // 리뷰 이미지1
    @Column(name = "image01")
    private String image01;

    // 리뷰 이미지2
    @Column(name = "image02")
    private String image02;

    // 리뷰 이미지3
    @Column(name = "image03")
    private String image03;

    // 평점
    @Column(name = "score")
    private String score;

    // 리뷰 내용
    @Column(name = "content")
    private String content;

}
