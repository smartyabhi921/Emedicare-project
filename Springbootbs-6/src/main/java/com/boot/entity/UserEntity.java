package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="users")
public class UserEntity
{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int userId;
     
     @Column(nullable = false, length = 20)
     private String userName;
     
     @Column(unique = true)
     private String userEmail;
     
     @Column(nullable = false, length = 40)    
     private String userPassword;





   public int getUserId() {
         return userId;
     }




    public void setUserId(int userId) {
         this.userId = userId;
     }



   public String getUserName() {
         return userName;
     }



   public void setUserName(String userName) {
         this.userName = userName;
     }



   public String getUserEmail() {
         return userEmail;
     }



   public void setUserEmail(String userEmail) {
         this.userEmail = userEmail;
     }



   public String getUserPassword() {
         return userPassword;
     }



   public void setUserPassword(String userPassword) {
         this.userPassword = userPassword;
     }
    
  @Override
     public String toString() {
         return "UserEntity [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
                 + ", userPassword=" + userPassword + "]";
     }



   public UserEntity() {
         super();
         // TODO Auto-generated constructor stub
     }
     
}


