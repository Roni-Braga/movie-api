package movie.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movie.api.model.Movie;
import movie.api.model.MovieDTO;
import movie.api.services.MovieServices;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieServices services;

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie dados) {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.save(dados));
    }
}
