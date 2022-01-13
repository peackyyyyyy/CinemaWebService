package com.example.cinemawebservice.cinema;

import business.Cinema;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "cinemas")
public class CinemaController {
    private final CinemaService cinemaService;

    @GetMapping()
    public List<Cinema> fetchAllCinema(){
        return cinemaService.get_all_cinemas();
    }

    @PostMapping()
    public Cinema post_cinema(@RequestBody Map<String, Cinema> map) {
        return cinemaService.add_new_cinema(map.get("cinema").getName(), map.get("cinema").getAddress(), map.get("cinema").getFilm());
    }

    @DeleteMapping()
    public List<Cinema> delete_cinema(@RequestBody Map<String, Cinema> map) {
        cinemaService.delete_cinema(map.get("cinema"));
        return cinemaService.get_all_cinemas();
    }

    @RequestMapping(path = "/address={address}")
    @GetMapping()
    public List<Cinema> fetchCinemaByCity(@PathVariable(value="address") String city){
        return cinemaService.get_cinemas_by_city(address);
    }


    @RequestMapping(path = "/movie={movie}")
    @GetMapping()
    public List<Cinema> fetchCinemaByFilm(@PathVariable(value="movie") String movie){
        return cinemaService.get_cinemas_by_movie(movie);
    }
}

