package com.boot.service;

import com.boot.entity.Orderentity;

//import java.security.PublicKey;
import java.util.*;

public interface OrderService

{
   //add new record
	public Orderentity addorder(Orderentity order);
	
	//to get  all the order list
	public List<Orderentity> getAllorders();
	
	//to get rec by id
	public Orderentity getorderById(int orderId);
	
	//update by order id
	public Orderentity updateorderById(Orderentity order,int orderId);
	
	// del
	public void deleteorderByID(int orderID);

		
}
