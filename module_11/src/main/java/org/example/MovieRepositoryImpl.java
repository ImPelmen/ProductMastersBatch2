package org.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository{
    private List<Movie> AVAILABLE_MOVIES = new ArrayList<>();

    public MovieRepositoryImpl() {
        AVAILABLE_MOVIES.add(new Movie("Зеленая миля", "Фрэнк Дарабонт", 1999));
        AVAILABLE_MOVIES.add(new Movie("Побег из шоушенка", "Фрэнк Дарабонт", 1994));
        AVAILABLE_MOVIES.add(new Movie("Художественный фильм Скомуниздили", "Гай Ричи", 2000));
    }

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

    @Override
    public void addMovie(Movie movie) {
        AVAILABLE_MOVIES.add(movie);
    }
}
