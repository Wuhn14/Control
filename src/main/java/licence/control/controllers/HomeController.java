package licence.control.controllers;

import licence.control.entities.Secteur;
import licence.control.services.SecteursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private SecteursService SecteursService;
    
    @GetMapping("/home")
    public String home(Model model)
    {
        List<Secteur> lesSecteurs = SecteursService.getAllSecteurs();
        model.addAttribute("secteurs", lesSecteurs);
        return "index";
    }

}