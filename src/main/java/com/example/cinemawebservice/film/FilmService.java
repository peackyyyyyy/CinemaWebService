package com.example.cinemawebservice.film;

import com.example.cinemawebservice.business.Film;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Date;
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
    public void delete_film(String id){
        filmRepository.deleteById(id);
    }


    @GetMapping
    public Film add_new_film(String title, Integer runtime, List<String> language, List<String> subtitles, String director, List<String> main_actors, String age, Date start, Date end){
        return filmRepository.insert(new Film(null, title, runtime, language, subtitles, director, main_actors, age , start, end));
    }

    @GetMapping
    public Film update_film(String id, String title, Integer duration, List<String> language, List<String> subtitles, String director, List<String> main_actors, String age, Date start, Date end){
        return filmRepository.save(new Film(id, title, duration, language, subtitles, director, main_actors, age , start, end));
    }

    @GetMapping
    public Optional<Film> get_film_by_id(String id){
        return filmRepository.findById(id);
    }


}
