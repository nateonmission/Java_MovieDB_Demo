package dev.nateontechnology.movieTutorial.Controllers;

import dev.nateontechnology.movieTutorial.Document_Classes.Movie;
import dev.nateontechnology.movieTutorial.Services.MovieServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieServices movieServices;

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies(){
         return new ResponseEntity<List<Movie>>(movieServices.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/ObjId/{movieId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable ObjectId movieId) {
        return new ResponseEntity<Optional<Movie>>(movieServices.getMovieById(movieId), HttpStatus.OK);

    }

    @GetMapping("/{movieImdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String movieImdbId) {
        return new ResponseEntity<Optional<Movie>>(movieServices.getMovieByImdbId(movieImdbId), HttpStatus.OK);

    }

}
