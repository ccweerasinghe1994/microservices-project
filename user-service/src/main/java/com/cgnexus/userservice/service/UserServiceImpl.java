package com.cgnexus.userservice.service;

import com.cgnexus.userservice.dto.UserInfo;
import com.cgnexus.userservice.entity.UserRecord;
import com.cgnexus.userservice.exception.InvalidUserIdException;
import com.cgnexus.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final InvoiceService invoiceService;

    @Override
    public List<UserInfo> getAllUsers(List<String> userIds) {
        try {
            List<UUID> convertedUserIds = userIds.stream().map(UUID::fromString).toList();

            List<UserRecord> allById = userRepository.findAllById(convertedUserIds);


            return allById.stream().map(userRecord -> UserInfo.builder()
                    .userId(userRecord.getUserId())
                    .name(userRecord.getName())
                    .age(userRecord.getAge())
                    .updatedTime(userRecord.getUpdatedTime().toString())
                    .createdTime(userRecord.getCreatedTime().toString())
                    .gender(userRecord.getGender())
                    .invoiceList(invoiceService.getAllInvoicesByUserId(userRecord.getUserId().toString()))
                    .build()).toList();
        } catch (IllegalArgumentException e) {
            throw new InvalidUserIdException("BAD REQUEST", List.of("Invalid UUID format"), HttpStatus.BAD_REQUEST.value());
        }
    }
}
