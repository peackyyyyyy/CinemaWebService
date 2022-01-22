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

public class ImageController {
    @GetMapping(
            value = "/get-image-with-media-type",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
        return IOUtils.toByteArray(in);
    }
}

