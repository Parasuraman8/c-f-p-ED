package com.vishnuparasu.EnforcementDirectorate.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishnuparasu.EnforcementDirectorate.entity.EdRolesEntity;
import com.vishnuparasu.EnforcementDirectorate.entity.EdUserCredentials;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EdJwtUtill {


    private static final Logger LOGGER = LoggerFactory.getLogger(EdJwtUtill.class);

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;
    private static final String SECRET_KEY = "b1i37ZGr69mFIZcHxSqMIPN6DXUir8pVpIMn/cKpNYFFZ2mMrEAtIyrTFeDGmiOfyYMNlkldmumVFb+ZXKbKig==";

    public String generateAccessToken(EdUserCredentials edUserCredentials) {
        Set<EdRolesEntity> setOfRoles = edUserCredentials.getEdRolesModels();
        if (!setOfRoles.isEmpty()) {
            EdRolesEntity entity = setOfRoles.iterator().next();
            return Jwts.builder()
                    .setSubject(edUserCredentials.getUserName())
                    .setIssuer("VishnuParasu")
                    .claim("roles", entity.getRole())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
        } else  {
            return "Error While create token";
        }
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Signature validation failed");
        }

        return false;
    }


    public Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

}
