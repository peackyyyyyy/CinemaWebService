package com.example.cinemawebservice.cinema;

import business.Cinema;
import business.Film;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CinemaRepository extends MongoRepository<Cinema, String> {

    @Query("{ 'city' : ?0 }")
    List<Cinema> findCinemaByCity(String city);

    @Query("{ 'film' : { '$elemMatch' : { 'title' :  ?0 }}}")
    List<Cinema> findCinemaByMovie(String movie);

}

