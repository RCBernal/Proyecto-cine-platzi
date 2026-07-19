package com.cine.Cine.web.controller;

import com.cine.Cine.domain.dto.MovieDto;
import com.cine.Cine.domain.dto.SuggestRequestDto;
import com.cine.Cine.domain.dto.UpdateMovieDto;
import com.cine.Cine.domain.service.MovieService;
import com.cine.Cine.domain.service.PlatziPlayAiService;
import dev.langchain4j.service.UserMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final PlatziPlayAiService aiService;

    public MovieController(MovieService movieService, PlatziPlayAiService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping()
    public ResponseEntity <List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id) {
        MovieDto movieDto=this.movieService.getById(id);
        return (movieDto==null) ? ResponseEntity.notFound().build(): ResponseEntity.ok(movieDto);
    }

    @PostMapping("/suggestion")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.aiService.generateMovieSuggestion(suggestRequestDto.userPreference()));

    }

    @PostMapping("/new")
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.addMovie(movieDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable long id,@RequestBody UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.updateMovie(id,updateMovieDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable long id) {
        boolean deleted = this.movieService.deleteMovie(id);
        return (deleted)?ResponseEntity.ok().build():ResponseEntity.notFound().build();

    }
}
