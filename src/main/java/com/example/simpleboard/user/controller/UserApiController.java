package com.example.simpleboard.user.controller;

import com.example.simpleboard.user.model.UserRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public UserRequest register(@RequestBody UserRequest userRequest, HttpEntity httpEntity) {
//        log.info("{}", userRequest);
//        log.info("{}", httpEntity);

        return userRequest;
    }

}
