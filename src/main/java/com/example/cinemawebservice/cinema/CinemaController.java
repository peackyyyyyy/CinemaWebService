package com.example.cinemawebservice.cinema;

import business.Cinema;
import business.Film;
import com.example.cinemawebservice.film.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CinemaController {
    private final FilmService filmService;
    private final CinemaService cinemaService;

    @RequestMapping(path = "api/cinemas")
    @GetMapping()
    public List<Cinema> fetchAllCinema(@RequestParam(required = false) List<String> city, @RequestParam(required = false) List<String> titles){
        return cinemaService.get_cinemas_with_params(Optional.ofNullable(city), Optional.ofNullable(titles));
    }

    @RequestMapping(path = "api/films")
    @GetMapping()
    public List<Film> fetchAllFilms(@RequestParam(required = false) String language, @RequestParam(required = false) String main_actor){
        System.out.println(language);
        System.out.println(main_actor);
        List<Film> films = filmService.get_films_with_params(Optional.ofNullable(language), Optional.ofNullable(main_actor));
        System.out.println(films);
        return films;
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping(path = "admin/cinemas")
    public ModelAndView fetchadminCinemastemplate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/cinemas");
        return modelAndView;
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping(path = "admin/cinemas")
    public ResponseEntity<String> deletecinema(@RequestBody Map<String, String> map){
        try {
            cinemaService.delete_cinema(map.get("id"));
        }
        catch (Exception e){
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok().body("http://localhost:8080/admin/cinemas");
    }

    @RolesAllowed({"ADMIN"})
    @PutMapping(path = "admin/cinemas")
    public ResponseEntity<String> updatecinema(@RequestBody Map<String, Cinema> map, BindingResult errors){
        if (errors.hasErrors()) {
            System.out.println(errors);
        }
        Cinema cinema = null;
        System.out.println(map);
        try {
            cinema = cinemaService.update_cinema(map.get("cinema").getId(), map.get("cinema").getName(), map.get("cinema").getAddress(), map.get("cinema").getFilm());
        }
        catch (Exception e){
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok().body("http://localhost:8080/admin/cinemas/id="+cinema.getId());
    }

    @RolesAllowed({"ADMIN"})
    @PutMapping(path = "admin/cinemas/add_film")
    public ResponseEntity<String> add_film_in_cinema(@RequestBody Map<String, String> map, BindingResult errors){
        if (errors.hasErrors()) {
            System.out.println(errors);
        }
        Cinema cinema = null;
        try {
            cinema = cinemaService.add_film_to_cinema(map.get("id_cinema"), map.get("film_title"));
            System.out.println(cinema);
        }
        catch (Exception e){
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok().body("http://localhost:8080/admin/cinemas/id="+cinema.getId());
    }


    @RolesAllowed({"ADMIN"})
    @PostMapping(path = "admin/cinemas")
    public ResponseEntity<String> addcinema(@RequestBody Map<String, Cinema> map, BindingResult errors){
        if (errors.hasErrors()) {
            System.out.println(errors);
        }
        Cinema cinema = cinemaService.add_new_cinema(map.get("cinema").getName(), map.get("cinema").getAddress(), map.get("cinema").getFilm());
        return ResponseEntity.ok().body("http://localhost:8080/admin/cinemas/id="+cinema.getId());
    }


    @RequestMapping(path = "cinemas")
    @GetMapping()
    public ModelAndView fetchcinemastemplate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/cinemas");
        return modelAndView;
    }

    @RequestMapping(path = "apropos")
    @GetMapping()
    public ModelAndView fetchapropostemplate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/apropos");
        return modelAndView;
    }

    @RequestMapping(path = "admin/cinemas/id={id}")
    @ModelAttribute
    @GetMapping()
    public ModelAndView fetchadminCinemastemplate(@PathVariable(value="id") String id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/cinema");
        model.addAttribute("id", id);
        return modelAndView;
    }

    @RequestMapping(path = "cinemas/id={id}")
    @ModelAttribute
    @GetMapping()
    public ModelAndView fetchCinematemplate(@PathVariable(value="id") String id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/cinema");
        model.addAttribute("id", id);
        return modelAndView;
    }


    @RequestMapping(path = "api/cinemas/id={id}")
    @GetMapping()
    public Optional<Cinema> fetchCinemabyId(@PathVariable(value="id") String id){
        return cinemaService.get_cinema_by_id(id);
    }

    @RequestMapping(path = "api/films/titles")
    @GetMapping()
    public ResponseEntity<List<String>> fetchAllFilmsTitles(){
        return ResponseEntity.ok().body(filmService.get_all_film_titles());
    }

    @RequestMapping(path = "api/films/language")
    @GetMapping()
    public ResponseEntity<List<String>> fetchAllFilmsLanguage(){
        return ResponseEntity.ok().body(filmService.get_all_film_language());
    }

    @RequestMapping(path = "api/films/main_actor")
    @GetMapping()
    public ResponseEntity<List<String>> fetchAllFilmsMain_actor(){
        return ResponseEntity.ok().body(filmService.get_all_film_main_actor());
    }

    @RequestMapping(path = "api/city")
    @GetMapping()
    public ResponseEntity<List<String>>  fetchAllCity(){
        return ResponseEntity.ok().body(cinemaService.get_all_city());
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping(path = "admin/films")
    public ModelAndView fetchadminFilmstemplate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/films");
        return modelAndView;
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping(path = "admin/apropos")
    public ModelAndView fetchadminapropostemplate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/apropos");
        return modelAndView;
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping(path = "admin/films")
    public ResponseEntity<String>  deletefilm(@RequestBody Map<String, String> map){
        try {
            filmService.delete_film(map.get("id"));
        }
        catch (Exception e){
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok().body("http://localhost:8080/admin/films");
    }

    @RolesAllowed({"ADMIN"})
    @PutMapping(path = "admin/films")
    public ResponseEntity<String> updatefilm(@RequestBody Map<String, Film> map, BindingResult errors){
        if (errors.hasErrors()) {
            System.out.println(errors);
        }
        Film film = null;
        try {
            filmService.delete_film(map.get("film").getId());
            film = filmService.update_film(map.get("film").getId(), map.get("film").getTitle(), map.get("film").getDuration(), map.get("film").getLanguage(),
                    map.get("film").getSubtitles(), map.get("film").getDirector(), map.get("film").getMain_actor(), map.get("film").getMin_age(),
                    map.get("film").getStart(), map.get("film").getEnd());
        }
        catch (Exception e){
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok().body("http://localhost:8080/admin/films/id="+film.getId());
    }

    @RolesAllowed({"ADMIN"})
    @PostMapping(path = "admin/films")
    public ResponseEntity<String> addfilm(@RequestBody Map<String, Film> map, BindingResult errors){
        if (errors.hasErrors()) {
            System.out.println(errors);
        }
        Film film = filmService.add_new_film(map.get("film").getTitle(), map.get("film").getDuration(), map.get("film").getLanguage(),
                map.get("film").getSubtitles(), map.get("film").getDirector(), map.get("film").getMain_actor(), map.get("film").getMin_age(),
                map.get("film").getStart(), map.get("film").getEnd());
        return ResponseEntity.ok().body("http://localhost:8080/admin/films/id="+film.getId());
    }

    @GetMapping()
    public ModelAndView fetchindextemplate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/index");
        return modelAndView;
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping(path = "admin")
    public ModelAndView fetchadminindextemplate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    @RequestMapping(path = "films")
    @GetMapping()
    public ModelAndView fetchFilmstemplate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/films");
        return modelAndView;
    }

    @RequestMapping(path = "admin/films/id={id}")
    @ModelAttribute
    @GetMapping()
    public ModelAndView fetchadminFilmtemplate(@PathVariable(value="id") String id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/film");
        model.addAttribute("id", id);
        return modelAndView;
    }

    @RequestMapping(path = "films/id={id}")
    @ModelAttribute
    @GetMapping()
    public ModelAndView fetchFilmtemplate(@PathVariable(value="id") String id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/film");
        model.addAttribute("id", id);
        return modelAndView;
    }


    @RequestMapping(path = "api/films/id={id}")
    @GetMapping()
    public Optional<Film> fetchFilmbyId(@PathVariable(value="id") String id){
        return filmService.get_film_by_id(id);
    }
}

