package com.cine.Cine.domain.service;

import com.cine.Cine.domain.dto.MovieDto;
import com.cine.Cine.domain.dto.UpdateMovieDto;
import com.cine.Cine.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
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

    @Tool("Busca todas las peliculas que existan dentro de la plataforma")
    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto addMovie(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public MovieDto updateMovie(long id,UpdateMovieDto updateMovieDto) {
        return this.movieRepository.updateMovie(id,updateMovieDto);
    }

    public boolean deleteMovie(long id) {
       return movieRepository.deleteMovie(id);
    }
}
