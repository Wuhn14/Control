package licence.control.controllers;

import licence.control.entities.Employe;
import licence.control.services.EmployesService; // Assurez-vous de créer ce service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployesController {

    @Autowired
    private EmployesService employeService;

    @GetMapping("/employes")
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }
}
