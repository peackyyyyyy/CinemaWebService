package com.example.cinemawebservice.film;

import business.Film;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface FilmRepository extends MongoRepository<Film, String> {

    @Query("{ 'title' : { '$in' : ?0 }")
    List<Film> findFilmByTitle(List<String> title);

}
