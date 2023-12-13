package com.supermart.exception;

import com.supermart.model.RestResponce;
import com.supermart.transfer.ErrorTransfer;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ResourceBundle;

@ControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler
    public RestResponce fieldsRequiredException(FieldsRequiredException fe){
        return new RestResponce(fe.getMessage());
    }

    @ExceptionHandler
    public RestResponce invalidEmail(InvalidEmailException ie){
        return new RestResponce(ie.getMessage());
    }

    @ExceptionHandler
    public RestResponce invalidMobile(InvalidMobileException ie){
        return new RestResponce(ie.getMessage());
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorTransfer> handleNotFoundException(NotFoundException ex) {
        ErrorTransfer errorResponse = new ErrorTransfer(
                ex.getErrorCode(),
                ex.getErrorMessage(),
                ex.getDeveloperMessage(),
                ex.getDefaultMessage(),
                ex.getDefaultMessageParamMap()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorTransfer> handleNotFoundException(NotAcceptableException ex) {
        ErrorTransfer errorResponse = new ErrorTransfer(
                ex.getErrorCode(),
                ex.getErrorMessage(),
                ex.getDeveloperMessage(),
                ex.getDefaultMessage(),
                ex.getDefaultMessageParamMap()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
