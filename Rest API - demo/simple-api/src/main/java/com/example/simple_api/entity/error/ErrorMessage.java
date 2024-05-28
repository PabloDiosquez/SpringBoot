package com.example.simple_api.entity.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorMessage {
    private HttpStatus status;
    private String message;
}
