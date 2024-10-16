package com.time_mgnt.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.time_mgnt.payloads.ApiResponse;

import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {

        String message = ex.getMessage();
        Long userId = (Long) ex.getFieldValue();
        ApiResponse apiResponse = new ApiResponse(message, false, userId);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String filedName = ((FieldError) error).getField();
            String msg = error.getDefaultMessage();
            resp.put(filedName, msg);
        });

        return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
    }
}
