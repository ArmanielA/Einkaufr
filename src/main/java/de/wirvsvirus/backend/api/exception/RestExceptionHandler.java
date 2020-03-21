package de.wirvsvirus.backend.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({OfferNotFoundException.class})
    protected ResponseEntity<Object> HandleNotFound(Exception e, WebRequest request){
        return handleExceptionInternal(e,"Offer could not be found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
