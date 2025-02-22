package com.cgnexus.userservice.controller;

import com.cgnexus.userservice.dto.APIResponse;
import com.cgnexus.userservice.dto.UserInfo;
import com.cgnexus.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<APIResponse<List<UserInfo>>> getAllUsers(@RequestParam("userIds") List<String> userIds, WebRequest request) {
        log.info("Getting all users by userIds: {}", userIds);

        List<UserInfo> allUsers = userService.getAllUsers(userIds);

        return ResponseEntity.ok(APIResponse.<List<UserInfo>>builder()
                .data(allUsers)
                .status(HttpStatus.OK.value())
                .timestamp(Instant.now())
                .path(request.getDescription(false).split("=")[1])
                .build());
    }
}
