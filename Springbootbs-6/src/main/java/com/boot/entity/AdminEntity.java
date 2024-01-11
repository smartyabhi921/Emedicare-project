package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="admin")
public class AdminEntity {



    @Id
    private int adminId;
    
    @Column(unique = true)
    private String adminEmail;
    
    @Column(nullable = false, length = 40)    
    private String adminPassword;




    public int getAdminId() {
        return adminId;
    }





  public void setAdminId(int adminId) {
        this.adminId = adminId;
    }




   public String getAdminEmail() {
        return adminEmail;
    }




   public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }




   public String getAdminPassword() {
        return adminPassword;
    }




   public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }




   public AdminEntity() {
        super();
        // TODO Auto-generated constructor stub
    }



  @Override
    public String toString() {
        return "AdminEntity [adminId=" + adminId + ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword
                + "]";
    }



}