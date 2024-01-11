package com.boot.service;


import java.util.List;

import com.boot.entity.AdminEntity;



public interface AdminService {


  public AdminEntity addAdmin(AdminEntity admin);

  public List<AdminEntity> getAllAdmin();

  public AdminEntity getAdminById(int adminId);


  public AdminEntity updateAdminById(AdminEntity admin, int adminId);


 public void deleteAdminById(int adminId);

}