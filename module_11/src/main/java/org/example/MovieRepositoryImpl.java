package org.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository{
    private final List<Movie> AVAILABLE_MOVIES = List.of(
            new Movie("Зеленая миля", "Фрэнк Дарабонт", 1999),
            new Movie("Побег из шоушенка", "Фрэнк Дарабонт", 1994),
            new Movie("Художественный фильм Скомуниздили", "Гай Ричи", 2000)
    );
    @Override
    public List<Movie> getAllMovies() {
        return AVAILABLE_MOVIES;
    }

    @Override
    public List<Movie> findByDirector(String director) {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie:
             AVAILABLE_MOVIES) {
            if (movie.getDirector().equals(director)) {
                movies.add(movie);
            }
        }

        return movies;
    }
}
