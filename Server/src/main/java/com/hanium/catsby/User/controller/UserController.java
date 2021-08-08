package com.hanium.catsby.User.controller;

import com.hanium.catsby.User.domain.Users;
import com.hanium.catsby.User.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public CreateUserResponse createUser(@RequestBody Users user) {
        Long id = userService.savaUser(user);
        return new CreateUserResponse(id);
    }

    @Data
    static class CreateUserResponse{
        private Long id;
        public CreateUserResponse(Long id) {
            this.id = id;
        }
    }

    @GetMapping("/users")
    public List<Users> users() {
        return userService.findUsers();
    }

    @PutMapping("/user/{id}")
    public UpdateUserResponse updateUserResponse(@PathVariable("id") Long id, @RequestBody UpdateUserRequest request) {
        userService.update(id, request.getNickname(), request.getAddress());
        Users findUser = userService.findUser(id);
        return new UpdateUserResponse(findUser.getId(), findUser.getNickname(), findUser.getAddress());
    }

    @Data
    static class UpdateUserRequest{
        private Long id;
        private String nickname;
        private String address;
    }

    @Data
    @AllArgsConstructor
    static class UpdateUserResponse{
        private Long id;
        private String nickname;
        private String address;
    }
}