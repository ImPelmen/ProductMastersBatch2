package org.example;

import org.springframework.stereotype.Repository;

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
}
