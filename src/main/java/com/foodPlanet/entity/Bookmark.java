package com.foodPlanet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "bookmark")
@Getter @Setter @ToString
public class Bookmark {

    // 북마크 ID (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookmark_id", nullable = false)
    private Long id;

    // 북마크한 회원 (다대일 관계)
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // 북마크한 가게 (다대일 관계)
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    // Getters and setters
}
