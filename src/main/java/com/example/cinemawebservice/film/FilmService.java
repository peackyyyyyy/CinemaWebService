package com.example.cinemawebservice.film;

import business.Film;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCursor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping
    public List<Film> get_films_with_params(Optional<String> language, Optional<String> main_actor){
        if (language.isPresent() && main_actor.isEmpty()) {
            return filmRepository.findFilmByLanguage(language.get());
        }
        else if (language.isEmpty() && main_actor.isPresent()) {
            return filmRepository.findFilmByMain_actor(main_actor.get());
        }
        else if (language.isPresent() && main_actor.isPresent()) {
            return filmRepository.findFilmByMain_actorAndLanguage(main_actor.get(), language.get());
        }
        else return filmRepository.findAll();
    }

    @GetMapping
    public void delete_film(String id){
        filmRepository.deleteById(id);
    }

    @GetMapping
    public List<String> get_all_film_titles(){
        DistinctIterable<String> distinctIterable = mongoTemplate.getCollection("film").distinct("title", String.class);
        List<String> categoryList = new ArrayList<>();
        MongoCursor<String> cursor = distinctIterable.iterator();
        while (cursor.hasNext()) {
            String category = cursor.next();
            categoryList.add(category);
        }
        return categoryList;
    }

    @GetMapping
    public List<String> get_all_film_language(){
        DistinctIterable<String> distinctIterable = mongoTemplate.getCollection("film").distinct("language", String.class);
        List<String> categoryList = new ArrayList<>();
        MongoCursor<String> cursor = distinctIterable.iterator();
        while (cursor.hasNext()) {
            String category = cursor.next();
            categoryList.add(category);
        }
        return categoryList;
    }

    @GetMapping
    public List<String> get_all_film_main_actor(){
        DistinctIterable<String> distinctIterable = mongoTemplate.getCollection("film").distinct("main_actor", String.class);
        List<String> categoryList = new ArrayList<>();
        MongoCursor<String> cursor = distinctIterable.iterator();
        while (cursor.hasNext()) {
            String category = cursor.next();
            categoryList.add(category);
        }
        return categoryList;
    }



    @GetMapping
    public Film add_new_film(String title, Integer duration, List<String> language, List<String> subtitles, String director, List<String> main_actors, String age, Date start, Date end){
        return filmRepository.insert(new Film(null, title, duration, language, subtitles, director, main_actors, age , start, end));
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
