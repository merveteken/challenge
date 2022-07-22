package com.wcc.challenge.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GeographicNotFoundException extends RuntimeException{
    public GeographicNotFoundException( String message) {
    super(message);
    }
}
