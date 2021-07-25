package com.hanium.catsby.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor //빈생성자
@AllArgsConstructor //전체 생성자
@Builder
@Entity
public class TownLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne	(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")//user_id라는 컬럼이 만들어짐
    private User user;

    @ManyToOne	(fetch = FetchType.LAZY)
    @JoinColumn(name = "town_community_id")//town_community_id_Id라는 컬럼이 만들어짐
    private TownCommunity town_community;

}
