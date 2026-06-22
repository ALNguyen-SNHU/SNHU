/*
 * Docstring
 * This is a simple Spring Boot application that provides a REST endpoint to return the SHA-256 hash of a given string.
 * Author: Andrew L. Nguyen
 * Date: 2025-08-02
 * Time: 4:53 PM
 */

package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

@RestController         // Will handle HTTP requests
class ServerController{ // Class name
//FIXME:  Add hash function to return the checksum value for the data string that should contain your name.    
    @RequestMapping("/hash")        // Maps HTTP requests to this method (http://localhost:8443/hash)
    public String myHash(){
    	String data = "Andrew Nguyen (Noogit because people can't say my last name correctly).";

        try {
            // Initialize Message Digest with SHA-256
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");    // Specify the algorithm for hashing
            byte[] hash = md.digest(data.getBytes());       // Generate the hash of the data string

            // Convert bytes to hex. This creates a human-readable string representation of the hash.
            StringBuilder hexString = new StringBuilder();        // Think of StringBuilder as a mutable string
            for (byte b : hash) {                                 // Loop through each byte in the hash
                String hex = Integer.toHexString(0xff & b);       // Convert byte to hex value string
                if (hex.length() == 1) hexString.append('0');   // Append leading zero if necessary
                hexString.append(hex);                            // Append the hex value to the StringBuilder
            }

            return "<p>data: " + data + "</p>" +
                   "<p>Name of Cipher Algorithm Used: SHA-256</p>" +
                   "<p>CheckSum Value: " + hexString.toString() + "</p>";

                   // Error handling for the case where the algorithm is not found
        } catch (java.security.NoSuchAlgorithmException e) {
            return "<p>Error generating hash: " + e.getMessage() + "</p>";
        }
    }
}
