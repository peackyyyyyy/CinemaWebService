package com.example.cinemawebservice.screening;

import business.Screening;
import business.Seance;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@AllArgsConstructor
@Service

public class ScreeningService {
    private final ScreeningRepository seanceRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping
    public Screening get_seances_with_with_cinema_and_film_id(String id_cinema, String id_film){
        return seanceRepository.findScreeningById_cinemaAndId_film(id_cinema, id_film);
    }

    @GetMapping
    public Screening add_seance(String id_cinema, String id_film, List<Seance> seances){
        return seanceRepository.insert(new Screening(null, id_cinema, id_film, seances));
    }

    @GetMapping
    public Screening update_seance(String id, String id_cinema, String id_film, List<Seance> seances){
        List<Seance> post_seances = seanceRepository.findById(id).get().getSeances();
        System.out.println(post_seances);
        if (!post_seances.contains(seances.get(0))){
            post_seances.addAll(seances);
        }
        return seanceRepository.save(new Screening(id, id_cinema, id_film, post_seances));
    }

    @GetMapping
    public Screening delete_seance(String seances){
        seanceRepository.deleteById(seances);
        return null;
    }
}
