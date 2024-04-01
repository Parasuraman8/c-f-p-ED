package com.vishnuparasu.EnforcementDirectorate.service.impl;

import com.vishnuparasu.EnforcementDirectorate.entity.*;
import com.vishnuparasu.EnforcementDirectorate.repository.EdUserBankRepo;
import com.vishnuparasu.EnforcementDirectorate.repository.EdUserCredentialRepo;
import com.vishnuparasu.EnforcementDirectorate.repository.EdUserPaymentRepo;
import com.vishnuparasu.EnforcementDirectorate.repository.EdUserRepo;
import com.vishnuparasu.EnforcementDirectorate.service.EdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EdUserServiceImpl implements EdUserService {

    @Autowired
    private EdUserRepo edUserRepo;

    @Autowired
    private EdUserBankRepo edUserBankRepo;

    @Autowired
    private EdUserCredentialRepo edUserCredentialRepo;

    @Autowired
    private EdUserPaymentRepo edUserPaymentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public EdUserEntity getUser(String eduid) {
        Optional<EdUserEntity> oneUser = edUserRepo.findByEduid(eduid);
        return oneUser.get();
    }

    @Override
    public List<EdUserEntity> getAllUser() {
        List<EdUserEntity> listOfAllUser = new ArrayList<>();
        edUserRepo.findAll().forEach(listOfAllUser::add);
        return listOfAllUser;
    }

    @Override
    public EdUserEntity modifyUser(EdUserEntity edUserEntity, String eduid) {
        Optional<EdUserEntity> userEntity = edUserRepo.findByEduid(eduid);
        if (userEntity.isPresent())  {
            EdUserEntity modifyUser = userEntity.get();
            modifyUser.setName(edUserEntity.getName());
            modifyUser.setGmail(edUserEntity.getGmail());
            modifyUser.setDob(edUserEntity.getDob());
            modifyUser.setAdharNumber(edUserEntity.getAdharNumber());
            modifyUser.setAddress(edUserEntity.getAddress());
            modifyUser.setJob(edUserEntity.getJob());
            modifyUser.setJobPosition(edUserEntity.getJobPosition());
            modifyUser.setPho(edUserEntity.getPho());
            modifyUser.setEdUserBankEntities(edUserEntity.getEdUserBankEntities());
            modifyUser.setFname(edUserEntity.getFname());
            modifyUser.setSalary(edUserEntity.getSalary());
            modifyUser.setJsd(edUserEntity.getJsd());
            modifyUser.setQualification(edUserEntity.getQualification());
            return edUserRepo.save(modifyUser);

        }
        return null;
    }

    @Transactional
    @Override
    public String deleteUser(String eduid) {
        edUserBankRepo.deleteByEduid(eduid);
        edUserCredentialRepo.deleteUserByEduid(eduid);
        edUserRepo.deleteByEduid(eduid);


        return eduid;
    }

    @Override
    public EdUserEntity createUser(EdUserEntity edUserEntity) {
        EdUserEntity entity = edUserEntity;
        entity.setEduid(getNoRow());
        EdUserCredentials userCredentials =  entity.getEdUserCredentials().iterator().next();
        userCredentials.setPassword(passwordEncoder.encode(entity.getDob().toString()));
        userCredentials.setUserName(getNoRow());
        EdRolesEntity roles  = userCredentials.getEdRolesModels().iterator().next();
        roles.setRole("EDU");
        roles.setRoleDesc("USER");
        return edUserRepo.save(entity);
    }


    @Override
    public EdUserBankEntity getUserBank(String eduid) {
        Optional<EdUserBankEntity> oneUserBank = edUserBankRepo.findUserBankByEduid(eduid);
        return oneUserBank.get();
    }

    @Override
    public List<EdUserBankEntity> getAllUserBank() {
        List<EdUserBankEntity> listOfAllBank = new ArrayList<>();
        edUserBankRepo.findAll().forEach(listOfAllBank::add);
        return listOfAllBank;
    }

    @Override
    public EdUserPaymentEntity createUserPatment(EdUserPaymentEntity edUserPaymentEntity) {
        LocalDateTime curentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = curentDateTime.format(formatter);
        edUserPaymentEntity.setDateAndTime(formatted);
        EdUserBankEntity edUserBankEntity = edUserBankRepo.findById(edUserPaymentEntity.getSenderAcctNo()).get();
        if ((edUserBankEntity.getTotalAmount() != 0) && (edUserBankEntity.getTotalAmount() != edUserPaymentEntity.getAmount() && edUserBankEntity.getTotalAmount() >= edUserPaymentEntity.getAmount())) {
            edUserBankEntity.setTotalAmount(edUserBankEntity.getTotalAmount()-edUserPaymentEntity.getAmount());
            edUserBankRepo.save(edUserBankEntity);
            EdUserBankEntity recevierBankEntity = edUserBankRepo.findById(edUserPaymentEntity.getRecevierAcctNo()).get();
            recevierBankEntity.setTotalAmount(recevierBankEntity.getTotalAmount()+edUserPaymentEntity.getAmount());
            edUserBankRepo.save(recevierBankEntity);
            return  edUserPaymentRepo.save(edUserPaymentEntity);
        }
        return null;

    }

    @Override
    public List<EdUserPaymentEntity> getSenderDetail(String senderEduid) {
        List<EdUserPaymentEntity> senderDetail = new ArrayList<>();
        edUserPaymentRepo.findSenderByEduid(senderEduid).forEach(senderDetail::add);
        return senderDetail;
    }

    @Override
    public List<EdUserPaymentEntity> getRecevierDetail(String recevierEduid) {
        List<EdUserPaymentEntity> recevierDetail = new ArrayList<>();
        edUserPaymentRepo.findRecevierByEduid(recevierEduid).forEach(recevierDetail::add);
        return recevierDetail;
    }

    @Override
    public List<EdUserPaymentEntity> getAllPatment() {
        List<EdUserPaymentEntity> edUserPaymentEntityList = new ArrayList<>();
        edUserPaymentRepo.findAll().forEach(edUserPaymentEntityList::add);
        return edUserPaymentEntityList;
    }

    @Override
    public List<EdUserPaymentEntity> getUserComplaint(String eduid) {
        List<EdUserPaymentEntity> userComplaintList = new ArrayList<>();
        edUserPaymentRepo.findUserComplaintSenderOrReciever(eduid).forEach(userComplaintList::add);
        return userComplaintList;
    }

    @Override
    public List<EdUserPaymentEntity> getAllCompliants(String trueOrFalse) {
        List<EdUserPaymentEntity> listOfEdUserPayment = new ArrayList<>();
        edUserPaymentRepo.findAllByCompliantBoolean(trueOrFalse).forEach(listOfEdUserPayment::add);
        return listOfEdUserPayment;
    }

    @Override
    public EdUserPaymentEntity modifyPayment(String value, int id) {
        EdUserPaymentEntity entity = edUserPaymentRepo.findById(id).get();
        entity.setIsLegal(value);
        return  edUserPaymentRepo.save(entity);
    }

    @Override
    public String getNoRow() {
        int lastRowId = 0;
        Integer maxId = edUserRepo.findMaxId();
        if (maxId != null) {
            lastRowId = maxId;
        }
        return "EDUID"+(lastRowId+1);
    }


}
