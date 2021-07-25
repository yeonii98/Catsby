package com.hanium.catsby.controller;

import com.hanium.catsby.domain.TownComment;
import com.hanium.catsby.domain.TownCommunity;
import com.hanium.catsby.domain.TownLike;
import com.hanium.catsby.domain.User;
import com.hanium.catsby.repository.TownCommentRepository;
import com.hanium.catsby.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TownController {

    @Autowired
    TownService townService;

    @GetMapping("/townCommunity")//커뮤니티 메인
    public List town() {
        return townService.listTownCommunity();
    }

    @GetMapping("/townCommunity/{townCommunity_id}")
    public TownCommunity retrieveTown(@PathVariable int townCommunity_id) {
        return townService.retrieveTownCommunity(townCommunity_id);
    }

    @PostMapping("townCommunity/write")
    public String writeTown(@RequestBody TownCommunity townCommunity){//현재 유저의 정보도 넣어야 함
        townService.writeTownCommunity(townCommunity);
        return "글 쓰기";
    }

    @DeleteMapping("townCommunity/{townCommunity_id}")
    public String deleteTown(@PathVariable int townCommunity_id){
        townService.deleteTownCommunity(townCommunity_id);
        return "글 삭제하기";
    }

    @PutMapping("townCommunity/{townCommunity_id}")
    public String updateTown(@PathVariable int townCommunity_id, @RequestBody TownCommunity townCommunity){
        townService.updateTownCommunity(townCommunity_id,townCommunity);
        return "글 수정하기";
    }

    @PostMapping("townCommunity/{townCommunity_id}/comment")
    public String writeTownComment(@PathVariable int townCommunity_id, @RequestBody TownComment townComment){//현재 유저의 정보도 넣어야 함
        townService.writeTownComment(townCommunity_id, townComment);
        return "댓글 쓰기";
    }

    @DeleteMapping("townCommunity/{townCommunity_id}/comment/{townComment_id}")
    public String deleteTownComment(@PathVariable int townComment_id){
        townService.deleteTownComment(townComment_id);
        return "댓글 삭제하기";
    }

    @PostMapping("townCommunity/{townCommunity_id}/like")
    public String createTownLike(@PathVariable int townCommunity_id, @RequestBody TownLike townLike){//현재 유저의 정보도 넣어야 함
        townService.createTownLike(townCommunity_id, townLike);
        return "좋아요";
    }

    @DeleteMapping("townCommunity/{townCommunity_id}/like/{townLike_id}")
    public String deleteTownLike(@PathVariable int townLike_id){
        townService.deleteTownLike(townLike_id);
        return "좋아요 취소";
    }

}
