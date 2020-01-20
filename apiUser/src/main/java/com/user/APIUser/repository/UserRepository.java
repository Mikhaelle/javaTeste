package com.user.APIUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.APIUser.models.Users;

public interface UserRepository extends JpaRepository<Users,Long> {
Users findById(long id);
}
