package movie.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import movie.api.model.Movie;
import movie.api.model.MovieDTO;
import movie.api.services.MovieServices;

@RestController
@RequestMapping("api/movie")
@OpenAPIDefinition(
        info = @Info(
            title = "API de Filmes", 
            description = "obtenha dados detalhados de diversos filmes e caso sinta falta de algum pode solicitar nossa equipe para adicionar", 
            version = "1.0",
            contact = @Contact(name = "Roni", email = "sousaronielson@gmail.com"))
)
public class MovieController {

    @Autowired
    private MovieServices services;

    @PostMapping
    public ResponseEntity<String> saveMovie(@RequestBody MovieDTO dados) {
        services.save(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body("Filme cadastrado com Sucesso");
    }

    @GetMapping
    public ResponseEntity<List<Movie>> ListAllMovie() {
        return ResponseEntity.status(HttpStatus.OK).body(services.ListAllMovie());
    }
}
