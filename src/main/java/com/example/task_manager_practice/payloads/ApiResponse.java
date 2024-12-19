package com.example.task_manager_practice.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.security.SecureRandom;
import java.util.Base64;

@Setter
@Getter
@NoArgsConstructor
public class ApiResponse<T> {
    private HttpStatus status;
    private T data;

    public ApiResponse(HttpStatus status, T data) {
        this.status = status;
        this.data = data;
    }
//    public String ApiKey(){
//        SecureRandom random = new SecureRandom();
//        byte[] apiKeyBytes = new byte[32];
//        random.nextBytes(apiKeyBytes);
//        return Base64.getUrlEncoder().withoutPadding().encodeToString(apiKeyBytes);
//    }
}