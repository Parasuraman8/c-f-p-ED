package com.vishnuparasu.EnforcementDirectorate.controller;

import com.vishnuparasu.EnforcementDirectorate.entity.EdOfficerEntity;
import com.vishnuparasu.EnforcementDirectorate.service.impl.EdOfficerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ED/OfficerController")
@RestController
public class EdOfficerController {

    @Autowired
    EdOfficerServiceImpl edOfficerService;

    @GetMapping("/getOfficer")
    public ResponseEntity<EdOfficerEntity> getOfficer(@RequestParam("edoid") String edoid) {
        return new ResponseEntity<>(edOfficerService.getOfficer(edoid),HttpStatus.OK);
    }

    @GetMapping("/getAllOfficer")
    public ResponseEntity<List<EdOfficerEntity>> getAllOfficers() {
        return new ResponseEntity<>(edOfficerService.getAllOfficers(),HttpStatus.OK);
    }

    @PutMapping("/modifyOfficer")
    public ResponseEntity<EdOfficerEntity> modifyOfficer(@RequestParam("edoid") String edoid, @RequestBody EdOfficerEntity edOfficerEntity) {
        return new ResponseEntity<>(edOfficerService.modifyOfficer(edOfficerEntity,edoid),HttpStatus.OK);
    }

    @PostMapping("/createOfficer")
    public ResponseEntity<EdOfficerEntity> createOfficer(@RequestBody EdOfficerEntity edOfficerEntity) {
        return new ResponseEntity<>(edOfficerService.createOfficer(edOfficerEntity),HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteOfficers")
    public ResponseEntity<String> deleteOfficer(@RequestParam("edoid")String edoid) {
        return new ResponseEntity<>(edOfficerService.deleteOfficer(edoid), HttpStatus.OK);
    }
}
