package com.onlinejobportal.common.exceptions;

import com.onlinejobportal.common.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by pankaj on 08,2018
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({JPAException.class})
    public ResponseEntity<ApiErrorResponse> jpaException(Exception ex,HttpServletResponse response){
        return error(ex,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiErrorResponse> exception(Exception ex,HttpServletResponse response){
        return error(ex,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ApiErrorResponse> error(final Exception exception, final HttpStatus httpStatus) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity(new ApiErrorResponse(message), httpStatus);
    }
}
