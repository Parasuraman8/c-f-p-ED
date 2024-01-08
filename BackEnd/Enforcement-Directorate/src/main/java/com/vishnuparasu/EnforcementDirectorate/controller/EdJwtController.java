package com.vishnuparasu.EnforcementDirectorate.controller;

import com.vishnuparasu.EnforcementDirectorate.model.EdLoginRequest;
import com.vishnuparasu.EnforcementDirectorate.model.EdLoginResponse;
import com.vishnuparasu.EnforcementDirectorate.service.impl.EdLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ED/EdJwtController")
@CrossOrigin(origins = "http://localhost:4200")
public class EdJwtController {

    @Autowired
    EdLoginServiceImpl edLoginService;

    @PostMapping("/login")
    public ResponseEntity<EdLoginResponse> login(@RequestBody EdLoginRequest edLoginRequest) {
        return  new ResponseEntity<>(edLoginService.login(edLoginRequest), HttpStatus.OK);
    }


}
