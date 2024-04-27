package dev.nateontechnology.movieTutorial.Repositories;

import dev.nateontechnology.movieTutorial.Document_Classes.Movie;
import dev.nateontechnology.movieTutorial.Document_Classes.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    List<Review> findReviewsByAuthor(String author);
    List<Review> findReviewsByMovieImdbId(String imdbId);


}
