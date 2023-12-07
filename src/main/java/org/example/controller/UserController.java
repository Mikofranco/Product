package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.AddPostRequest;
import org.example.dto.request.LoginRequest;
import org.example.dto.request.RegisterRequest;
import org.example.dto.response.AddPostResponse;
import org.example.dto.response.UserInfoResponse;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        userService.register(request);
        return new ResponseEntity<>("Successful",HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<UserInfoResponse> login(@RequestBody LoginRequest request){
        var response = userService.login(request);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<AddPostResponse> addPost(@RequestBody AddPostRequest request){
        var response = userService.addPost(request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
