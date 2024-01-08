package com.vishnuparasu.EnforcementDirectorate.service;

import com.vishnuparasu.EnforcementDirectorate.entity.EdOfficerEntity;

import java.util.List;

public interface EdOfficerService {

    EdOfficerEntity getOfficer(String edoid);

    List<EdOfficerEntity> getAllOfficers();

    EdOfficerEntity modifyOfficer(EdOfficerEntity edOfficerEntity, String edoid);

    String deleteOfficer(String edoid);

    EdOfficerEntity createOfficer(EdOfficerEntity edOfficerEntity);

    long getNoRow();

}
