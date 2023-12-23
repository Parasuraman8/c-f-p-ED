package com.vishnuparasu.EnforcementDirectorate.service.impl;

import com.vishnuparasu.EnforcementDirectorate.entity.EdUserBankEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserCredentials;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserEntity;
import com.vishnuparasu.EnforcementDirectorate.repository.EdUserBankRepo;
import com.vishnuparasu.EnforcementDirectorate.repository.EdUserCredentialRepo;
import com.vishnuparasu.EnforcementDirectorate.repository.EdUserRepo;
import com.vishnuparasu.EnforcementDirectorate.service.EdUserService;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
            modifyUser.setCommunity(edUserEntity.getCommunity());
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

        edUserRepo.deleteByEduid(eduid);
        edUserBankRepo.deleteByEduid(eduid);
        edUserCredentialRepo.deleteUserByEduid(eduid);

        return eduid;
    }

    @Override
    public EdUserEntity createUser(EdUserEntity edUserEntity) {
        EdUserCredentials userCredentials =  edUserEntity.getEdUserCredentials().iterator().next();
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        return edUserRepo.save(edUserEntity);
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

}
