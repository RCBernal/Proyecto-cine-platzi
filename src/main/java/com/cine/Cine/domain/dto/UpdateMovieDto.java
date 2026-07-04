package com.cine.Cine.domain.dto;

import com.cine.Cine.domain.Genre;

import java.time.LocalDate;


public record UpdateMovieDto(
        String tittle,
        LocalDate releaseDate,
        Double rating,
        String state
) {
}
