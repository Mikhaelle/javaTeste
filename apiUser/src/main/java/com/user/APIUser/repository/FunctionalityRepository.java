package com.user.APIUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.APIUser.models.Functionality;

public interface FunctionalityRepository extends JpaRepository<Functionality,Long>{
	Functionality findById(long id);
}
