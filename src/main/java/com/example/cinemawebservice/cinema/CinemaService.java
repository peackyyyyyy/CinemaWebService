package com.example.cinemawebservice.cinema;

import business.Address;
import business.Cinema;
import business.Film;
import business.Seance;
import com.example.cinemawebservice.film.FilmRepository;
import com.example.cinemawebservice.seance.SeanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.*;

@AllArgsConstructor
@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final FilmRepository filmRepository;
    private final SeanceRepository seanceRepository;

    @GetMapping
    public List<Cinema> get_all_cinemas(){
        return cinemaRepository.findAll();
    }

    @GetMapping
    public Cinema add_new_cinema(String city, Address address, List<Film> films, List<Seance> seances){
        return cinemaRepository.insert(new Cinema(null, city, address, films, seances));
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