package com.vishnuparasu.EnforcementDirectorate.controller;

import com.vishnuparasu.EnforcementDirectorate.entity.EdOfficerEntity;
import com.vishnuparasu.EnforcementDirectorate.service.impl.EdOfficerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping(value = "/ED/OfficerController")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@PreAuthorize("hasAnyAuthority('EDA','EDO')")
public class EdOfficerController {

    @Autowired
    EdOfficerServiceImpl edOfficerService;

    @GetMapping("/totalNumberOfRow")
    public ResponseEntity<String>getNoOfRow() {
        try {
            return new ResponseEntity<>(edOfficerService.getNoRow(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/getOfficer")
    public ResponseEntity<EdOfficerEntity> getOfficer(@RequestParam("edoid") String edoid) {
        try {
            return new ResponseEntity<>(edOfficerService.getOfficer(edoid),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new EdOfficerEntity(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllOfficer")
    public ResponseEntity<List<EdOfficerEntity>> getAllOfficers() {
        try {
            return new ResponseEntity<>(edOfficerService.getAllOfficers(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/modifyOfficer")
    public ResponseEntity<EdOfficerEntity> modifyOfficer(@RequestParam("edoid") String edoid, @RequestBody EdOfficerEntity edOfficerEntity) {
        try {
            return new ResponseEntity<>(edOfficerService.modifyOfficer(edOfficerEntity,edoid),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new EdOfficerEntity(),HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/createOfficer")
    public ResponseEntity<EdOfficerEntity> createOfficer(@RequestBody EdOfficerEntity edOfficerEntity) {
        try {
            return new ResponseEntity<>(edOfficerService.createOfficer(edOfficerEntity),HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new EdOfficerEntity(),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/deleteOfficers")
    public ResponseEntity<String> deleteOfficer(@RequestParam("edoid")String edoid) {
        try {
            return new ResponseEntity<>(edOfficerService.deleteOfficer(edoid), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
}
