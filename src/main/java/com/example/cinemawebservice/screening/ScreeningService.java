package com.example.cinemawebservice.screening;

import business.Screening;
import business.Seance;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

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
        Integer randomNum = 1 + (int)(Math.random() * 1000000);
        return seanceRepository.insert(new Screening(randomNum.toString(), id_cinema, id_film, seances));
    }

    @GetMapping
    public Screening update_seance(String id, String id_cinema, String id_film, List<Seance> seances){
        List<Seance> post_seances = seanceRepository.findById(id).get().getSeances();
        for (Seance temp1: post_seances){
            if (Objects.equals(temp1.getDay(), seances.get(0).getDay())){
                if (temp1.getHour().contains(seances.get(0).getHour().get(0))){
                    return null;
                }
                else {
                    temp1.getHour().add(seances.get(0).getHour().get(0));
                    return seanceRepository.save(new Screening(id, id_cinema, id_film, post_seances));
                }
            }
            else {
                post_seances.addAll(seances);
                return seanceRepository.save(new Screening(id, id_cinema, id_film, post_seances));
            }
        }
        return null;
    }

    @GetMapping
    public Screening delete_seance(String seances){
        Screening screening = seanceRepository.findById(seances).get();
        return seanceRepository.save(new Screening(screening.getId(), screening.getId_cinema(), screening.getId_film(), null));
    }

    @GetMapping
    public void delete_screening(String screening){
        seanceRepository.deleteById(screening);
    }
}
