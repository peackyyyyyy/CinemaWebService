package com.example.cinemawebservice;

import business.Address;
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
            Film film1 = new Film( "1", "La La Land", 128, List.of("language"), List.of("subtitles"), "Damien Chazelle", List.of("main_actor"), 13, new Date(), new Date());
            Film film2 = new Film( "2", "Baby Driver", 115, List.of("language"), List.of("subtitles"), "Edgar Wright", List.of("main_actor"), 13, new Date(), new Date());
            Film film3 = new Film( "3", "Les Gardiens de la Galaxie", 122, List.of("language"), List.of("subtitles"), "James Gunn", List.of("main_actor"), 13, new Date(), new Date());
            Film film4 = new Film( "4", "Eternals", 157, List.of("language"), List.of("subtitles"), "Chloé Zhao", List.of("main_actor"), 13, new Date(), new Date());
            Film film5 = new Film( "5", "Dune", 125, List.of("language"), List.of("subtitles"), "Denis Villeneuve", List.of("main_actor"), 13, new Date(), new Date());
            Film film6 = new Film( "6", "Free Guy", 115, List.of("language"), List.of("subtitles"), "Christophe Beck", List.of("main_actor"), 13, new Date(), new Date());
            Film film7 = new Film( "7", "Jungle Cruise", 127, List.of("language"), List.of("subtitles"), "Jaume Collet-Serra", List.of("main_actor"), 13, new Date(), new Date());
            Film film8 = new Film( "8", "Don't Look UP", 145, List.of("language"), List.of("subtitles"), "Adam McKay", List.of("main_actor"), 13, new Date(), new Date());
            Film film9 = new Film( "9", "The Rescue", 47, List.of("language"), List.of("subtitles"), "Jimmy Chin", List.of("main_actor"), 13, new Date(), new Date());
            Film film10 = new Film( "10", "A Quiet Place 2", 97, List.of("language"), List.of("subtitles"), "John Krasinski", List.of("main_actor"), 13, new Date(), new Date());

            Cinema cinema1 = new Cinema("1", "UGC Cine Cite Bercy", new Address("2", "Cr Saint-Emilion", "75012", "Paris"), List.of(film1, film2));
            Cinema cinema2 = new Cinema("2", "MK2 Bibliotheque", new Address("128", "Av. de France", "75013", "Paris"), List.of(film1, film2));
            Cinema cinema3 = new Cinema("3", "Gaumont Champs-Elysees", new Address("27", "Av. des Champs-Elysees", "75008", "Paris"), List.of(film1, film2));
            Cinema cinema4 = new Cinema("4", "Gaumont Alesia", new Address("73", "AV. du General Leclerc", "75014", "Paris"), List.of(film1, film2));
            Cinema cinema5 = new Cinema("5", "UGC Cine Cite les Halles", new Address("101", "Rue Berger", "75001", "Paris"), List.of(film1, film2));

            Cinema cinema6 = new Cinema("6", "UGC Cine Cite Lille", new Address("40", "rue de Bethune", "59800", "Lille"), List.of(film3, film4, film5));
            Cinema cinema7 = new Cinema("7", "Le Majestic", new Address("54", "rue de Bethune", "59800", "Lille"), List.of(film3, film4, film5));
            Cinema cinema8 = new Cinema("8", "Cinema l'Univers", new Address("16", "rue Georges Danton", "59000", "Lille"), List.of(film3, film4, film5));
            Cinema cinema9 = new Cinema("9", "L'hybride", new Address("18", "rue Gosselet", "59000", "Lille"), List.of(film3, film4, film5));
            Cinema cinema10 = new Cinema("10", "Kinepolis", new Address("1", "rue du Chateau d'Isenghien", "59160", "Lille"), List.of(film3, film4, film5));

            Cinema cinema11 = new Cinema("11", "Pathe Madeliane", new Address("36", "Av. du Marechal Foch", "13004", "Marseille"), List.of(film1, film4, film2));
            Cinema cinema12 = new Cinema("12", "Les Varietes", new Address("37", "rue Vincent Scotto", "13001", "Marseille"), List.of(film1, film4, film2));
            Cinema cinema13 = new Cinema("13", "Prado", new Address("36", "Av. du Prado", "13006", "Marseille"), List.of(film1, film4, film2));
            Cinema cinema14 = new Cinema("14", "Le Cesar", new Address("4", "Pl. Castellane", "13006", "Marseille"), List.of(film1, film4, film2));
            Cinema cinema15 = new Cinema("15", "La Joliette", new Address("54", "rue de Chanterac", "13002", "Marseille"), List.of(film1, film4, film2));

            Cinema cinema16 = new Cinema("16", "Pathe Bellacour", new Address("79", "rue de la Republique", "69002", "Lyon"), List.of(film1, film2, film4, film5));
            Cinema cinema17 = new Cinema("17", "UGC Cine Cite Internationale", new Address("80", "Quai Charles de Gaulle", "69006", "Lyon"), List.of(film1, film2, film4, film5));
            Cinema cinema18 = new Cinema("18", "UGC Astoria", new Address("31", "Cr Vitton", "69006", "Lyon"), List.of(film1, film2, film4, film5));
            Cinema cinema19 = new Cinema("19", "Pathe Vaise", new Address("43", "rue des Docks", "69009", "Lyon"), List.of(film1, film2, film4, film5));
            Cinema cinema20 = new Cinema("20", "UGC Cine Cite Confluence", new Address("112", "Cr Charlemagne", "69002", "Lyon"), List.of(film1, film2, film4, film5));
            try {
                cinemaRepository.insert(List.of(cinema1, cinema2, cinema3, cinema4, cinema5, cinema6, cinema7, cinema8, cinema9, cinema10, cinema11, cinema12, cinema13, cinema14, cinema15, cinema16, cinema17, cinema18, cinema19, cinema20));
                filmRepository.insert(List.of(film1, film2, film3, film4, film5, film6, film7, film8, film9, film10));
            }
            catch (Exception exception){
                System.out.println("ok");
            }

        };
    }

}
