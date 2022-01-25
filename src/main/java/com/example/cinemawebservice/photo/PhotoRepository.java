package com.example.cinemawebservice.photo;

import com.example.cinemawebservice.business.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PhotoRepository extends MongoRepository<Photo, String> {



}
