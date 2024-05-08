package com.pokemonreview.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@Data
public class ErrorObject {
    private int statusCode;
    private String message;
    private Date timestamp;
}
