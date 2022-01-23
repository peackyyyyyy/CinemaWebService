package com.example.cinemawebservice.screening;

import business.Screening;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ScreeningRepository extends MongoRepository<Screening, String> {

    @Query("{ id_cinema : ?0, 'id_film' : ?1 }")
    Screening findScreeningById_cinemaAndId_film(String id_cinema, String id_film);

}
