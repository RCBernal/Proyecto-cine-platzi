package com.cine.Cine.exception;

public class MovieAlreadyExistException extends RuntimeException {
    public MovieAlreadyExistException(String movieTitle) {
        super("la pelicula " + movieTitle + " ya existe");
    }
}
