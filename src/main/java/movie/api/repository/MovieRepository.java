package movie.api.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import movie.api.model.Movie;



public interface MovieRepository extends JpaRepository<Movie, String> {

     List<Movie> findByRanking(Integer ranking);
}