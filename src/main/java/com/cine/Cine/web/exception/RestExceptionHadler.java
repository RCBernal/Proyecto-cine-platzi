package com.cine.Cine.web.exception;

import com.cine.Cine.domain.dto.SuggestRequestDto;
import com.cine.Cine.exception.MovieAlreadyExistException;
import com.cine.Cine.exception.MovieNotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
