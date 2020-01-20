package com.user.APIUser.repository;


import com.user.APIUser.models.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmailRepository extends PagingAndSortingRepository<Users, Long> {
    Users findByEmail(String email);
}