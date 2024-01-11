package com.boot.controller;


import java.util.List;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Orderentity;
import com.boot.exceptions.ApiResponce;
import com.boot.service.OrderService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")

@Api(value="", tags= {"Order-controller"}, description="Operate and Perform functions about Orders.")
public class OrderController 

{   @Autowired
	private OrderService OrderService;
	
    @PostMapping("/") //end point http:localhost:8080/order
	public ResponseEntity<Orderentity> addorder(@RequestBody Orderentity order)
	{
    
    	Orderentity saveorder = this.OrderService.addorder(order);
       return new ResponseEntity<Orderentity>(saveorder,HttpStatus.CREATED);
    	
	}
    
    
    // get records
    @GetMapping("/")
    public ResponseEntity<List<Orderentity>> getAllorders()
    {
        List<Orderentity> allorders = this.OrderService.getAllorders();
        return new ResponseEntity<List<Orderentity>>(allorders,HttpStatus.OK);

    }
    
    @GetMapping("/{orderId}")
    public ResponseEntity<Orderentity> getorderById(@PathVariable("orderId")int orderId )
    {
    	
    Orderentity orderById = this.OrderService.getorderById(orderId);	
    return new ResponseEntity<Orderentity>(orderById,HttpStatus.OK);	
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Orderentity> updateorderbyID(@RequestBody Orderentity order,@PathVariable("orderId") int orderId)
    {
    	Orderentity updatedorder = this.OrderService.updateorderById(order, orderId);
    	return new ResponseEntity<Orderentity>( updatedorder ,HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<ApiResponce> deleteById(@PathVariable("orderId")int orderId )
    {
    	
    this.OrderService.deleteorderByID(orderId);	
    ApiResponce response = new ApiResponce();
    response.setMessage("order record is deleted wiith id"+ orderId);
    
    return new ResponseEntity<ApiResponce>(response,HttpStatus.OK);	
    }
    
}


