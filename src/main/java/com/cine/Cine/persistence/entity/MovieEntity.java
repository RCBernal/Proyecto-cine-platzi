package com.cine.Cine.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "platzi_play_peliculas")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String title;

    @Column(nullable = false,precision = 3)
    private  Integer duration;

    @Column(nullable = false,length = 40)
    private String gender;

    @Column(name = "fecha_estreno")
    private LocalDate releaseDate;

    @Column(precision = 3, scale = 2)
    private BigDecimal clasification;

    @Column(nullable = false,length = 1)
    private String state;
}
