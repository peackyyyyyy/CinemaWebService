package com.example.cinemawebservice.seance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SeanceService {

    private final SeanceRepository seanceRepository;
}
