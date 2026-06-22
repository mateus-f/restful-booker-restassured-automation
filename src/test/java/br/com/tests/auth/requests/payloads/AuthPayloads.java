package br.com.tests.auth.requests.payloads;

import java.util.HashMap;
import java.util.Map;

public class AuthPayloads {

    public Map<String, Object> validLogin() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "admin");
        payload.put("password", "password123");
        return payload;
    }

    public Map<String, Object> loginWithInvalidUsername() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "userInvalido");
        payload.put("password", "password123");
        return payload;
    }

    public Map<String, Object> loginWithInvalidPassword() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "admin");
        payload.put("password", "senhaErrada");
        return payload;
    }

    public Map<String, Object> loginWithEmptyFields() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "");
        payload.put("password", "");
        return payload;
    }

    public Map<String, Object> loginMissingUsername() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("password", "password123");
        return payload;
    }

    public Map<String, Object> loginMissingPassword() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "admin");
        return payload;
    }
}
