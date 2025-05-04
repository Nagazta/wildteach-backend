package com.wildteach.tutoringsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildteach.tutoringsystem.entity.adminEntity;
import com.wildteach.tutoringsystem.repository.adminRepository;
import com.wildteach.tutoringsystem.service.adminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/admin")
@CrossOrigin
public class adminController {
    @Autowired
    private adminService adminService;
    @Autowired
private adminRepository adminRepository;
    // Endpoint to add a new admin
    @PostMapping("/addAdmin")
    public String addAdmin(@RequestBody adminEntity admin) {
        adminService.saveAdmin(admin);
        return "New admin is added";
    }
    // Endpoint to get all admins
    @GetMapping("/getAllAdmins")
    public List<adminEntity> getAllAdmins() {
        return adminService.getAllAdmins();
    }
    // Endpoint to get an admin by ID
    @GetMapping("/getAdmin/{id}")
    public ResponseEntity<adminEntity> getAdminById(@PathVariable Long id) {
        Optional<adminEntity> admin = adminRepository.findById(id);
        return admin.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an admin by ID
    @PutMapping("/updateAdmin/{id}")
    public adminEntity updateAdmin(@PathVariable Long id, @RequestBody adminEntity adminDetails) {
       adminEntity updatedAdmin = adminService.updateAdmin(id, adminDetails);
        if (updatedAdmin != null) {
            return updatedAdmin;
        } else {
            return null; 
        }
    }
    // Endpoint to delete an admin by ID
    @DeleteMapping("/deleteAdmin/{id}")
    public adminEntity deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id);
    }

    //Endpoint to login as admin
    @PostMapping("/login")
    public adminEntity login(@RequestBody adminEntity admin) {
        return adminService.login(admin);
    }
}
