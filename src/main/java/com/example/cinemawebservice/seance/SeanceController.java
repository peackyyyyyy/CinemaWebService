package com.example.cinemawebservice.seance;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = "seances")
public class SeanceController {

    private final SeanceService seanceService;
}
