package dev.nateontechnology.movieTutorial.Controllers;

import dev.nateontechnology.movieTutorial.Document_Classes.Movie;
import dev.nateontechnology.movieTutorial.Document_Classes.Review;
import dev.nateontechnology.movieTutorial.Services.ReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewServices reviewServices;

    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(reviewServices.createReview(payload.get("reviewBody"), payload.get("author"), payload.get("imdbId")), HttpStatus.CREATED);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Review>> getReviewByAuthor(@PathVariable String author) {
        return new ResponseEntity<List<Review>>(reviewServices.getReviewByAuthor(author), HttpStatus.OK);
    }
    @GetMapping("/movie/{imdbId}")
    public ResponseEntity<List<Review>> getReviewByMovie(@PathVariable String imdbId) {
        return new ResponseEntity<List<Review>>(reviewServices.getReviewsByMovie(imdbId), HttpStatus.OK);
    }
}
