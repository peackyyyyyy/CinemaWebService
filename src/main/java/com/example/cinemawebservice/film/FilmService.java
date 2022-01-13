package com.example.cinemawebservice.film;

import business.Film;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @GetMapping
    public List<Film> get_films_with_params(Optional<List<String>> title){
        if (title.isPresent()) {
            return filmRepository.findFilmByTitle(title.get());
        }
        else return filmRepository.findAll();
    }

    @GetMapping
    public Optional<Film> get_film_by_id(String id){
        return filmRepository.findById(id);
    }


}
