package com.vishnuparasu.EnforcementDirectorate.service;

import com.sun.org.apache.xalan.internal.xsltc.dom.StepIterator;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserBankEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserPaymentEntity;

import java.util.List;

public interface EdUserService {

    EdUserEntity getUser(String eduid);

    List<EdUserEntity> getAllUser();

    EdUserEntity modifyUser(EdUserEntity edUserEntity, String eduid);

    String deleteUser(String eduid);

    EdUserEntity createUser(EdUserEntity edUserEntity);

    EdUserBankEntity getUserBank(String eduid);

    List<EdUserBankEntity> getAllUserBank();

    EdUserPaymentEntity createUserPatment(EdUserPaymentEntity edUserPaymentEntity);

    List<EdUserPaymentEntity> getSenderDetail(String senderEduid);

    List<EdUserPaymentEntity> getRecevierDetail(String recevierEduid);

    List<EdUserPaymentEntity> getAllPatment();

    List<EdUserPaymentEntity> getUserComplaint(String eduid );

    List<EdUserPaymentEntity> getAllCompliants(String tureOrFalse);

    EdUserPaymentEntity modifyPayment(String value, int id);

    String getNoRow();
}
