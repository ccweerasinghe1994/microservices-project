package com.cgnexus.userservice.repository;

import com.cgnexus.userservice.entity.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserRecord, UUID> {
}
