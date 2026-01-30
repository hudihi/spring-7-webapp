package guru.springframework.spring7webapp.controllers;


import guru.springframework.spring7webapp.services.AuthorServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorServices authorServices;


    public AuthorController(AuthorServices authorServices) {
        this.authorServices = authorServices;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorServices.findAll());

        return "authors";
    }

}
