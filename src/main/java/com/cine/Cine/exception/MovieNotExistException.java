package com.cine.Cine.exception;

public class MovieNotExistException extends RuntimeException{
    public MovieNotExistException(long id) {
        super("la pelicula " + id + " no existe, revisa bien el catalogo");
    }
}
