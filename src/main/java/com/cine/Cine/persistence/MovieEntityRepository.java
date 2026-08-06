package com.cine.Cine.persistence;

import com.cine.Cine.domain.dto.MovieDto;
import com.cine.Cine.domain.dto.UpdateMovieDto;
import com.cine.Cine.domain.repository.MovieRepository;
import com.cine.Cine.exception.MovieAlreadyExistException;
import com.cine.Cine.exception.MovieNotExistException;
import com.cine.Cine.persistence.crud.CrudMovieEntity;
import com.cine.Cine.persistence.entity.MovieEntity;
import com.cine.Cine.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public class MovieEntityRepository implements MovieRepository {
    public final CrudMovieEntity crudMovieEntity;
    public final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(Long id) {
        MovieEntity movieEntity=this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        if (this.crudMovieEntity.findFirstByTitle(movieDto.tittle()) != null) {
            throw new MovieAlreadyExistException(movieDto.tittle());
        }
        MovieEntity movieEntity=this.movieMapper.toEntity(movieDto);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto updateMovie(Long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity=this.crudMovieEntity.findById(id).orElse(null);

        if(movieEntity==null)throw new MovieNotExistException(id);
        this.movieMapper.updateEntityFromDto(updateMovieDto,movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public boolean deleteMovie(Long id) {

        MovieEntity movieEntity=this.crudMovieEntity.findById(id).orElse(null);
        if(movieEntity==null)throw new MovieNotExistException(id);

        return this.crudMovieEntity.findById(id).map(movieentity -> {
            this.crudMovieEntity.delete(movieentity);
            return true;
        }).orElse(false);
    }

}
