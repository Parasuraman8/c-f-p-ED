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

@RequestMapping(value = "/ED/AdminController")
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EdAdminController {

    @Autowired
    EdAdminServiceImpl edAdminService;

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/totalNumberOfRow")
    public ResponseEntity<String>getNoOfRow() {
        return new ResponseEntity<>(edAdminService.getNoRow(),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/getAdmin")
    public ResponseEntity<EdAdminEntity> getAdmin(@RequestParam("edaid") String edaid) {
        return new ResponseEntity<>(edAdminService.getAdmin(edaid), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getUserCredential")
    public ResponseEntity<EdUserCredentials> getUserCredential(@RequestParam("userid") String userid) {
        return new ResponseEntity<>(edAdminService.getUserCredential(userid),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/getRole")
    public ResponseEntity<EdRolesEntity> getRole(@RequestParam("roleName") String roleName) {
        return new ResponseEntity<>(edAdminService.getRole(roleName),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/getAllAdmin")
    public ResponseEntity<List<EdAdminEntity>> getAllAdmin() {
        return new ResponseEntity<>(edAdminService.getAllAdmin(),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getAllUserCredential")
    public ResponseEntity<List<EdUserCredentials>> getAllCredential() {
        return new ResponseEntity<>(edAdminService.getAllUserCredentials(),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @GetMapping("/getAllRoles")
    public ResponseEntity<List<EdRolesEntity>> getAllRoles() {
        return new ResponseEntity<>(edAdminService.getAllRoles(),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @PostMapping("/createAdmin")
    public ResponseEntity<EdAdminEntity> createAdmin(@RequestBody EdAdminEntity edAdminEntity) {
        return new ResponseEntity<>(edAdminService.createAdmin(edAdminEntity),HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @PostMapping("/createRole")
    public ResponseEntity<EdRolesEntity> createRole(@RequestBody EdRolesEntity edRolesEntity) {
        return new ResponseEntity<>(edAdminService.createRole(edRolesEntity),HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @PutMapping("/modifyAdmin")
    public ResponseEntity<EdAdminEntity> modifyAdmin(@RequestBody EdAdminEntity edAdminEntity, @RequestParam("edaid") String edaid) {
        return new ResponseEntity<>(edAdminService.modifyAdmin(edAdminEntity,edaid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @PutMapping("/modifyUserCredential")
    public ResponseEntity<EdUserCredentials> modifyUserCredential(@RequestBody EdUserCredentials edUserCredentials, @RequestParam("userid") String userid) {
        return new ResponseEntity<>(edAdminService.modifyUserCredentials(edUserCredentials,userid),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @PutMapping("/modifyRole")
    public ResponseEntity<EdRolesEntity> modifyRole(@RequestBody EdRolesEntity edRolesEntity, String roleName) {
        return new ResponseEntity<>(edAdminService.modifyRole(roleName,edRolesEntity),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @DeleteMapping("/removeAdmin")
    public ResponseEntity<String> removeAdmin(@RequestParam("edaid") String edaid) {
        return new ResponseEntity<>(edAdminService.removeAdmin(edaid),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDA')")
    @DeleteMapping("/removeRole")
    public ResponseEntity<String> removeRole(@RequestParam("roleName") String roleName) {
        return new ResponseEntity<>(edAdminService.removeRole(roleName),HttpStatus.OK);
    }

}
