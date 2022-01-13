package com.example.cinemawebservice.cinema;

import business.Cinema;
import business.Film;
import com.example.cinemawebservice.film.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@AllArgsConstructor
@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final FilmRepository filmRepository;

    @GetMapping
    public List<Cinema> get_all_cinemas(){
        return cinemaRepository.findAll();
    }

    @GetMapping
    public Cinema add_new_cinema(String city, String address, List<Film> films){
        return cinemaRepository.insert(new Cinema(null, city, address, films));
    }

    @GetMapping
    public void delete_cinema(Cinema cinema){
        cinemaRepository.delete(cinema);
    }

    @GetMapping
    public Optional<Cinema> get_cinema_by_id(String id){
        return cinemaRepository.findById(id);
    }

    @GetMapping
    public List<Cinema> get_cinemas_by_city(String city){
        return cinemaRepository.findCinemaByCity(city);
    }

    @GetMapping
    public List<Cinema> get_cinemas_by_movie(String movie){
        return cinemaRepository.findCinemaByMovie(movie);
    }


}