package com.example.cinemawebservice.cinema;

import com.example.cinemawebservice.business.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CinemaRepository extends MongoRepository<Cinema, String> {

    @Query("{ 'address.city' : { '$in' : ?0 }}")
    List<Cinema> findCinemaByCities(List<String> city);

    @Query("{ 'film.title' : { '$in' : ?0 }}")
    List<Cinema> findCinemaByMovies(List<String> film);

    @Query("{ 'film.title' : { '$in' : ?0 }, 'address.city' : { '$in' : ?1 }}")
    List<Cinema> findCinemaByMoviesandfindCinemaByCities(List<String> film, List<String> city);

    @Query("{ 'address.city' :  ?0 }")
    List<Cinema> findCinemaByCity(String city);

    @Query("{ 'film.title' :  ?0 }")
    List<Cinema> findCinemaByMovie(String movie);

}

