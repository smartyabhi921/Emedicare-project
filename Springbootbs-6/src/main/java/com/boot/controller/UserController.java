package com.boot.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.boot.entity.UserEntity;
import com.boot.exceptions.ApiRespo;
import com.boot.exceptions.ApiResponce;
import com.boot.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation; 

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

@RequestMapping("/users")
@EnableWebMvc
@CrossOrigin("*")

@Api(value="", tags= {"user-controller"},description="Operate and Perform functions about the user.")


public class UserController {
	
	@Autowired

	private UserService userService;

	// private UserEntity updateUserbyId;

	@PostMapping("/") // end point http:localhost:8082/User/
	@ApiOperation(value="Function for Adding the user.",
    notes="You can add the user from here",
     response=UserEntity.class)

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
            @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
            @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
            @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
            @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors")})
	
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity User) {

		UserEntity savedUser = this.userService.addUsers(User);
		return new ResponseEntity<UserEntity>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/")
	@ApiOperation(value="Function to View the user.",
    notes="You can view the user from here",
    response=UserEntity.class) 
	
	@ApiResponses(value = {
			 @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
           @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
           @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
           @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
           @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors")})
	
	
	public ResponseEntity<List<UserEntity>> getAllUsers() // to fetch all the User data
	{
		List<UserEntity> allUsers = this.userService.getAllUsers();
		return new ResponseEntity<List<UserEntity>>(allUsers, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	
	@ApiOperation(value="Function to Find user.",
    notes="You can view the user from here ByID",
    response=UserEntity.class)
	
	@ApiResponses(value = {
			 @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
           @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
           @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
           @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
           @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors")})
	
	
	public ResponseEntity<UserEntity> getUserById(@PathVariable("userId") int userId) {
		UserEntity UserById = this.userService.getUsersById(userId);
		return new ResponseEntity<UserEntity>(UserById, HttpStatus.OK);
	}

	@PutMapping("/{userId}")
	
	@ApiOperation(value="Function to Update the user.",
    notes="You can Update the user from here",
    response=UserEntity.class)
	
	@ApiResponses(value = {
			 @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
           @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
           @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
           @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
           @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors")})
	
	
	public ResponseEntity<UserEntity> updateUserbyId(@RequestBody UserEntity User, @PathVariable int userId) {

		UserEntity updateUserById = this.userService.updateUserById(User, userId);
		// return new ResponseEntity<UserEntity>(updatedUser,HttpStatus.OK);
		return new ResponseEntity<UserEntity>(updateUserById, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	
	@ApiOperation(value="Function to Delete the user.",
    notes="You can Delete the user from here",
    response=UserEntity.class)
	
	@ApiResponses(value = {
			 @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
           @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
           @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
           @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
           @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors")})
	
	
	public ResponseEntity<ApiRespo> deleteUserById(@PathVariable("userId") int userId) {
		this.userService.deleteUsersById(userId);
		ApiRespo response = new ApiRespo();

		response.setMessage("User record deleted successfully with User Id: " + userId);
		return new ResponseEntity<ApiRespo>(response, HttpStatus.OK);
	}

	@GetMapping("/check")
	@ApiOperation(value="Function to Login the user.",
    notes="You can Login the user from here",
    response=UserEntity.class)
	
	@ApiResponses(value = {
			 @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
           @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
           @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
           @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
           @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors")})
	
	
	public ResponseEntity<UserEntity> check(@RequestParam("email") String email,
			@RequestParam("password") String password) {

		UserEntity checkLogin = this.userService.checkLogin(email, password);
		if (checkLogin != null) 
		{
			return new ResponseEntity<UserEntity>(checkLogin, HttpStatus.OK);
		} else 
		{
			return null;
		}

	}
}
