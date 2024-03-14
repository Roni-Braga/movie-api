package movie.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import movie.api.model.Movie;
import movie.api.model.MovieDTO;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

}