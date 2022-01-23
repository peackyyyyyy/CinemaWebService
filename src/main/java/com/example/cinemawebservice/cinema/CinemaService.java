package com.example.cinemawebservice.cinema;

import com.example.cinemawebservice.business.Address;
import com.example.cinemawebservice.business.Cinema;
import com.example.cinemawebservice.business.Film;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCursor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.*;

@AllArgsConstructor
@Service
public class CinemaService {

    @Autowired
    MongoTemplate mongoTemplate;

    private final CinemaRepository cinemaRepository;

    @GetMapping
    public List<Cinema> get_all_cinemas(){
        return cinemaRepository.findAll();
    }

    @GetMapping
    public Cinema add_new_cinema(String city, Address address, List<Film> films){
        return cinemaRepository.insert(new Cinema(null, city, address, films));
    }

    @GetMapping
    public Cinema update_cinema(String id, String city, Address address, List<Film> films){
        return cinemaRepository.save(new Cinema(id, city, address, films));
    }

    @GetMapping
    public List<String> get_all_city(){
        DistinctIterable<String> distinctIterable = mongoTemplate.getCollection("cinema").distinct("address.city", String.class);
        System.out.println(distinctIterable);
        List<String> categoryList = new ArrayList<>();
        MongoCursor<String> cursor = distinctIterable.iterator();
        while (cursor.hasNext()) {
            String category = cursor.next();
            categoryList.add(category);
        }
        return categoryList;
    }

    @GetMapping
    public void delete_cinema(String id){
        cinemaRepository.deleteById(id);
    }

    @GetMapping
    public Optional<Cinema> get_cinema_by_id(String id){
        return cinemaRepository.findById(id);
    }

    @GetMapping
    public List<Cinema> get_cinemas_with_params(Optional<List<String>> city, Optional<List<String>> film){
        if (city.isPresent() && film.isEmpty()) {
            return cinemaRepository.findCinemaByCities(city.get());
        }
        else if (city.isEmpty() && film.isEmpty()){
            return cinemaRepository.findAll();
        }
        else if (city.isEmpty()){
            return cinemaRepository.findCinemaByMovies(film.get());
        }
        else {
            return cinemaRepository.findCinemaByMoviesandfindCinemaByCities(film.get(), city.get());
        }
    }


    @GetMapping
    public List<Cinema> get_cinemas_by_movie(String movie){
        return cinemaRepository.findCinemaByMovie(movie);
    }


}