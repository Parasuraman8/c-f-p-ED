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
import java.util.List;

@PreAuthorize("hasAnyAuthority('EDA')")
@RequestMapping(value = "/ED/AdminController")
@RestController
public class EdAdminController {

    @Autowired
    EdAdminServiceImpl edAdminService;

    @GetMapping("/getAdmin")
    public ResponseEntity<EdAdminEntity> getAdmin(@RequestParam("edaid") String edaid) {
        return new ResponseEntity<>(edAdminService.getAdmin(edaid), HttpStatus.OK);
    }

    @GetMapping("/getUserCredential")
    public ResponseEntity<EdUserCredentials> getUserCredential(@RequestParam("userid") String userid) {
        return new ResponseEntity<>(edAdminService.getUserCredential(userid),HttpStatus.OK);
    }

    @GetMapping("/getRole")
    public ResponseEntity<EdRolesEntity> getRole(@RequestParam("roleName") String roleName) {
        return new ResponseEntity<>(edAdminService.getRole(roleName),HttpStatus.OK);
    }

    @GetMapping("/getAllAdmin")
    public ResponseEntity<List<EdAdminEntity>> getAllAdmin() {
        return new ResponseEntity<>(edAdminService.getAllAdmin(),HttpStatus.OK);
    }

    @GetMapping("/getAllUserCredential")
    public ResponseEntity<List<EdUserCredentials>> getAllCredential() {
        return new ResponseEntity<>(edAdminService.getAllUserCredentials(),HttpStatus.OK);
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<EdRolesEntity>> getAllRoles() {
        return new ResponseEntity<>(edAdminService.getAllRoles(),HttpStatus.OK);
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<EdAdminEntity> createAdmin(@RequestBody EdAdminEntity edAdminEntity) {
        return new ResponseEntity<>(edAdminService.createAdmin(edAdminEntity),HttpStatus.CREATED);
    }

    @PostMapping("/createRole")
    public ResponseEntity<EdRolesEntity> createRole(@RequestBody EdRolesEntity edRolesEntity) {
        return new ResponseEntity<>(edAdminService.createRole(edRolesEntity),HttpStatus.CREATED);
    }

    @PutMapping("/modifyAdmin")
    public ResponseEntity<EdAdminEntity> modifyAdmin(@RequestBody EdAdminEntity edAdminEntity, @RequestParam("edaid") String edaid) {
        return new ResponseEntity<>(edAdminService.modifyAdmin(edAdminEntity,edaid),HttpStatus.OK);
    }

    @PutMapping("/modifyUserCredential")
    public ResponseEntity<EdUserCredentials> modifyUserCredential(@RequestBody EdUserCredentials edUserCredentials, @RequestParam("userid") String userid) {
        return new ResponseEntity<>(edAdminService.modifyUserCredentials(edUserCredentials,userid),HttpStatus.OK);
    }

    @PutMapping("/modifyRole")
    public ResponseEntity<EdRolesEntity> modifyRole(@RequestBody EdRolesEntity edRolesEntity, String roleName) {
        return new ResponseEntity<>(edAdminService.modifyRole(roleName,edRolesEntity),HttpStatus.OK);
    }

    @DeleteMapping("/removeAdmin")
    public ResponseEntity<String> removeAdmin(@RequestParam("edaid") String edaid) {
        return new ResponseEntity<>(edAdminService.removeAdmin(edaid),HttpStatus.OK);
    }

    @DeleteMapping("/removeRole")
    public ResponseEntity<String> removeRole(@RequestParam("roleName") String roleName) {
        return new ResponseEntity<>(edAdminService.removeRole(roleName),HttpStatus.OK);
    }

}
