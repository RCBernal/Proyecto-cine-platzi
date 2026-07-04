package com.cine.Cine.domain.service;

import com.cine.Cine.domain.dto.MovieDto;
import com.cine.Cine.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//se usa @Service para que esta clase forme parte del ecosistema de Spring y del contenedor de inversion de control
@Service
public class MovieService {
    //Esta clase va a injectar a MovieRepository
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto addMovie(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }
}
