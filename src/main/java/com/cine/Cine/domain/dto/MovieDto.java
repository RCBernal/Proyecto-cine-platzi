package com.cine.Cine.domain.dto;

import com.cine.Cine.domain.Genre;
import jakarta.validation.constraints.*;

import java.time.LocalDate;


public record MovieDto(
        Long id,

        @NotBlank(message = "El titulo es obligatorio")
        @NotNull
        String tittle,

        @PositiveOrZero(message = "El número debe ser cero o un valor positivo.")
        Integer duration,

        @NotNull
        Genre genre,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser menor al dia actual")
        LocalDate releaseDate,

        @Min(value = 0,message = "El rating no puede ser menor a 0")
        @Max(value = 5,message = "El rating no puede ser mayor a 5")
        Double rating,

        Boolean state
) {
}
