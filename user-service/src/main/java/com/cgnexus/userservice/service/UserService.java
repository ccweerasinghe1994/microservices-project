package com.cgnexus.userservice.service;

import com.cgnexus.userservice.dto.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> getAllUsers(List<String> userIds);
}
