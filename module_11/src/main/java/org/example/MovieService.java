package org.example;

import java.util.List;

public interface MovieService {

    List<Movie> listMovies();

    List<Movie> findByDirector(String director);

    void addMovie(MovieRequest movieRequest);
}
