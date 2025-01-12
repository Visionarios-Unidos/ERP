package com.visionariosUnidos.ERP.Auth.Exception;

import com.visionariosUnidos.ERP.Auth.Dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exc, WebRequest webReq){

        var errorResponseDto = new ErrorResponseDto(
                webReq.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exc.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponseDto);
    }

    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleUserAlreadyExistsException(Exception exc, WebRequest webReq){

        var errorResponseDto = new ErrorResponseDto(
                webReq.getDescription(false),
                HttpStatus.CONFLICT,
                exc.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponseDto);
    }
}
