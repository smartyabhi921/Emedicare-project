package com.boot.service;


import java.util.List;

import com.boot.entity.UserEntity;


public interface UserService {

public UserEntity addUsers(UserEntity user);

public List<UserEntity> getAllUsers();

public UserEntity getUsersById(int userId);

public UserEntity updateUserById(UserEntity user, int userId);

public void deleteUsersById(int userId);

public UserEntity checkLogin(String userEmail, String userPassword);


}