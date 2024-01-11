package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.boot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
 
	 UserEntity	findByUserEmailAndUserPassword(String userEmail,String userPassword);

}

