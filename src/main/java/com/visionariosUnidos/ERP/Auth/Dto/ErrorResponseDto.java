package com.visionariosUnidos.ERP.Auth.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String apiPath; // The api path that failed
    private HttpStatus errorCode;
    private String errorMessage;
    private LocalDateTime errorTime;

}
