package com.riderx.ecom.handlers;

import com.riderx.ecom.exceptions.EntityNotFoundException;
import com.riderx.ecom.exceptions.InvalideEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorDto> handleExceptions(EntityNotFoundException exception, WebRequest webRequest){


        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(notFound.value())
                .errorCodes(exception.getErrorCodes())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDto ,notFound);
    }

    @ExceptionHandler({InvalideEntityException.class})
    public ResponseEntity<ErrorDto> handleExceptions(InvalideEntityException exception, WebRequest webRequest){


        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .httpCode(badRequest.value())
                .errorCodes(exception.getErrorCodes())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorDto ,badRequest);
    }

}
