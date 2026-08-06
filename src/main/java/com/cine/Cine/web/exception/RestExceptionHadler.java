package com.cine.Cine.web.exception;

import com.cine.Cine.domain.dto.MovieDto;
import com.cine.Cine.exception.MovieAlreadyExistException;
import com.cine.Cine.exception.MovieNotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice //Esto le indicara a spring de que esta clase es la indicada de capturar las excepciones que ocurran dentro de la aplicacion
public class RestExceptionHadler {
    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistException exception) {
        Error error=new Error("Movie Already Exist", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieNotExistException.class)
    public ResponseEntity<Error> handleException(MovieNotExistException exception) {
        Error error=new Error("Movie Not exist in the list", exception.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errors=new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error->{
            errors.add(new Error(error.getField(),error.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        Error error=new Error("Unknown-Error", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
