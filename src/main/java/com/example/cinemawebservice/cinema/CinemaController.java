package com.example.cinemawebservice.cinema;

import business.Cinema;
import business.Film;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "cinemas")
public class CinemaController {
    private final CinemaService cinemaService;

    @PostMapping()
    public ResponseEntity<?> post_cinema(@RequestBody Map<String, Cinema> map) {
        return ResponseEntity.ok().body(cinemaService.add_new_cinema(map.get("cinema").getName(), map.get("cinema").getAddress(), map.get("cinema").getFilm()));
    }

    @DeleteMapping()
    public ResponseEntity<?> delete_cinema(@RequestBody Map<String, Cinema> map) {
        cinemaService.delete_cinema(map.get("cinema"));
        return ResponseEntity.ok().body(cinemaService.get_all_cinemas());
    }

    @RequestMapping()
    @GetMapping()
    public List<Cinema> fetchCinemaByCity(@RequestParam(required = false) List<String> city,
                                          @RequestParam(required = false) List<String> film){
        System.out.println(city);
        System.out.println(film);
        return cinemaService.get_cinemas_with_params(Optional.ofNullable(city), Optional.ofNullable(film));
    }


    @RequestMapping(path = "/movie={movie}")
    @GetMapping()
    public List<Cinema> fetchCinemaByFilm(@PathVariable(value="movie") String movie){
        return cinemaService.get_cinemas_by_movie(movie);
    }
}

