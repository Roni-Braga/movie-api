package movie.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.api.handler.BusinessException;
import movie.api.handler.CampoObrigatorioException;
import movie.api.model.Movie;
import movie.api.model.MovieDTO;
import movie.api.repository.MovieRepository;

@Service
public class MovieServices {

    @Autowired
    private MovieRepository repository;

    public Movie save(MovieDTO dados) {
        var movie = new Movie(dados);
        var rankingCadastrado = repository.findByRanking(movie.getRanking());

        System.out.println(rankingCadastrado);
        if (dados.name() == null)
            throw new CampoObrigatorioException("name");
            if (dados.description() == null)
            throw new CampoObrigatorioException("description");
            if (dados.ranking() == null)
            throw new CampoObrigatorioException("ranking");
             
        return repository.save(movie);
    }
    
    public List<Movie> ListAllMovie() {
        List<Movie> Movies = repository.findAll();
        return Movies;
    }


}
