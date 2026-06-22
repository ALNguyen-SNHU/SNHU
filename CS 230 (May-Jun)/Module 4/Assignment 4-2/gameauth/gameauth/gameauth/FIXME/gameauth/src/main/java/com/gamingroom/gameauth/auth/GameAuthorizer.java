package com.gamingroom.gameauth.auth;

import io.dropwizard.auth.Authorizer;

public class GameAuthorizer implements Authorizer<GameUser> 
{
    @Override
    public boolean authorize(GameUser user, String role) {
    	
        // FIXME: Finish the authorize method based on BasicAuth Security Example
        // Explain:
        // 1. The method checks if the user has a specific role.
        // 2. It returns true if the user has the role, otherwise false.
        return user.getRoles() != null && user.getRoles().contains(role);
    	
    }
}