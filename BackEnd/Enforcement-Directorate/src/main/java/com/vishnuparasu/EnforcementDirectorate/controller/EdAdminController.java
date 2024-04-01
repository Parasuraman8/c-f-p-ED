package com.vishnuparasu.EnforcementDirectorate.controller;

import com.vishnuparasu.EnforcementDirectorate.entity.EdAdminEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdRolesEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserCredentials;
import com.vishnuparasu.EnforcementDirectorate.service.impl.EdAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping(value = "/ED/AdminController")
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EdAdminController {

    @Autowired
    EdAdminServiceImpl edAdminService;

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/totalNumberOfRow")
    public ResponseEntity<String>getNoOfRow() {
        try {
            return new ResponseEntity<>(edAdminService.getNoRow(),HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/getAdmin")
    public ResponseEntity<EdAdminEntity> getAdmin(@RequestParam("edaid") String edaid) {
        try {
            return new ResponseEntity<>(edAdminService.getAdmin(edaid), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(new EdAdminEntity(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getUserCredential")
    public ResponseEntity<EdUserCredentials> getUserCredential(@RequestParam("userid") String userid) {
        try {
            return new ResponseEntity<>(edAdminService.getUserCredential(userid),HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(new EdUserCredentials(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/getRole")
    public ResponseEntity<EdRolesEntity> getRole(@RequestParam("roleName") String roleName) {
        try {
            return new ResponseEntity<>(edAdminService.getRole(roleName),HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(new EdRolesEntity(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/getAllAdmin")
    public ResponseEntity<List<EdAdminEntity>> getAllAdmin() {
        try {
            return new ResponseEntity<>(edAdminService.getAllAdmin(),HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getAllUserCredential")
    public ResponseEntity<List<EdUserCredentials>> getAllCredential() {
        try {
            return new ResponseEntity<>(edAdminService.getAllUserCredentials(),HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/getAllRoles")
    public ResponseEntity<List<EdRolesEntity>> getAllRoles() {
        try {
            return new ResponseEntity<>(edAdminService.getAllRoles(),HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @PostMapping("/createAdmin")
    public ResponseEntity<EdAdminEntity> createAdmin(@RequestBody EdAdminEntity edAdminEntity) {
        try {
            return new ResponseEntity<>(edAdminService.createAdmin(edAdminEntity),HttpStatus.CREATED);
        } catch (Exception ex){
            return new ResponseEntity<>(new EdAdminEntity(),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @PostMapping("/createRole")
    public ResponseEntity<EdRolesEntity> createRole(@RequestBody EdRolesEntity edRolesEntity) {
        try {
            return new ResponseEntity<>(edAdminService.createRole(edRolesEntity),HttpStatus.CREATED);
        } catch (Exception ex){
            return new ResponseEntity<>(new EdRolesEntity(),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @PutMapping("/modifyAdmin")
    public ResponseEntity<EdAdminEntity> modifyAdmin(@RequestBody EdAdminEntity edAdminEntity, @RequestParam("edaid") String edaid) {
        try {
            return new ResponseEntity<>(edAdminService.modifyAdmin(edAdminEntity,edaid),HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(new EdAdminEntity(), HttpStatus.NOT_MODIFIED);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @PutMapping("/modifyUserCredential")
    public ResponseEntity<EdUserCredentials> modifyUserCredential(@RequestBody EdUserCredentials edUserCredentials, @RequestParam("userid") String userid) {
        try {
            return new ResponseEntity<>(edAdminService.modifyUserCredentials(edUserCredentials,userid),HttpStatus.OK);
        } catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(new EdUserCredentials(),HttpStatus.NOT_MODIFIED);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @PutMapping("/modifyRole")
    public ResponseEntity<EdRolesEntity> modifyRole(@RequestBody EdRolesEntity edRolesEntity, String roleName) {
        try {
            return new ResponseEntity<>(edAdminService.modifyRole(roleName,edRolesEntity),HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(new EdRolesEntity(),HttpStatus.NOT_MODIFIED);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @DeleteMapping("/removeAdmin")
    public ResponseEntity<String> removeAdmin(@RequestParam("edaid") String edaid) {
        try {
            return new ResponseEntity<>(edAdminService.removeAdmin(edaid),HttpStatus.OK);
        } catch (Exception ex){
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('EDA')")
    @DeleteMapping("/removeRole")
    public ResponseEntity<String> removeRole(@RequestParam("roleName") String roleName) {
        try {
            return new ResponseEntity<>(edAdminService.removeRole(roleName),HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
