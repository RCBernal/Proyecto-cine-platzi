package com.cine.Cine.persistence.mapper;

import com.cine.Cine.domain.dto.MovieDto;
import com.cine.Cine.domain.dto.UpdateMovieDto;
import com.cine.Cine.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel ="spring",uses = {GenreMapper.class})
public interface MovieMapper {

    @Mapping(source = "title",target = "tittle")
    @Mapping(source = "duration",target = "duration")
    @Mapping(source = "gender",target = "genre",qualifiedByName = "stringToGenre")
    @Mapping(source = "releaseDate",target = "releaseDate")
    @Mapping(source = "clasification",target = "rating")
    @Mapping(source = "state",target = "state",qualifiedByName = "stateToBoolean")
    MovieDto toDto(MovieEntity entity); //Recibimos un Entity y lo comvertimos a un DTO
    List<MovieDto> toDto(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "genre",target = "gender",qualifiedByName = "genreToString")
    @Mapping(source = "state",target = "state",qualifiedByName = "BooleanToString")
    MovieEntity toEntity(MovieDto dto);

    @Mapping(target = "title",source = "tittle")
    @Mapping(target="releaseDate",source = "releaseDate")
    @Mapping(target="clasification",source="rating")
    @Mapping(target="state",source = "state",qualifiedByName = "BooleanToString")
    void updateEntityFromDto(UpdateMovieDto updateMovieDto, @MappingTarget MovieEntity movieEntity);
}
