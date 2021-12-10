package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

import static java.lang.System.arraycopy;

@Data

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int defaultMovieLength = 10;

    MovieManager() {
    }

    public MovieManager(int customMovieLength) {
        if (customMovieLength > 0) {
            defaultMovieLength = customMovieLength;
        }
    }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastMovie = tmp.length - 1;
        tmp[lastMovie] = movie;
        movies = tmp;
    }

    public Movie[] getLastAdd() {
        int moviesLength = movies.length;
        int resultLength = movies.length > defaultMovieLength ? defaultMovieLength : moviesLength;
        Movie[] result = new Movie[resultLength];
        for (int i = 1; i <= resultLength; i++) {
            result [i - 1] = movies[movies.length - i];
        }

        return result;
    }
}