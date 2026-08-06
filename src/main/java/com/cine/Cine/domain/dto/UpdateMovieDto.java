package com.cine.Cine.domain.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;


public record  UpdateMovieDto(
        @NotBlank(message = "El titulo es obligatorio")
        String tittle,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser menor al dia actual")
        LocalDate releaseDate,

        @Min(value = 0,message = "El rating no puede ser menor a 0")
        @Max(value = 5,message = "El rating no puede ser mayor a 5")
        Double rating,

        @NotBlank(message = "El titulo es obligatorio")
        @NotNull
        String state
) {
}
