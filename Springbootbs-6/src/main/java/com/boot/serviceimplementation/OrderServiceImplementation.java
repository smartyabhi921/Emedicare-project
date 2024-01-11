package com.boot.serviceimplementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Orderentity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.OrderRepository;
import com.boot.service.OrderService;



@Service
public class OrderServiceImplementation implements OrderService

{  
	
	@Autowired
   private OrderRepository OrderRepository;
	
	
	@Override
	public Orderentity addorder(Orderentity order) {
		// TODO Auto-generated method stub
		return this.OrderRepository.save(order);
	}

	@Override
	public List<Orderentity> getAllorders() {
		// TODO Auto-generated method stub
		return this.OrderRepository.findAll();
	}

	@Override
	public Orderentity getorderById(int orderId) {
		// TODO Auto-generated method stub
		return this.OrderRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("order", "orderId", orderId));
	}

	@Override
	public Orderentity updateorderById(Orderentity order, int orderId) {
		
		
	this.OrderRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("order", "orderId", orderId));
		
	 return this.OrderRepository.save(order);
	}

	@Override
	public void deleteorderByID(int orderId) 
	
	{
		this.OrderRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("order", "orderId", orderId));
	
		this.OrderRepository.deleteById(orderId);
	}

}
