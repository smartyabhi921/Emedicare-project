package com.boot.serviceimplementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.UserEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.UserRepository;
import com.boot.service.UserService;

@Service
public class UserServiceImplementation implements UserService 
{


  @Autowired
    private UserRepository userRepository;
   
@Override
    public UserEntity addUsers(UserEntity user) {
        // TODO Auto-generated method stub
         return this.userRepository.save(user);    }


  @Override
    public List<UserEntity> getAllUsers() {
        // TODO Auto-generated method stub
        return this.userRepository.findAll();
    }

   @Override
    public UserEntity getUsersById(int userId) {
        // TODO Auto-generated method stub
        return  this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
    }
    
  @Override
    public UserEntity updateUserById(UserEntity user, int userId) {

 
            UserEntity userDB = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Student", "Student Id", userId));
            
         return this.userRepository.save(user);

  }
    

//    @Override
//
//        public StudentEntity updateStudentById(StudentEntity student, int studentId) {
//
//            // TODO Auto-generated method stub
//
//            StudentEntity studentDB = this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student","Student ID", studentId));
//
//            return this.studentRepository.save(student);
//
//        }



   @Override
    public void deleteUsersById(int userId) {
        if(!this.userRepository.existsById(userId))
          {
              
              throw new ResourceNotFoundException("Student" , "Student ID", userId);
              }
          else
          {
              this.userRepository.deleteById(userId);
          }
      }


@Override
public UserEntity checkLogin(String userEmail, String userPassword) {
	
	UserEntity user = this.userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
	return user;
}
}
