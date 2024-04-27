package dev.nateontechnology.movieTutorial.Services;


import dev.nateontechnology.movieTutorial.Document_Classes.Movie;
import dev.nateontechnology.movieTutorial.Document_Classes.Review;
import dev.nateontechnology.movieTutorial.Repositories.MovieRepository;
import dev.nateontechnology.movieTutorial.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServices {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String author, String imdbId){
        Review review = new Review(reviewBody);
        review.setMovieImdbId(imdbId);
        review.setAuthor(author);


        mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviewIds").value(review))
            .first();

        return reviewRepository.insert(review);
    }

    public List<Review> getReviewByAuthor(String author){
        return reviewRepository.findReviewsByAuthor(author);
    }

    public List<Review> getReviewsByMovie(String imdbId) {
        return reviewRepository.findReviewsByMovieImdbId(imdbId);
    }
}
