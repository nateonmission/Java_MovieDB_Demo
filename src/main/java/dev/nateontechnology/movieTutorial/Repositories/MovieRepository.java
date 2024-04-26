package dev.nateontechnology.movieTutorial.Repositories;

import dev.nateontechnology.movieTutorial.Document_Classes.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}
