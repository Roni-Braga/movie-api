package movie.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.api.model.Movie;
import movie.api.model.MovieDTO;
import movie.api.repository.MovieRepository;

@Service
public class MovieServices {

    @Autowired
    private MovieRepository repository;

    public Movie save(Movie dados) {
        return repository.save(dados);
    }
}
