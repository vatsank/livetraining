package com.example.demo.exceptions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerMapping;

@ControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<DriverException> handleGenericException(Exception e){
        DriverException DriverException = new DriverException(100, "From app handler Drivers are not found");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(DriverException);
   }

   
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<DriverException> handleRunTimeException(ResponseStatusException e, HttpServletRequest request){
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        DriverException DriverException = new DriverException(101, String.format("From  App handler Driver with id-%s is not found", pathVariables.get("id")));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(DriverException);

}
    
}
