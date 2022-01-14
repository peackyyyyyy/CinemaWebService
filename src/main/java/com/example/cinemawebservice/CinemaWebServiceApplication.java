package com.example.cinemawebservice;

import business.Address;
import business.Cinema;
import business.Film;
import business.Seance;
import com.example.cinemawebservice.cinema.CinemaRepository;
import com.example.cinemawebservice.film.FilmRepository;
import com.example.cinemawebservice.seance.SeanceRepository;
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
    SeanceRepository seanceRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CinemaWebServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(FilmRepository filmRepository){
        return args -> {

            Film film1 = new Film( "1", "La La Land", 128, List.of("Français"), List.of("none"), "Damien Chazelle", List.of("Emma Stone", "Ryan Gosling"), "Rated G", new Date(), new Date());
            Film film2 = new Film( "2", "Baby Driver", 115, List.of("Français"), List.of("none"), "Edgar Wright", List.of("Ansel Elgort"), "Rated PG-13", new Date(), new Date());
            Film film3 = new Film( "3", "Les Gardiens de la Galaxie", 122, List.of("VOSTFR"), List.of("subtitles"), "James Gunn", List.of("James Gunn"), "Rated PG", new Date(), new Date());
            Film film4 = new Film( "4", "Eternals", 157, List.of("Anglais"), List.of("VOSTFR"), "Chloé Zhao", List.of("Angelina Jolie", "Gemma Chan"), "Rated PG", new Date(), new Date());
            Film film5 = new Film( "5", "Dune", 125, List.of("Français"), List.of("none"), "Denis Villeneuve", List.of("Timothée Chalamet"), "Rated PG-13", new Date(), new Date());
            Film film6 = new Film( "6", "Free Guy", 115, List.of("Français"), List.of("none"), "Christophe Beck", List.of("Ryan Reynolds"), "Rated PG", new Date(), new Date());
            Film film7 = new Film( "7", "Jungle Cruise", 127, List.of("Français"), List.of("none"), "Jaume Collet-Serra", List.of("Dwayne Johnson"), "Rated PG", new Date(), new Date());
            Film film8 = new Film( "8", "Don't Look UP", 145, List.of("Anglais"), List.of("VOSTFR"), "Adam McKay", List.of("Leonardo DiCaprio", "Jennifer Lawrence"), "Rated PG", new Date(), new Date());
            Film film9 = new Film( "9", "Ghostbusters: Afterlife", 124, List.of("Français"), List.of("none"), "Jason Reitman", List.of("Mckenna Grace", "Finn Wolfhard"), "Rated PG", new Date(), new Date());
            Film film10 = new Film( "10", "A Quiet Place 2", 97, List.of("Anglais"), List.of("VOSTFR"), "John Krasinski", List.of("Cillian Murphy", "Emily Blunt"), "Rated R", new Date(), new Date());

            Seance seanceLundi1 = new Seance("Lundi", "9h", List.of(film1, film2));
            Seance seanceLundi2 = new Seance("Lundi", "11h",List.of(film4, film5));
            Seance seanceLundi3 = new Seance("Lundi", "14h", List.of(film1, film2));
            Seance seanceLundi5 = new Seance("Lundi", "18h",List.of(film4, film5));
            Seance seanceLundi6 = new Seance("Lundi", "20h",List.of(film4, film5));

            Cinema cinema1 = new Cinema("1", "UGC Cine Cite Bercy", new Address("2", "Cr Saint-Emilion", "75012", "Paris"), List.of(film1, film2, film3, film4, film5, film6), List.of(seanceLundi1, seanceLundi2 ));
            Cinema cinema2 = new Cinema("2", "MK2 Bibliotheque", new Address("128", "Av. de France", "75013", "Paris"), List.of(film1, film3, film5, film7, film9), List.of(seanceLundi1));
            Cinema cinema3 = new Cinema("3", "Gaumont Champs-Elysees", new Address("27", "Av. des Champs-Elysees", "75008", "Paris"), List.of(film10, film2, film3, film5, film8, film6), List.of(seanceLundi1));
            Cinema cinema4 = new Cinema("4", "Gaumont Alesia", new Address("73", "AV. du General Leclerc", "75014", "Paris"), List.of(film2, film3, film7, film8, film9, film10), List.of(seanceLundi1));
            Cinema cinema5 = new Cinema("5", "UGC Cine Cite les Halles", new Address("101", "Rue Berger", "75001", "Paris"), List.of(film1, film3, film4, film6, film9, film10), List.of(seanceLundi1));

            Cinema cinema6 = new Cinema("6", "UGC Cine Cite Lille", new Address("40", "rue de Bethune", "59800", "Lille"), List.of(film6, film7, film8, film9, film10), List.of(seanceLundi1));
            Cinema cinema7 = new Cinema("7", "Le Majestic", new Address("54", "rue de Bethune", "59800", "Lille"), List.of(film1, film2, film3), List.of(seanceLundi1));
            Cinema cinema8 = new Cinema("8", "Cinema l'Univers", new Address("16", "rue Georges Danton", "59000", "Lille"), List.of(film1, film3, film4, film5, film9, film10), List.of(seanceLundi1));
            Cinema cinema9 = new Cinema("9", "L'hybride", new Address("18", "rue Gosselet", "59000", "Lille"), List.of(film6, film7, film8, film9, film10), List.of(seanceLundi1));
            Cinema cinema10 = new Cinema("10", "Kinepolis", new Address("1", "rue du Chateau d'Isenghien", "59160", "Lille"), List.of(film1, film8), List.of(seanceLundi1));

            Cinema cinema11 = new Cinema("11", "Pathe Madeliane", new Address("36", "Av. du Marechal Foch", "13004", "Marseille"), List.of(film1, film5, film7, film8, film9, film10), List.of(seanceLundi1));
            Cinema cinema12 = new Cinema("12", "Les Varietes", new Address("37", "rue Vincent Scotto", "13001", "Marseille"), List.of(film1, film4, film8), List.of(seanceLundi1));
            Cinema cinema13 = new Cinema("13", "Prado", new Address("36", "Av. du Prado", "13006", "Marseille"), List.of(film1, film4, film6, film7, film9, film10), List.of(seanceLundi1));
            Cinema cinema14 = new Cinema("14", "Le Cesar", new Address("4", "Pl. Castellane", "13006", "Marseille"), List.of(film1, film2, film3, film4, film5, film6), List.of(seanceLundi1));
            Cinema cinema15 = new Cinema("15", "La Joliette", new Address("54", "rue de Chanterac", "13002", "Marseille"), List.of(film5, film6, film7, film8, film9, film10), List.of(seanceLundi1));

            Cinema cinema16 = new Cinema("16", "Pathe Bellacour", new Address("79", "rue de la Republique", "69002", "Lyon"), List.of(film1, film2, film4, film5, film8, film10), List.of(seanceLundi1));
            Cinema cinema17 = new Cinema("17", "UGC Cine Cite Internationale", new Address("80", "Quai Charles de Gaulle", "69006", "Lyon"), List.of(film1, film2, film3, film6, film8, film10), List.of(seanceLundi1));
            Cinema cinema18 = new Cinema("18", "UGC Astoria", new Address("31", "Cr Vitton", "69006", "Lyon"), List.of(film1, film2, film3, film4, film8, film9), List.of(seanceLundi1));
            Cinema cinema19 = new Cinema("19", "Pathe Vaise", new Address("43", "rue des Docks", "69009", "Lyon"), List.of(film5, film6, film7, film8, film9, film10), List.of(seanceLundi1));
            Cinema cinema20 = new Cinema("20", "UGC Cine Cite Confluence", new Address("112", "Cr Charlemagne", "69002", "Lyon"), List.of(film4, film5, film8, film9, film10), List.of(seanceLundi1));
            try {
                cinemaRepository.deleteAll();
                filmRepository.deleteAll();
                cinemaRepository.insert(List.of(cinema1, cinema2, cinema3, cinema4, cinema5, cinema6, cinema7, cinema8, cinema9, cinema10, cinema11, cinema12, cinema13, cinema14, cinema15, cinema16, cinema17, cinema18, cinema19, cinema20));
                filmRepository.insert(List.of(film1, film2, film3, film4, film5, film6, film7, film8, film9, film10));
            }
            catch (Exception exception){
                cinemaRepository.deleteAll();
                filmRepository.deleteAll();
                System.out.println("ok");
            }

        };
    }

}
