package com.boot.serviceimplementation;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.boot.entity.AdminEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.AdminResository;




@Service
public class AdminServiceImpli implements com.boot.service.AdminService{



   @Autowired
      private AdminResository adminRepository;
    
    @Override
    public AdminEntity addAdmin(AdminEntity admin) {
        // TODO Auto-generated method stub
        return this.adminRepository.save(admin);
    }



   @Override
    public List<AdminEntity> getAllAdmin() {
        // TODO Auto-generated method stub
        return this.adminRepository.findAll();
    }



   @Override
    public AdminEntity getAdminById(int adminId) {
        // TODO Auto-generated method stub
        return  this.adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", adminId));
    }



   @Override
    public AdminEntity updateAdminById(AdminEntity admin, int adminId) {
        // TODO Auto-generated method stub
         AdminEntity userDB = this.adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Student", "Student Id", adminId));
            
            
         return this.adminRepository.save(admin);
    }



   @Override
    public void deleteAdminById(int adminId) {
        // TODO Auto-generated method stub
         if(!this.adminRepository.existsById(adminId))
         {
               throw new ResourceNotFoundException("Student" , "Student ID", adminId);
             }
         else
         {
             this.adminRepository.deleteById(adminId);
         }
     }    



   } 