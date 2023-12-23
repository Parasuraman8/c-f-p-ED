package com.vishnuparasu.EnforcementDirectorate.service.impl;

import com.vishnuparasu.EnforcementDirectorate.entity.EdUserCredentials;
import com.vishnuparasu.EnforcementDirectorate.jwt.EdJwtUtill;
import com.vishnuparasu.EnforcementDirectorate.model.EdLoginRequest;
import com.vishnuparasu.EnforcementDirectorate.model.EdLoginResponse;
import com.vishnuparasu.EnforcementDirectorate.service.EdLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class EdLoginServiceImpl implements EdLoginService {


    @Autowired
    AuthenticationManager authManager;

    @Autowired
    EdJwtUtill edJwtUtill;

    @Override
    public EdLoginResponse login(EdLoginRequest edLoginRequest) {
        Authentication authentication = authManager.authenticate( new UsernamePasswordAuthenticationToken(edLoginRequest.getUsername(), edLoginRequest.getPassword()));

        EdUserCredentials edUserCredentials = (EdUserCredentials) authentication.getPrincipal();
        String accessToken = "Bearer "+edJwtUtill.generateAccessToken(edUserCredentials);

        return new EdLoginResponse(edUserCredentials.getUsername(),edUserCredentials.getEdRolesModels(),accessToken);
    }
}
