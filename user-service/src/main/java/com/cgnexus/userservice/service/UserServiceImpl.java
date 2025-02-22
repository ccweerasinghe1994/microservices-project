package com.cgnexus.userservice.service;

import com.cgnexus.userservice.dto.UserInfo;
import com.cgnexus.userservice.entity.UserRecord;
import com.cgnexus.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserInfo> getAllUsers(List<UUID> userIds) {
        List<UserRecord> allById = userRepository.findAllById(userIds);
        return allById.stream().map(userRecord -> UserInfo.builder()
                .userId(userRecord.getUserId())
                .name(userRecord.getName())
                .age(userRecord.getAge())
                .updatedTime(userRecord.getUpdatedTime().toString())
                .createdTime(userRecord.getCreatedTime().toString())
                .gender(userRecord.getGender())
                .build()).toList();

    }
}
