package com.example.cinemawebservice.film;

import business.Film;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FilmRepository extends MongoRepository<Film, String> {

    @Query("{ 'title' : ?0 }")
    Film findFilmByTitle(String title);


}
