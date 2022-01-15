package com.example.cinemawebservice.salle;

import business.Salle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalleRepository extends MongoRepository<Salle, String> {

}
