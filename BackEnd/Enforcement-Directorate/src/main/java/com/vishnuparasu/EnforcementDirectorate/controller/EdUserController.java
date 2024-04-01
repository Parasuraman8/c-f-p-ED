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

import java.util.Collections;
import java.util.List;


@RequestMapping(value = "/ED/UserController")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EdUserController {

    @Autowired
    EdUserServiceImpl edUserService;

    @GetMapping("/totalNumberOfRow")
    public ResponseEntity<String>getNoOfRow() {
        try {
            return new ResponseEntity<>(edUserService.getNoRow(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping("/createEdUser")
    public ResponseEntity<EdUserEntity> createEdUser(@RequestBody EdUserEntity edUserEntity) {
        try {
            return new  ResponseEntity<>(edUserService.createUser(edUserEntity), HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex);
            return new  ResponseEntity<>(new EdUserEntity(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/getUser")
    public ResponseEntity<EdUserEntity>getUser(@RequestParam("eduid") String eduid) {
        try {
            return new ResponseEntity<>(edUserService.getUser(eduid),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new EdUserEntity(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getAllUser")
    public ResponseEntity<List<EdUserEntity>>getAllUser() {
        try {
            return new ResponseEntity<>(edUserService.getAllUser(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/getBank")
    public ResponseEntity<EdUserBankEntity> getBank(@RequestParam("eduid") String eduid) {
        try {
            return new ResponseEntity<>(edUserService.getUserBank(eduid),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new EdUserBankEntity(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getAllBank")
    public ResponseEntity<List<EdUserBankEntity>> getAllBank() {
        try {
            return new ResponseEntity<>(edUserService.getAllUserBank(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
    }


    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @PutMapping("/modifyUser")
    public ResponseEntity<EdUserEntity> modifyUser(@RequestParam("eduid") String eduid, @RequestBody EdUserEntity edUserEntity) {
        try {
            return new ResponseEntity<>(edUserService.modifyUser(edUserEntity,eduid),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new EdUserEntity(),HttpStatus.NOT_MODIFIED);
        }
    }

    @PreAuthorize("hasAuthority('EDO')")
    @PutMapping("/modifyPayment")
    public ResponseEntity<EdUserPaymentEntity>modifyPayment(@RequestParam("value") String value , @RequestParam("id") int id) {
        try {
            return new ResponseEntity<>(edUserService.modifyPayment(value,id),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new EdUserPaymentEntity(),HttpStatus.NOT_MODIFIED);
        }
    }


    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @DeleteMapping("/deleteEdUser")
    public ResponseEntity<String> deleteEdUser(@RequestParam("eduid") String eduid){
        try {
            return new ResponseEntity<>(edUserService.deleteUser(eduid),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(edUserService.deleteUser(eduid),HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDU')")
    @PostMapping("/createPayment")
    public ResponseEntity<EdUserPaymentEntity> createPayment(@RequestBody EdUserPaymentEntity edUserPaymentEntity) {
        try {
            return new ResponseEntity<>(edUserService.createUserPatment(edUserPaymentEntity),HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new EdUserPaymentEntity(),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/senderDetail")
    public ResponseEntity<List<EdUserPaymentEntity>> getSenderDetail(@RequestParam("senderEduid") String senderEduid) {
        try {
            return new ResponseEntity<>(edUserService.getSenderDetail(senderEduid),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO','EDU')")
    @GetMapping("/reciverDetail")
    public ResponseEntity<List<EdUserPaymentEntity>> getReciverDetail(@RequestParam("reciveEduid") String recevierEduid) {
        try {
            return new ResponseEntity<>(edUserService.getRecevierDetail(recevierEduid),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('EDU')")
    @GetMapping("/userComplainList")
    public  ResponseEntity<List<EdUserPaymentEntity>> getUserComplaintList(@RequestParam("eduid") String eduid) {
        try {
            return new ResponseEntity<>(edUserService.getUserComplaint(eduid),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getAllPayment")
    public ResponseEntity<List<EdUserPaymentEntity>> getAllPayment() {
        try {
            return new ResponseEntity<>(edUserService.getAllPatment(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
    }

    @PreAuthorize("hasAnyAuthority('EDA','EDO')")
    @GetMapping("/getAllComplaint")
    public ResponseEntity<List<EdUserPaymentEntity>> getAllComplaint(@RequestParam("trueOrFalse") String trueOrFalse) {
        try {
            return new ResponseEntity<>(edUserService.getAllCompliants(trueOrFalse),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
        }
    }
}
