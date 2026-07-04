package com.cine.Cine.domain.dto;

import com.cine.Cine.domain.Genre;

import java.time.LocalDate;


public record MovieDto(
        Long id,
        String tittle,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        Boolean state
) {
}
