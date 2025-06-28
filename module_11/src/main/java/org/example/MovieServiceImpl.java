package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> listMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public List<Movie> findByDirector(String director) {
        return movieRepository.findByDirector(director);
    }

    @Override
    public void addMovie(MovieRequest movieRequest) {
        if (movieRequest.getYear() < 1900) {
            throw new IllegalArgumentException("Movie year can not be younger than 1900");
        }

        Movie movie = Movie.builder()
                .title(movieRequest.getName())
                .director(movieRequest.getDirector())
                .year(movieRequest.getYear())
                .build();

        movieRepository.addMovie(movie);
    }
}
