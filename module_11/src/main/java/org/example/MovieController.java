package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.listMovies());
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Movie>> getMoviesByDirector(
            @RequestParam String name) {
        return ResponseEntity.ok(movieService.findByDirector(name));
    }

    @PostMapping
    public ResponseEntity<Void> addMovie(
            @RequestBody @Validated MovieRequest movieRequest) {
        movieService.addMovie(movieRequest);
        return ResponseEntity.ok().build();
    }
}
