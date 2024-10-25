package licence.control.controllers;

import licence.control.services.TravaillersServices; // Assurez-vous de créer ce service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TravaillerController {

    @Autowired
    private TravaillersServices travaillerService;

    @GetMapping("/travailleurs")
    public List<Object[]> getAllTravailleurs(@PathVariable("idRayon") int idRayon) {
        return travaillerService.getTravauxByRayon(idRayon);
    }
}
