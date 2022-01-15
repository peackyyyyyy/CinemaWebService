package com.example.cinemawebservice.seance;

import business.Seance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeanceRepository extends MongoRepository<Seance, String> {

}
