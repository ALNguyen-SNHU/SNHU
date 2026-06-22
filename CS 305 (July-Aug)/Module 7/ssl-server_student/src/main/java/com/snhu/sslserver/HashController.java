/*
 * Name: Andrew L. Nguyen
 * Date: 8/18/2025
 * Time: 12:56 PM
 * LATE SUBMISSION
 * Note: Copilot Assistance (For understanding instructions and coding)
 */

package com.snhu.sslserver;

import org.springframework.web.bind.annotation.GetMapping;      // Spring annotation to map HTTP GET requests to a method
// It tells Spring: "When someone makes an HTTP GET request to this URL, run this method."

import org.springframework.web.bind.annotation.RequestParam;    // Spring annotation to bind URL query parameters to method arguments
// lets us grab extra info the user typed into the URL after the "?" — like pulling a note someone left in their request.

import org.springframework.web.bind.annotation.RestController;  // Marks this class as a REST controller so Spring exposes its methods as web endpoints
// Without it, Spring wouldn’t know to share our method on the web. 

import java.nio.charset.StandardCharsets;                       // Provides standard character encodings (like UTF-8) for string/byte conversion
// Computers store text as bytes. This makes sure we’re all speaking the same "alphabet" (UTF-8) when we turn text into bytes.

import java.security.MessageDigest;                             // Java class used to calculate cryptographic hash functions (e.g., SHA-256)

@RestController
public class HashController {

    // URL: https://localhost:8443/hash

    @GetMapping("/hash")        // Maps GET requests for /hash to this method
    public String hash(@RequestParam(value = "data", required = false) String data) {
        // Default value if no query parameter is provided
        // This is customizable
        if (data == null || data.isBlank()) {
            data = "Andrew Nguyen | Supposed to insert a unique string here or whatever. Hi.";
        }

        // Sanitize/limit the input
        String safe = htmlEscape(trimToMax(data, 256));
        String algorithm = "SHA-256";
        String digest = sha256Hex(safe);

        return "<h2>Checksum Verification</h2>"
             + "<p><b>Name:</b> Andrew Nguyen</p>"                  // Name of the person
             + "<p><b>Data:</b> " + safe + "</p>"                   // The data being hashed
             + "<p><b>Algorithm:</b> " + algorithm + "</p>"         // The hashing algorithm used
             + "<p><b>Checksum (hex):</b> " + digest + "</p>";      // The resulting checksum
    }

    // Method to compute SHA-256 hash of a string and return it as a hex string
    private static String sha256Hex(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");    // Create SHA-256 hash function
            byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));      // Compute hash (by digesting the input bytes) Nontechnical: "Turn the input text into a fixed-size string of bytes"
            StringBuilder sb = new StringBuilder(hash.length * 2);                // StringBuilder for hex output (Nontechnical: "Build a string to hold the hex representation")

            // For each byte in the hash
            for (byte b : hash) {
                String hx = Integer.toHexString(b & 0xff);                        // Convert byte to hex string then...
                if (hx.length() == 1) sb.append('0');                           // Pad with leading zero if needed...
                sb.append(hx);                                                    // Append hex string to StringBuilder
            }
            return sb.toString();                                                 // Convert StringBuilder to String

        // If something goes wrong, return an error message
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }
    }

    // Trims a string to a maximum length, ensuring it doesn't exceed the specified limit
    private static String trimToMax(String s, int max) {
        return s.length() <= max ? s : s.substring(0, max);
    }

    // Escapes special HTML characters in a string to prevent HTML injection
    private static String htmlEscape(String s) {
        return s.replace("&", "&amp;")      // Escape ampersands
                .replace("<", "&lt;")       // Escape less-than signs
                .replace(">", "&gt;")       // Escape greater-than signs
                .replace("\"", "&quot;")    // Escape double quotes
                .replace("'", "&#39;");     // Escape single quotes
    }
}
