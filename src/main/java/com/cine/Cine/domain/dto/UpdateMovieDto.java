package com.cine.Cine.domain.dto;

import java.time.LocalDate;


public record  UpdateMovieDto(
        String tittle,
        LocalDate releaseDate,
        Double rating,
        String state
) {
}
