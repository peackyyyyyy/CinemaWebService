package com.example.cinemawebservice.film;

import business.Film;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "films")
public class FilmController {
    private final FilmService filmService;

    @GetMapping()
    public List<Film> fetchAllFilms(){
        return filmService.get_all_films();
    }

    @RequestMapping(path = "/title={title}")
    @GetMapping()
    public Film fetchFilmbyTitle(@PathVariable(value="title") String title){
        return filmService.get_film_by_title(title);
    }


    @RequestMapping(path = "/id={id}")
    @GetMapping()
    public Optional<Film> fetchFilmbyId(@PathVariable(value="id") String id){
        return filmService.get_film_by_id(id);
    }
}
