package com.vishnuparasu.EnforcementDirectorate.service;

import com.vishnuparasu.EnforcementDirectorate.entity.EdUserBankEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserEntity;

import java.util.List;

public interface EdUserService {

    EdUserEntity getUser(String eduid);

    List<EdUserEntity> getAllUser();

    EdUserEntity modifyUser(EdUserEntity edUserEntity, String eduid);

    String deleteUser(String eduid);

    EdUserEntity createUser(EdUserEntity edUserEntity);


    EdUserBankEntity getUserBank(String eduid);

    List<EdUserBankEntity> getAllUserBank();



}
