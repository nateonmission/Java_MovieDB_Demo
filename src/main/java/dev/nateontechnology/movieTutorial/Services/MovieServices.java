package dev.nateontechnology.movieTutorial.Services;

import dev.nateontechnology.movieTutorial.Document_Classes.Movie;
import dev.nateontechnology.movieTutorial.Repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(ObjectId movieId){
        return movieRepository.findById(movieId);
    }

    public Optional<Movie> getMovieByImdbId(String movieImdbId){
        return movieRepository.findByImdbId(movieImdbId);
    }
}
