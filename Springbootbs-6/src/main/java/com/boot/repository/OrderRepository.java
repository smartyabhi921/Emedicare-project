package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.boot.entity.Orderentity;



public interface OrderRepository extends JpaRepository< Orderentity, Integer>

{
}
