package com.example.cinemawebservice.screening;

import business.Cinema;
import business.Screening;
import business.Seance;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")

public class ScreeningController {
    private final ScreeningService screeningService;

    @RequestMapping(path = "api/screening")
    @GetMapping()
    public Screening fetchAllscreening(@RequestParam(required = true) String cinema, @RequestParam(required = true) String film){
        return screeningService.get_seances_with_with_cinema_and_film_id(cinema, film);
    }

    @RolesAllowed({"ADMIN"})
    @RequestMapping(path = "admin/screening/add")
    @PostMapping()
    public ResponseEntity<String> add_screening(@RequestBody @NotNull Map<String, Screening> map){
        System.out.println(map);
        Screening screening = screeningService.add_seance(map.get("screening").getId_cinema(), map.get("screening").getId_film(), map.get("screening").getSeances());
        return ResponseEntity.ok().body("http://localhost:8080/admin/cinemas/id="+screening.getId_cinema());
    }

    @RolesAllowed({"ADMIN"})
    @RequestMapping(path = "admin/screening/modifie")
    @PutMapping()
    public ResponseEntity<String> update_screening(@RequestBody @NotNull Map<String, Screening> map){
        Screening screening = screeningService.update_seance(map.get("screening").getId(), map.get("screening").getId_cinema(), map.get("screening").getId_film(), map.get("screening").getSeances());
        System.out.println(screening);
        return ResponseEntity.ok().body("");
    }

    @RolesAllowed({"ADMIN"})
    @RequestMapping(path = "admin/screening/delete")
    @DeleteMapping()
    public ResponseEntity<String> fetchAllCinema(@RequestBody @NotNull Map<String, String> map){
        Screening screening = screeningService.delete_seance(map.get("id"));
        System.out.println(screening);
        return ResponseEntity.ok().body("");
    }

}
