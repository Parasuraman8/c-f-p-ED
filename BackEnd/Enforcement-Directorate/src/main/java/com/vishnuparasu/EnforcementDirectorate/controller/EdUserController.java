package com.vishnuparasu.EnforcementDirectorate.controller;

import com.vishnuparasu.EnforcementDirectorate.entity.EdUserBankEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserPaymentEntity;
import com.vishnuparasu.EnforcementDirectorate.service.impl.EdUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/ED/UserController")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EdUserController {

    @Autowired
    EdUserServiceImpl edUserService;

    @GetMapping("/totalNumberOfRow")
    public ResponseEntity<String>getNoOfRow() {
        return new ResponseEntity<>(edUserService.getNoRow(),HttpStatus.OK);
    }


    @PostMapping("/createEdUser")
    public ResponseEntity<EdUserEntity> createEdUser(@RequestBody EdUserEntity edUserEntity) {
        return new  ResponseEntity<>(edUserService.createUser(edUserEntity), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/getUser")
    public ResponseEntity<EdUserEntity>getUser(@RequestParam("eduid") String eduid) {
        return new ResponseEntity<>(edUserService.getUser(eduid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/getAllUser")
    public ResponseEntity<List<EdUserEntity>>getAllUser() {
        return new ResponseEntity<>(edUserService.getAllUser(),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/getBank")
    public ResponseEntity<EdUserBankEntity> getBank(@RequestParam("eduid") String eduid) {
        return new ResponseEntity<>(edUserService.getUserBank(eduid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/getAllBank")
    public ResponseEntity<List<EdUserBankEntity>> getAllBank() {
        return new ResponseEntity<>(edUserService.getAllUserBank(),HttpStatus.OK);
    }


    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @PutMapping("/modifyUser")
    public ResponseEntity<EdUserEntity> modifyUser(@RequestParam("eduid") String eduid, @RequestBody EdUserEntity edUserEntity) {
        return new ResponseEntity<>(edUserService.modifyUser(edUserEntity,eduid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDO','EDU')")
    @PutMapping("/modifyPayment")
    public ResponseEntity<EdUserPaymentEntity>modifyPayment(@RequestParam("value") String value , @RequestParam("id") int id) {
        return new ResponseEntity<>(edUserService.modifyPayment(value,id),HttpStatus.OK);
    }


    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @DeleteMapping("/deleteEdUser")
    public ResponseEntity<String> deleteEdUser(@RequestParam("eduid") String eduid){
        return new ResponseEntity<>(edUserService.deleteUser(eduid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDU')")
    @PostMapping("/createPayment")
    public ResponseEntity<EdUserPaymentEntity> createPayment(@RequestBody EdUserPaymentEntity edUserPaymentEntity) {
        return new ResponseEntity<>(edUserService.createUserPatment(edUserPaymentEntity),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/senderDetail")
    public ResponseEntity<List<EdUserPaymentEntity>> getSenderDetail(@RequestParam("senderEduid") String senderEduid) {
        return new ResponseEntity<>(edUserService.getSenderDetail(senderEduid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/reciverDetail")
    public ResponseEntity<List<EdUserPaymentEntity>> getReciverDetail(@RequestParam("reciveEduid") String recevierEduid) {
        return new ResponseEntity<>(edUserService.getRecevierDetail(recevierEduid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/userComplainList")
    public  ResponseEntity<List<EdUserPaymentEntity>> getUserComplaintList(@RequestParam("eduid") String eduid) {
        return new ResponseEntity<>(edUserService.getUserComplaint(eduid),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getAllPayment")
    public ResponseEntity<List<EdUserPaymentEntity>> getAllPayment() {
        return new ResponseEntity<>(edUserService.getAllPatment(),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getAllComplaint")
    public ResponseEntity<List<EdUserPaymentEntity>> getAllComplaint(@RequestParam("trueOrFalse") String trueOrFalse) {
        return new ResponseEntity<>(edUserService.getAllCompliants(trueOrFalse),HttpStatus.OK);
    }



}
