package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orderentity 
{   
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int orderIdl;
   
	
   @Column(nullable = false , length = 400)
   private String orderName;
   
   @Column(unique = true)
   private String orderEmail;
   
   @Column(nullable = false,length = 10)
   private String orderPassword;
   
   @Column(nullable = false)
   private String orderAge;
   
   @Column(nullable = false)
   private String orderClass;

public int getorderIdl() {
	return orderIdl;
}

public void setorderIdl(int orderIdl) {
	this.orderIdl = orderIdl;
}

public String getorderName() {
	return orderName;
}

public void setorderName(String orderName) {
	this.orderName = orderName;
}

public String getorderEmail() {
	return orderEmail;
}

public void setorderEmail(String orderEmail) {
	this.orderEmail = orderEmail;
}

public String getorderPassword() {
	return orderPassword;
}

public void setorderPassword(String orderPassword) {
	this.orderPassword = orderPassword;
}

public String getorderAge() {
	return orderAge;
}

public void setorderAge(String orderAge) {
	this.orderAge = orderAge;
}

public String getorderClass() {
	return orderClass;
}

public void setorderClass(String orderClass) {
	this.orderClass = orderClass;
}

public Orderentity() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "orderentity [orderIdl=" + orderIdl + ", orderName=" + orderName + ", orderEmail=" + orderEmail
			+ ", orderPassword=" + orderPassword + ", orderAge=" + orderAge + ", orderClass=" + orderClass
			+ "]";
}
   
   
         
   
	}
