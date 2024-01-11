package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.AdminEntity;



public interface AdminResository extends JpaRepository<AdminEntity, Integer>
{



}