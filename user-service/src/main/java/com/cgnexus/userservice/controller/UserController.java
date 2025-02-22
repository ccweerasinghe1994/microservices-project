package com.cgnexus.userservice.controller;

import com.cgnexus.userservice.dto.APIResponse;
import com.cgnexus.userservice.dto.UserInfo;
import com.cgnexus.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    public ResponseEntity<APIResponse<List<UserInfo>>> getAllUsers(@RequestParam("userIds") List<UUID> userIds) {


        return null;
    }
}
