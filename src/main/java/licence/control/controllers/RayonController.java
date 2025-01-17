package licence.control.controllers;

import licence.control.entities.Rayon;
import licence.control.services.RayonsService; // Assurez-vous de créer ce service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RayonController {

    @Autowired
    private RayonsService rayonService;

    @GetMapping("/rayons")
    public List<Rayon> getAllRayons(@PathVariable("idSecteur") int idSecteur) {
        return rayonService.getRayonsBySecteur(idSecteur);
    }
}
