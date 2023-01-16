package co.istad.istadvdo.exception;

import co.istad.istadvdo.api.base.RestError;
import co.istad.istadvdo.api.base.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AppException {
    RestError<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ValidationError> validationErrors = new ArrayList<>();

        for (FieldError fieldError : e.getFieldErrors()) {
            var validationError = ValidationError.builder()
                    .field(fieldError.getField())
                    .detail(fieldError.getDefaultMessage())
                    .build();
            validationErrors.add(validationError);
        }
        return RestError.builder()
                .message("Bad Request")
                .code(HttpStatus.BAD_REQUEST.value())
                .status(false)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .errors(validationErrors)
                .build();
    }

    @ExceptionHandler(value = ResponseStatusException.class)
    RestError<?> handleResponseStatusException(ResponseStatusException e){
        return RestError.builder()
                .status(false)
                .message(e.getCause().getMessage())
                .code(e.getStatusCode().value())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .errors(e.getReason())
                .build();
    }
}
