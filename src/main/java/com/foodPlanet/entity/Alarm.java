package com.foodPlanet.entity;

import com.foodPlanet.constant.AlarmStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "alarm")
@Getter @Setter @ToString
public class Alarm {

    // 알람 ID (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "push_id", nullable = false)
    private Long id;

    // 해당 알람을 받는 회원 (다대일 관계)
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // 알람 상태 (예: 읽음, 안 읽음)
    @Enumerated(EnumType.STRING)
    @Column(name = "alarmStatus")
    private AlarmStatus alarmStatus;

    // 알람 제목
    @Column(name = "title", nullable = false)
    private String title;

    // 알람 내용
    @Column(name = "content", nullable = false)
    private String content;


    // 알람 링크 URL
    @Column(name = "link_url")
    private String linkUrl;

}

