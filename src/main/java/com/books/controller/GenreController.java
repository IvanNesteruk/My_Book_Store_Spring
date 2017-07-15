package com.books.controller;

import com.books.entity.Book;
import com.books.validator.genreValidator.GenreValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.books.entity.Genre;
import com.books.service.GenreService;

@Controller
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/listOfGenres")
    public String listOfGenres(Model model) {
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("genre", new Genre());
        return "views-genres-listOfGenres";
    }

    @PostMapping("/saveGenre")
    public String listOfGenres(@ModelAttribute Genre genre, Model model) {
        try {
            genreService.save(genre);
        } catch (Exception e) {
            if (e.getMessage().equals(GenreValidationMessages.EMPTY_GENRENAME_FIELD)
                    || e.getMessage().equals(GenreValidationMessages.GENRENAME_ALREADY_EXISTS)) {
                model.addAttribute("GenreNameException", e.getMessage());
            }
            model.addAttribute("genres", genreService.findAll());
            return "views-genres-listOfGenres";
        }
        return "redirect:/listOfGenres";
    }

    @GetMapping("/deleteGenre/{id}")
    public String deleteGenre(@PathVariable int id) {

        genreService.delete(id);

        return "redirect:/listOfGenres";
    }

    @RequestMapping(value = "/updateGenre/{id}", method = RequestMethod.GET)
    public String getGenre(@PathVariable int id, Model model) {
        model.addAttribute("genreAttribute", genreService.findOne(id));
        return "views-genres-updateGenre";
    }

    @RequestMapping(value = "/updateGenre/{id}", method = RequestMethod.POST)
    public String updateGenre(@ModelAttribute("genre") Genre genre, @PathVariable int id, Model model) {
        genre.setId(id);
        genreService.update(genre);
        model.addAttribute("genres", genreService.findAll());
        return "views-genres-listOfGenres";
    }

}
