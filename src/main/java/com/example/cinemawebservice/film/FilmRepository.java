package com.example.cinemawebservice.film;

import business.Film;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface FilmRepository extends MongoRepository<Film, String> {


    @Query("{ 'language' : ?0 }")
    List<Film> findFilmByLanguage(String language);

    @Query("{ 'main_actor' : ?0 }")
    List<Film> findFilmByMain_actor(String main_actor);

    @Query("{ 'main_actor' : ?0 , 'language' : ?1 }")
    List<Film> findFilmByMain_actorAndLanguage(String main_actor, String language);

    @Query("{ 'title' : ?0 }")
    Film findoneFilmByTitle(String title);

}
