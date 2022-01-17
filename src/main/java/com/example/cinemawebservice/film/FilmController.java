package com.example.cinemawebservice.film;

import business.Film;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class FilmController {
    private final FilmService filmService;

    @RequestMapping(path = "api/films")
    @GetMapping()
    public List<Film> fetchAllFilms(@RequestParam(required = false) List<String> title){
        return filmService.get_films_with_params(Optional.ofNullable(title));
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping(path = "admin/films")
    public ModelAndView fetchadminFilmstemplate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/films");
        return modelAndView;
    }

    @RolesAllowed({"ADMIN"})
    @PostMapping(path = "admin/films")
    public ModelAndView addfilm(@ModelAttribute Map<String, Film> map, BindingResult errors){
        if (errors.hasErrors()) {
            System.out.println(errors);
        }
        System.out.println(map);
        Film film = filmService.add_new_film(map.get("title").getTitle(), map.get("duration").getRuntime(), map.get("language").getLanguage(),
                map.get("subtitles").getSubtitles(), map.get("director").getDirector(), map.get("main_actor").getMain_actor(), map.get("min_age").getMin_age(),
                map.get("start").getStart(), map.get("end").getEnd());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/films/id="+film.getId());
        return modelAndView;
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
