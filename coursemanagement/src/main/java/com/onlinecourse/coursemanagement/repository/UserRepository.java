package com.onlinecourse.coursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecourse.coursemanagement.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {
}