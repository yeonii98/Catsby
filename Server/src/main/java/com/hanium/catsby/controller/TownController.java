package com.hanium.catsby.controller;

import com.hanium.catsby.domain.TownComment;
import com.hanium.catsby.domain.TownCommunity;
import com.hanium.catsby.domain.User;
import com.hanium.catsby.repository.TownCommentRepository;
import com.hanium.catsby.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TownController {

    @Autowired
    TownService townService;


    @GetMapping("/townCommunity")//우리동네고양이 메인
    public String town(){
        return "테스트 완료";
    }


    @GetMapping("/townCommunity")//커뮤니티 메인
    public List town() {
        return townService.listTownCommunity();
    }

    @GetMapping("/townCommunity/{id}")
    public TownCommunity retrieveTown(@PathVariable int id) {
        return townService.retrieveTownCommunity(id);
    }

    @PostMapping("townCommunity/write")
    public String writeTown(@RequestBody TownCommunity townCommunity){//현재 유저의 정보도 넣어야 함
        townService.writeTownCommunity(townCommunity);
        return "글 쓰기";
    }

    @DeleteMapping("townCommunity/{id}")
    public String deleteTown(@PathVariable int id){
        townService.deleteTownCommunity(id);
        return "글 삭제하기";
    }

    @PutMapping("townCommunity/{id}")
    public String updateTown(@PathVariable int id, @RequestBody TownCommunity townCommunity){
        townService.updateTownCommunity(id,townCommunity);
        return "글 수정하기";
    }

    @PostMapping("townCommunity/{id}/comment")
    public String writeTownComment(@PathVariable int id, @RequestBody TownComment townComment){//현재 유저의 정보도 넣어야 함
        townService.writeTownComment(id, townComment);
        return "댓글 쓰기";
    }

    @DeleteMapping("townCommunity/{id}/comment/{commentId}")
    public String deleteTownComment(@PathVariable int commentId){
        townService.deleteTownComment(commentId);
        return "댓글 삭제하기";
    }

}
