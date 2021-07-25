package com.hanium.catsby.service;

import com.hanium.catsby.domain.TownCommunity;
import com.hanium.catsby.domain.TownLike;
import com.hanium.catsby.domain.User;
import com.hanium.catsby.repository.TownCommentRepository;
import com.hanium.catsby.repository.TownLikeRepository;
import com.hanium.catsby.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;


@Service
public class TownService {

    @Autowired
    TownRepository townRepository;


    public void writeTownCommunity(TownCommunity townCommunity, User user) {//글 쓰기
        townCommunity.setUser(user);

    @Autowired
    TownCommentRepository townCommentRepository;

    @Autowired
    TownLikeRepository townLikeRepository;

    public String currentTime(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @Transactional
    public void writeTownCommunity(TownCommunity townCommunity) {//글 쓰기
//        townCommunity.setUser(user);
        townCommunity.setDate(currentTime());
        townRepository.save(townCommunity);
    }

    public Page<TownCommunity> listTownCommunity(Pageable pageable){//글 목록
        return townRepository.findAll(pageable);
    }

    public TownCommunity retrieveTownCommunity(int id) {//글 조회
        return townRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }

    public void deleteTownCommunity(int id) {//글 삭제
        townRepository.deleteById(id);
    }

    public void updateTownCommunity(int id, TownCommunity requestTownCommunity) {//글 수정
        TownCommunity townCommunity = townRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
                }); //영속화 완료
        townCommunity.setTitle(requestTownCommunity.getTitle());
        townCommunity.setContent(requestTownCommunity.getContent());
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

    @Transactional
    public void createTownLike(int id, TownLike requestTownLike){
        TownCommunity townCommunity = townRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("댓글 쓰기 실패 : 게시글 id를 찾을 수 없습니다.");
                }); //영속화 완료

        //        requestTownComment.setUser(user);
        requestTownLike.setTownCommunity(townCommunity);

        townLikeRepository.save(requestTownLike);
    }

    @Transactional
    public void deleteTownLike(int townLike_id){
        townCommentRepository.deleteById(townLike_id);
    }
}