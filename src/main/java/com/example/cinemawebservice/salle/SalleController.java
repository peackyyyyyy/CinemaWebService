package com.example.cinemawebservice.salle;

import business.Salle;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = "salles")
@RestController
public class SalleController {

    @Autowired
    private final SalleService salleService;

}
