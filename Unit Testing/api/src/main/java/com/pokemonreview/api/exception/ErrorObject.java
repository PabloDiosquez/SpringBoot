package com.pokemonreview.api.exception;

import lombok.Data;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;

@Data
public class ErrorObject {
    private int statusCode;
    private String message;
    private Timestamp timestamp;
}
