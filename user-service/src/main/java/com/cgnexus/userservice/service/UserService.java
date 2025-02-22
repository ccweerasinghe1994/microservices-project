package com.cgnexus.userservice.service;

import com.cgnexus.userservice.dto.UserInfo;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserInfo> getAllUsers(List<UUID> userIds);
}
