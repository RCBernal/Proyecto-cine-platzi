package com.cine.Cine.domain.repository;

import com.cine.Cine.domain.dto.MovieDto;
import com.cine.Cine.domain.dto.UpdateMovieDto;

import java.util.List;


public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(Long id);
    MovieDto save(MovieDto movieDto);
    MovieDto updateMovie(Long id,UpdateMovieDto updateMovieDto);
    boolean deleteMovie(Long id);
}
