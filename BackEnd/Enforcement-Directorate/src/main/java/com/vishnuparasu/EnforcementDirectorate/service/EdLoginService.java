package com.vishnuparasu.EnforcementDirectorate.service;


import com.vishnuparasu.EnforcementDirectorate.model.EdLoginRequest;
import com.vishnuparasu.EnforcementDirectorate.model.EdLoginResponse;

public interface EdLoginService {

    EdLoginResponse login(EdLoginRequest edLoginRequest);

}
