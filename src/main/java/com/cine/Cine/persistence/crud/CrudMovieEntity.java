package com.cine.Cine.persistence.crud;

import com.cine.Cine.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity,Long> {
}
