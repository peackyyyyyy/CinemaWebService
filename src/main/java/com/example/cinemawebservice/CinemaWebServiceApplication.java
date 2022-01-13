package com.example.cinemawebservice;

import business.Cinema;
import business.Film;
import com.example.cinemawebservice.cinema.CinemaRepository;
import com.example.cinemawebservice.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class CinemaWebServiceApplication {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CinemaWebServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(FilmRepository filmRepository){
        return args -> {
            Film film1 = new Film( "1", "title1", 125, List.of("language"), List.of("subtitles"), "director", List.of("main_actor"), 18, new Date(), new Date());
            Film film2 = new Film( "2", "title2", 125, List.of("language"), List.of("subtitles"), "director", List.of("main_actor"), 18, new Date(), new Date());
            Film film3 = new Film( "3", "title3", 125, List.of("language"), List.of("subtitles"), "director", List.of("main_actor"), 18, new Date(), new Date());
            Film film4 = new Film( "4", "title4", 125, List.of("language"), List.of("subtitles"), "director", List.of("main_actor"), 18, new Date(), new Date());
            Film film5 = new Film( "5", "title5", 125, List.of("language"), List.of("subtitles"), "director", List.of("main_actor"), 18, new Date(), new Date());
            Cinema cinema1 = new Cinema("1", "paris", "adresse1", List.of(film1, film2));
            Cinema cinema2 = new Cinema("2", "marseille", "adresse2", List.of(film3, film4, film5));
            Cinema cinema3 = new Cinema("3", "nice", "adresse3", List.of(film1, film4, film2));
            Cinema cinema4 = new Cinema("4", "lille", "adresse4", List.of(film1, film2, film4, film5));
            try {
                cinemaRepository.insert(List.of(cinema1, cinema2, cinema3, cinema4));
                filmRepository.insert(List.of(film1, film2, film3, film4, film5));
            }
            catch (Exception exception){
                System.out.println("ok");
            }

        };
    }

}
