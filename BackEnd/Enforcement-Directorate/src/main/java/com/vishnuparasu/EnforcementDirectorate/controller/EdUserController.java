package com.vishnuparasu.EnforcementDirectorate.controller;

import com.vishnuparasu.EnforcementDirectorate.entity.EdUserBankEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserEntity;
import com.vishnuparasu.EnforcementDirectorate.service.impl.EdUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/ED/UserController")
@RestController
public class EdUserController {

    @Autowired
    EdUserServiceImpl edUserService;


    @PostMapping("/createEdUser")
    public ResponseEntity<EdUserEntity> createEdUser(@RequestBody EdUserEntity edUserEntity) {
        return new  ResponseEntity<>(edUserService.createUser(edUserEntity), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDU','EDO')")
    @GetMapping("/getUser")
    public ResponseEntity<EdUserEntity>getUser(@RequestParam("eduid") String eduid) {
        return new ResponseEntity<>(edUserService.getUser(eduid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getAllUser")
    public ResponseEntity<List<EdUserEntity>>getAllUser() {
        return new ResponseEntity<>(edUserService.getAllUser(),HttpStatus.OK);
    }


    @PreAuthorize("hasAnyAuthority('EDA','EDU','EDO')")
    @GetMapping("/getBank")
    public ResponseEntity<EdUserBankEntity> getBank(@RequestParam("eduid") String eduid) {
        return new ResponseEntity<>(edUserService.getUserBank(eduid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDU','EDO')")
    @GetMapping("/getAllBank")
    public ResponseEntity<List<EdUserBankEntity>> getAllBank() {
        return new ResponseEntity<>(edUserService.getAllUserBank(),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDU','EDO')")
    @PutMapping("/modifyUser")
    public ResponseEntity<EdUserEntity> modifyUser(@RequestParam("eduid") String eduid, @RequestBody EdUserEntity edUserEntity) {
        return new ResponseEntity<>(edUserService.modifyUser(edUserEntity,eduid),HttpStatus.OK);
    }


    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @DeleteMapping("/deleteEdUser")
    public ResponseEntity<String> deleteEdUser(@RequestParam("eduid") String eduid){
        return new ResponseEntity<>(edUserService.deleteUser(eduid),HttpStatus.OK);
    }
}
