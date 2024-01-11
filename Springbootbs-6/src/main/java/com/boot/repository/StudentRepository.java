package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Studententity;

public interface StudentRepository extends JpaRepository<Studententity, Integer>

{
}
