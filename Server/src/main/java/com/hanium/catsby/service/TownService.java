package com.hanium.catsby.service;

import com.hanium.catsby.domain.TownComment;
import com.hanium.catsby.domain.TownCommunity;
import com.hanium.catsby.domain.User;
import com.hanium.catsby.repository.TownCommentRepository;
import com.hanium.catsby.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TownService {

    @Autowired
    TownRepository townRepository;

    @Autowired
    TownCommentRepository townCommentRepository;

    @Transactional
    public void writeTownCommunity(TownCommunity townCommunity) {//글 쓰기
//        townCommunity.setUser(user);
        townRepository.save(townCommunity);
    }

    @Transactional(readOnly = true)
    public List listTownCommunity(){//글 목록
        return townRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TownCommunity retrieveTownCommunity(int id) {//글 조회
        return townRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void deleteTownCommunity(int id) {//글 삭제
        townRepository.deleteById(id);
    }

    @Transactional
    public void updateTownCommunity(int id, TownCommunity requestTownCommunity) {//글 수정
        TownCommunity townCommunity = townRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
                }); //영속화 완료
        townCommunity.setTitle(requestTownCommunity.getTitle());
        townCommunity.setContent(requestTownCommunity.getContent());
        System.out.println(townCommunity);
        //해당 함수로 종료시(Service가 종료될 때) 트랜잭션이 종료된다. 이때 더티체킹이 일어남 - 자동 업데이트됨. db쪽으로 flush
    }

    @Transactional
    public void writeTownComment(int id, TownComment requestTownComment){
        TownCommunity townCommunity = townRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("댓글 쓰기 실패 : 게시글 id를 찾을 수 없습니다.");
                }); //영속화 완료

        //        requestTownComment.setUser(user);
        requestTownComment.setTownCommunity(townCommunity);

        townCommentRepository.save(requestTownComment);
    }

    @Transactional
    public void deleteTownComment(int commentId){
        townCommentRepository.deleteById(commentId);
    }
}