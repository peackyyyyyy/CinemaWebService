package com.example.cinemawebservice;


import com.example.cinemawebservice.business.*;
import com.example.cinemawebservice.cinema.CinemaRepository;
import com.example.cinemawebservice.film.FilmRepository;
import com.example.cinemawebservice.screening.ScreeningRepository;
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

    @Autowired
    ScreeningRepository screeningRepository;

    public static void main(String[] args) {
        SpringApplication.run(CinemaWebServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(FilmRepository filmRepository){
        return args -> {
            Film film1 = new Film( "1", "La La Land", 128, List.of("FR, EN"), List.of("FR, EN"), "Damien Chazelle", List.of("Emma Stone", "Ryan Gosling"), "Rated G", new Date(), new Date());
            Film film2 = new Film( "2", "Baby Driver", 115, List.of("FR, EN, IT, ES"), List.of("FR, EN, IT, ES"), "Edgar Wright", List.of("Ansel Elgort"), "Rated PG-13", new Date(), new Date());
            Film film3 = new Film( "3", "Les Gardiens de la Galaxie", 122, List.of("FR, EN"), List.of("FR, EN"), "James Gunn", List.of("James Gunn"), "Rated PG", new Date(), new Date());
            Film film4 = new Film( "4", "Eternals", 157, List.of("FR, EN"), List.of("FR, EN"), "Chloé Zhao", List.of("Angelina Jolie", "Gemma Chan"), "Rated PG", new Date(), new Date());
            Film film5 = new Film( "5", "Dune", 125, List.of("FR"), List.of("FR"), "Denis Villeneuve", List.of("Timothée Chalamet"), "Rated PG-13", new Date(), new Date());
            Film film6 = new Film( "6", "Free Guy", 115, List.of("FR, EN, IT"), List.of("FR, EN, IT"), "Christophe Beck", List.of("Ryan Reynolds"), "Rated PG", new Date(), new Date());
            Film film7 = new Film( "7", "Jungle Cruise", 127, List.of("FR, EN,ES"), List.of("FR, EN,ES"), "Jaume Collet-Serra", List.of("Dwayne Johnson"), "Rated PG", new Date(), new Date());
            Film film8 = new Film( "8", "Don't Look UP", 145, List.of("FR, IT, ES"), List.of("FR, IT, ES"), "Adam McKay", List.of("Leonardo DiCaprio", "Jennifer Lawrence"), "Rated PG", new Date(), new Date());
            Film film9 = new Film( "9", "Ghostbusters: Afterlife", 124, List.of("FR, EN, IT, ES"), List.of("FR, EN, IT, ES"), "Jason Reitman", List.of("Mckenna Grace", "Finn Wolfhard"), "Rated PG", new Date(), new Date());
            Film film10 = new Film( "10", "A Quiet Place 2", 97, List.of("FR"), List.of("FR"), "John Krasinski", List.of("Cillian Murphy", "Emily Blunt"), "Rated R", new Date(), new Date());

            Cinema cinema1 = new Cinema("1", "UGC Cine Cite Bercy", new Address("2", "Cr Saint-Emilion", "75012", "Paris"), List.of(film1, film2, film3, film4, film5, film6));
            Cinema cinema2 = new Cinema("2", "MK2 Bibliotheque", new Address("128", "Av. de France", "75013", "Paris"), List.of(film1, film3, film5, film7, film9));
            Cinema cinema3 = new Cinema("3", "Gaumont Champs-Elysees", new Address("27", "Av. des Champs-Elysees", "75008", "Paris"), List.of(film10, film2, film3, film5, film8, film6));
            Cinema cinema4 = new Cinema("4", "Gaumont Alesia", new Address("73", "AV. du General Leclerc", "75014", "Paris"), List.of(film2, film3, film7, film8, film9, film10));
            Cinema cinema5 = new Cinema("5", "UGC Cine Cite les Halles", new Address("101", "Rue Berger", "75001", "Paris"), List.of(film1, film3, film4, film6, film9, film10));

            Cinema cinema6 = new Cinema("6", "UGC Cine Cite Lille", new Address("40", "rue de Bethune", "59800", "Lille"), List.of(film6, film7, film8, film9, film10));
            Cinema cinema7 = new Cinema("7", "Le Majestic", new Address("54", "rue de Bethune", "59800", "Lille"), List.of(film1, film2, film3));
            Cinema cinema8 = new Cinema("8", "Cinema l'Univers", new Address("16", "rue Georges Danton", "59000", "Lille"), List.of(film1, film3, film4, film5, film9, film10));
            Cinema cinema9 = new Cinema("9", "L'hybride", new Address("18", "rue Gosselet", "59000", "Lille"), List.of(film6, film7, film8, film9, film10));
            Cinema cinema10 = new Cinema("10", "Kinepolis", new Address("1", "rue du Chateau d'Isenghien", "59160", "Lille"), List.of(film1, film8));

            Cinema cinema11 = new Cinema("11", "Pathe Madeliane", new Address("36", "Av. du Marechal Foch", "13004", "Marseille"), List.of(film1, film5, film7, film8, film9, film10));
            Cinema cinema12 = new Cinema("12", "Les Varietes", new Address("37", "rue Vincent Scotto", "13001", "Marseille"), List.of(film1, film4, film8));
            Cinema cinema13 = new Cinema("13", "Prado", new Address("36", "Av. du Prado", "13006", "Marseille"), List.of(film1, film4, film6, film7, film9, film10));
            Cinema cinema14 = new Cinema("14", "Le Cesar", new Address("4", "Pl. Castellane", "13006", "Marseille"), List.of(film1, film2, film3, film4, film5, film6));
            Cinema cinema15 = new Cinema("15", "La Joliette", new Address("54", "rue de Chanterac", "13002", "Marseille"), List.of(film5, film6, film7, film8, film9, film10));

            Cinema cinema16 = new Cinema("16", "Pathe Bellacour", new Address("79", "rue de la Republique", "69002", "Lyon"), List.of(film1, film2, film4, film5, film8, film10));
            Cinema cinema17 = new Cinema("17", "UGC Cine Cite Internationale", new Address("80", "Quai Charles de Gaulle", "69006", "Lyon"), List.of(film1, film2, film3, film6, film8, film10));
            Cinema cinema18 = new Cinema("18", "UGC Astoria", new Address("31", "Cr Vitton", "69006", "Lyon"), List.of(film1, film2, film3, film4, film8, film9));
            Cinema cinema19 = new Cinema("19", "Pathe Vaise", new Address("43", "rue des Docks", "69009", "Lyon"), List.of(film5, film6, film7, film8, film9, film10));
            Cinema cinema20 = new Cinema("20", "UGC Cine Cite Confluence", new Address("112", "Cr Charlemagne", "69002", "Lyon"), List.of(film4, film5, film8, film9, film10));

            Screening screening1 = new Screening("1", "1", "1", List.of(new Seance("Lundi", List.of("14h", "21h")), new Seance("Mardi", List.of("18h", "20h")), new Seance("Mercredi", List.of("14h", "21h")), new Seance("Jeudi", List.of("18h", "20h")),new Seance("Vendredi", List.of("14h", "21h")),new Seance("Samedi", List.of("18h", "20h")),new Seance("Dimanche", List.of("14h", "21h"))));
            Screening screening2 = new Screening("2", "1", "2", List.of(new Seance("Lundi", List.of("15h", "18h")), new Seance("Mardi", List.of("14h", "16h")), new Seance("Mercredi", List.of("15h", "18h")), new Seance("Jeudi", List.of("14h", "16h")),new Seance("Vendredi", List.of("15h", "18h")),new Seance("Samedi", List.of("14h", "16h")),new Seance("Dimanche", List.of("15h", "18h"))));
            Screening screening3 = new Screening("3", "1", "3", List.of(new Seance("Lundi", List.of("16h", "22h")), new Seance("Mardi", List.of("09h", "18h")), new Seance("Mercredi", List.of("16h", "22h")), new Seance("Jeudi", List.of("09h", "18h")),new Seance("Vendredi", List.of("16h", "22h")),new Seance("Samedi", List.of("09h", "18h")),new Seance("Dimanche", List.of("16h", "22h"))));
            Screening screening4 = new Screening("4", "1", "4", List.of(new Seance("Lundi", List.of("09h", "18h")), new Seance("Mardi", List.of("16h", "22h")), new Seance("Mercredi", List.of("09h", "18h")), new Seance("Jeudi", List.of("16h", "22h")),new Seance("Vendredi", List.of("09h", "18h")),new Seance("Samedi", List.of("16h", "22h")),new Seance("Dimanche", List.of("09h", "18h"))));
            Screening screening5 = new Screening("5", "1", "5", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening6 = new Screening("6", "1", "6", List.of(new Seance("Lundi", List.of("18h", "20h")), new Seance("Mardi", List.of("14h", "21h")), new Seance("Mercredi", List.of("18h", "20h")), new Seance("Jeudi", List.of("14h", "21h")),new Seance("Vendredi", List.of("18h", "20h")),new Seance("Samedi", List.of("14h", "21h")),new Seance("Dimanche", List.of("18h", "20h"))));

            Screening screening7 = new Screening("7", "2", "1", List.of(new Seance("Lundi", List.of("14h", "21h")), new Seance("Mardi", List.of("18h", "20h")), new Seance("Mercredi", List.of("14h", "21h")), new Seance("Jeudi", List.of("18h", "20h")),new Seance("Vendredi", List.of("14h", "21h")),new Seance("Samedi", List.of("18h", "20h")),new Seance("Dimanche", List.of("14h", "21h"))));
            Screening screening8 = new Screening("8", "2", "3", List.of(new Seance("Lundi", List.of("15h", "18h")), new Seance("Mardi", List.of("14h", "16h")), new Seance("Mercredi", List.of("15h", "18h")), new Seance("Jeudi", List.of("14h", "16h")),new Seance("Vendredi", List.of("15h", "18h")),new Seance("Samedi", List.of("14h", "16h")),new Seance("Dimanche", List.of("15h", "18h"))));
            Screening screening9 = new Screening("9", "2", "5", List.of(new Seance("Lundi", List.of("16h", "22h")), new Seance("Mardi", List.of("09h", "18h")), new Seance("Mercredi", List.of("16h", "22h")), new Seance("Jeudi", List.of("09h", "18h")),new Seance("Vendredi", List.of("16h", "22h")),new Seance("Samedi", List.of("09h", "18h")),new Seance("Dimanche", List.of("16h", "22h"))));
            Screening screening10 = new Screening("10", "2", "7", List.of(new Seance("Lundi", List.of("09h", "18h")), new Seance("Mardi", List.of("16h", "22h")), new Seance("Mercredi", List.of("09h", "18h")), new Seance("Jeudi", List.of("16h", "22h")),new Seance("Vendredi", List.of("09h", "18h")),new Seance("Samedi", List.of("16h", "22h")),new Seance("Dimanche", List.of("09h", "18h"))));
            Screening screening11 = new Screening("11", "2", "9", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening12 = new Screening("12", "3", "10", List.of(new Seance("Lundi", List.of("14h", "21h")), new Seance("Mardi", List.of("18h", "20h")), new Seance("Mercredi", List.of("14h", "21h")), new Seance("Jeudi", List.of("18h", "20h")),new Seance("Vendredi", List.of("14h", "21h")),new Seance("Samedi", List.of("18h", "20h")),new Seance("Dimanche", List.of("14h", "21h"))));
            Screening screening13 = new Screening("13", "3", "2", List.of(new Seance("Lundi", List.of("15h", "18h")), new Seance("Mardi", List.of("14h", "16h")), new Seance("Mercredi", List.of("15h", "18h")), new Seance("Jeudi", List.of("14h", "16h")),new Seance("Vendredi", List.of("15h", "18h")),new Seance("Samedi", List.of("14h", "16h")),new Seance("Dimanche", List.of("15h", "18h"))));
            Screening screening14 = new Screening("14", "3", "3", List.of(new Seance("Lundi", List.of("16h", "22h")), new Seance("Mardi", List.of("09h", "18h")), new Seance("Mercredi", List.of("16h", "22h")), new Seance("Jeudi", List.of("09h", "18h")),new Seance("Vendredi", List.of("16h", "22h")),new Seance("Samedi", List.of("09h", "18h")),new Seance("Dimanche", List.of("16h", "22h"))));
            Screening screening15 = new Screening("15", "3", "5", List.of(new Seance("Lundi", List.of("09h", "18h")), new Seance("Mardi", List.of("16h", "22h")), new Seance("Mercredi", List.of("09h", "18h")), new Seance("Jeudi", List.of("16h", "22h")),new Seance("Vendredi", List.of("09h", "18h")),new Seance("Samedi", List.of("16h", "22h")),new Seance("Dimanche", List.of("09h", "18h"))));
            Screening screening16 = new Screening("16", "3", "8", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening17 = new Screening("17", "4", "2", List.of(new Seance("Lundi", List.of("14h", "21h")), new Seance("Mardi", List.of("18h", "20h")), new Seance("Mercredi", List.of("14h", "21h")), new Seance("Jeudi", List.of("18h", "20h")),new Seance("Vendredi", List.of("14h", "21h")),new Seance("Samedi", List.of("18h", "20h")),new Seance("Dimanche", List.of("14h", "21h"))));
            Screening screening18 = new Screening("18", "4", "3", List.of(new Seance("Lundi", List.of("15h", "18h")), new Seance("Mardi", List.of("14h", "16h")), new Seance("Mercredi", List.of("15h", "18h")), new Seance("Jeudi", List.of("14h", "16h")),new Seance("Vendredi", List.of("15h", "18h")),new Seance("Samedi", List.of("14h", "16h")),new Seance("Dimanche", List.of("15h", "18h"))));
            Screening screening19 = new Screening("19", "4", "7", List.of(new Seance("Lundi", List.of("16h", "22h")), new Seance("Mardi", List.of("09h", "18h")), new Seance("Mercredi", List.of("16h", "22h")), new Seance("Jeudi", List.of("09h", "18h")),new Seance("Vendredi", List.of("16h", "22h")),new Seance("Samedi", List.of("09h", "18h")),new Seance("Dimanche", List.of("16h", "22h"))));
            Screening screening20 = new Screening("20", "4", "8", List.of(new Seance("Lundi", List.of("09h", "18h")), new Seance("Mardi", List.of("16h", "22h")), new Seance("Mercredi", List.of("09h", "18h")), new Seance("Jeudi", List.of("16h", "22h")),new Seance("Vendredi", List.of("09h", "18h")),new Seance("Samedi", List.of("16h", "22h")),new Seance("Dimanche", List.of("09h", "18h"))));
            Screening screening21 = new Screening("21", "4", "9", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening22 = new Screening("22", "4", "10", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening23 = new Screening("23", "5", "1", List.of(new Seance("Lundi", List.of("14h", "21h")), new Seance("Mardi", List.of("18h", "20h")), new Seance("Mercredi", List.of("14h", "21h")), new Seance("Jeudi", List.of("18h", "20h")),new Seance("Vendredi", List.of("14h", "21h")),new Seance("Samedi", List.of("18h", "20h")),new Seance("Dimanche", List.of("14h", "21h"))));
            Screening screening24 = new Screening("24", "5", "3", List.of(new Seance("Lundi", List.of("15h", "18h")), new Seance("Mardi", List.of("14h", "16h")), new Seance("Mercredi", List.of("15h", "18h")), new Seance("Jeudi", List.of("14h", "16h")),new Seance("Vendredi", List.of("15h", "18h")),new Seance("Samedi", List.of("14h", "16h")),new Seance("Dimanche", List.of("15h", "18h"))));
            Screening screening25 = new Screening("25", "5", "4", List.of(new Seance("Lundi", List.of("16h", "22h")), new Seance("Mardi", List.of("09h", "18h")), new Seance("Mercredi", List.of("16h", "22h")), new Seance("Jeudi", List.of("09h", "18h")),new Seance("Vendredi", List.of("16h", "22h")),new Seance("Samedi", List.of("09h", "18h")),new Seance("Dimanche", List.of("16h", "22h"))));
            Screening screening26 = new Screening("26", "5", "6", List.of(new Seance("Lundi", List.of("09h", "18h")), new Seance("Mardi", List.of("16h", "22h")), new Seance("Mercredi", List.of("09h", "18h")), new Seance("Jeudi", List.of("16h", "22h")),new Seance("Vendredi", List.of("09h", "18h")),new Seance("Samedi", List.of("16h", "22h")),new Seance("Dimanche", List.of("09h", "18h"))));
            Screening screening27 = new Screening("27", "5", "9", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening28 = new Screening("28", "5", "10", List.of(new Seance("Lundi", List.of("14h", "21h")), new Seance("Mardi", List.of("18h", "20h")), new Seance("Mercredi", List.of("14h", "21h")), new Seance("Jeudi", List.of("18h", "20h")),new Seance("Vendredi", List.of("14h", "21h")),new Seance("Samedi", List.of("18h", "20h")),new Seance("Dimanche", List.of("14h", "21h"))));

            Screening screening29 = new Screening("29", "6", "6", List.of(new Seance("Lundi", List.of("15h", "18h")), new Seance("Mardi", List.of("14h", "16h")), new Seance("Mercredi", List.of("15h", "18h")), new Seance("Jeudi", List.of("14h", "16h")),new Seance("Vendredi", List.of("15h", "18h")),new Seance("Samedi", List.of("14h", "16h")),new Seance("Dimanche", List.of("15h", "18h"))));
            Screening screening30 = new Screening("30", "6", "7", List.of(new Seance("Lundi", List.of("16h", "22h")), new Seance("Mardi", List.of("09h", "18h")), new Seance("Mercredi", List.of("16h", "22h")), new Seance("Jeudi", List.of("09h", "18h")),new Seance("Vendredi", List.of("16h", "22h")),new Seance("Samedi", List.of("09h", "18h")),new Seance("Dimanche", List.of("16h", "22h"))));
            Screening screening31 = new Screening("31", "6", "8", List.of(new Seance("Lundi", List.of("09h", "18h")), new Seance("Mardi", List.of("16h", "22h")), new Seance("Mercredi", List.of("09h", "18h")), new Seance("Jeudi", List.of("16h", "22h")),new Seance("Vendredi", List.of("09h", "18h")),new Seance("Samedi", List.of("16h", "22h")),new Seance("Dimanche", List.of("09h", "18h"))));
            Screening screening32 = new Screening("32", "6", "9", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening33 = new Screening("33", "6", "10", List.of(new Seance("Lundi", List.of("14h", "21h")), new Seance("Mardi", List.of("18h", "20h")), new Seance("Mercredi", List.of("14h", "21h")), new Seance("Jeudi", List.of("18h", "20h")),new Seance("Vendredi", List.of("14h", "21h")),new Seance("Samedi", List.of("18h", "20h")),new Seance("Dimanche", List.of("14h", "21h"))));

            Screening screening34 = new Screening("34", "7", "1", List.of(new Seance("Lundi", List.of("15h", "18h")), new Seance("Mardi", List.of("14h", "16h")), new Seance("Mercredi", List.of("15h", "18h")), new Seance("Jeudi", List.of("14h", "16h")),new Seance("Vendredi", List.of("15h", "18h")),new Seance("Samedi", List.of("14h", "16h")),new Seance("Dimanche", List.of("15h", "18h"))));
            Screening screening35 = new Screening("35", "7", "2", List.of(new Seance("Lundi", List.of("16h", "22h")), new Seance("Mardi", List.of("09h", "18h")), new Seance("Mercredi", List.of("16h", "22h")), new Seance("Jeudi", List.of("09h", "18h")),new Seance("Vendredi", List.of("16h", "22h")),new Seance("Samedi", List.of("09h", "18h")),new Seance("Dimanche", List.of("16h", "22h"))));
            Screening screening36 = new Screening("36", "7", "3", List.of(new Seance("Lundi", List.of("09h", "18h")), new Seance("Mardi", List.of("16h", "22h")), new Seance("Mercredi", List.of("09h", "18h")), new Seance("Jeudi", List.of("16h", "22h")),new Seance("Vendredi", List.of("09h", "18h")),new Seance("Samedi", List.of("16h", "22h")),new Seance("Dimanche", List.of("09h", "18h"))));

            Screening screening38 = new Screening("38", "8", "1", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening39 = new Screening("39", "8", "3", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening40 = new Screening("40", "9", "6", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening41 = new Screening("41", "9", "7", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening42 = new Screening("42", "10", "1", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening43 = new Screening("43", "10", "8", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening44 = new Screening("44", "11", "1", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening45 = new Screening("45", "11", "5", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening46 = new Screening("46", "12", "1", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening47 = new Screening("47", "12", "4", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening48 = new Screening("48", "13", "1", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening49 = new Screening("49", "13", "9", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening50 = new Screening("50", "14", "1", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening51 = new Screening("51", "14", "6", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening52 = new Screening("52", "15", "5", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening53 = new Screening("53", "15", "9", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening54 = new Screening("54", "16", "1", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening55 = new Screening("55", "16", "10", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening56 = new Screening("56", "17", "1", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening57 = new Screening("57", "17", "3", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));

            Screening screening58 = new Screening("58", "18", "1", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));
            Screening screening59 = new Screening("59", "18", "4", List.of(new Seance("Lundi", List.of("14h", "16h")), new Seance("Mardi", List.of("15h", "18h")), new Seance("Mercredi", List.of("14h", "16h")), new Seance("Jeudi", List.of("15h", "18h")),new Seance("Vendredi", List.of("14h", "16h")),new Seance("Samedi", List.of("15h", "18h")),new Seance("Dimanche", List.of("14h", "16h"))));


            try {
                cinemaRepository.deleteAll();
                filmRepository.deleteAll();
                screeningRepository.deleteAll();
                cinemaRepository.insert(List.of(cinema1, cinema2, cinema3, cinema4, cinema5, cinema6, cinema7, cinema8, cinema9, cinema10, cinema11, cinema12, cinema13, cinema14, cinema15, cinema16, cinema17, cinema18, cinema19, cinema20));
                filmRepository.insert(List.of(film1, film2, film3, film4, film5, film6, film7, film8, film9, film10));
                screeningRepository.insert(List.of(screening1, screening2, screening3, screening4, screening5, screening6, screening7, screening8, screening9, screening10,
                        screening11, screening12, screening13, screening14, screening15, screening11, screening12, screening13, screening14, screening15, screening17, screening18, screening19,
                        screening20, screening21, screening22, screening23, screening24, screening25, screening26, screening27, screening28, screening29,
                        screening30,  screening31, screening32, screening33, screening34, screening35, screening36, screening38, screening39,
                        screening40, screening41, screening42, screening43, screening44, screening45, screening46, screening47, screening48, screening49,
                        screening50, screening51, screening52, screening53, screening54, screening55, screening56, screening57, screening58, screening59));
            }
            catch (Exception exception){
                System.out.println("ok");
            }

        };
    }

}
