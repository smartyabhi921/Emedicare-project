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
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.AdminEntity;
import com.boot.exceptions.ApiResponce;

import io.swagger.annotations.Api;



@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
@Api(value="", tags= {"Admin-controller"}, description="Operate and Perform functions about Admin.")
public class AdminController {



   
   @Autowired
    private com.boot.service.AdminService adminService;
   
    private AdminEntity updateAdminById;
    
    @PostMapping("/")
    public ResponseEntity<AdminEntity> addAdmin(@RequestBody AdminEntity Admin){
        
        AdminEntity savedAdmin=this.adminService.addAdmin(Admin);
        return new ResponseEntity<AdminEntity>(savedAdmin,HttpStatus.CREATED);}
        
    @GetMapping("/")
     public ResponseEntity<List<AdminEntity>> getAllAdmin()  //to fetch all the User data
        {
            List<AdminEntity> allAdmin = this.adminService.getAllAdmin();
            return new ResponseEntity<List<AdminEntity>>(allAdmin,HttpStatus.OK);
        }
        @GetMapping("/{adminId}")
        public ResponseEntity<AdminEntity> getAdminById(@PathVariable("adminId") int adminId)  
        {
            AdminEntity AdminById = this.adminService.getAdminById(adminId);
            return new ResponseEntity<AdminEntity>(AdminById,HttpStatus.OK);
        }
        



      @PutMapping("/{adminId}")
        public ResponseEntity<AdminEntity> updateAdminbyId(@RequestBody AdminEntity Admin,@PathVariable int adminId)
        {
            
            AdminEntity AdminById = this.adminService.updateAdminById(Admin,adminId);
            //return new ResponseEntity<UserEntity>(updatedUser,HttpStatus.OK);
             return new ResponseEntity<AdminEntity>(updateAdminById, HttpStatus.OK);
        }
        
        @DeleteMapping("/{adminId}")
        public ResponseEntity<ApiResponce> deleteById(@PathVariable("adminId") int adminId)
        {
            this.adminService.deleteAdminById(adminId);
            ApiResponce response =  new ApiResponce();
            
            response.setMessage("User record deleted successfully with User Id: "+adminId);
            return new ResponseEntity<ApiResponce>(response, HttpStatus.OK);
        }
    }