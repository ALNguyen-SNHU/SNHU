package com.gamingroom.gameauth.auth;


import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
 
import java.util.Map;
import java.util.Optional;
import java.util.Set;
 
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
 
public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> 
{
		
	private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );
 
    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException 
    {
        if (VALID_USERS.containsKey(credentials.getUsername()) && "password".equals(credentials.getPassword())) 
        {
            /*
             * Edited by: Andrew L. Nguyen
             * Date: 6/1/2024
            */
            // FIXME: Finish the authorize method based on BasicAuth Security Example for new GameUser
            // Create new GameUser with a dummy ID (e.g., 1) and assign the correct roles
            // Explain how:
            // 1. The ID is hardcoded for simplicity, but in a real application, it should be fetched from a database.
            // 2. The roles are fetched from the VALID_USERS map based on the username.
            // 3. The GameUser object is created with the ID, username, and roles.
            return Optional.of(new GameUser(credentials.getUsername(), VALID_USERS.get(credentials.getUsername())));

        }
        return Optional.empty();
    }
}
