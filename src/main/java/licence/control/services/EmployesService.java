package licence.control.services;

import java.util.List;
import java.util.Optional;

import licence.control.entities.Employe;
import licence.control.repositories.EmployesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployesService {

    @Autowired
    private EmployesRepository employeRepository;

    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }
    
    public Optional<Employe> getEmployeById(int id) {
        return employeRepository.findById(id);
    }

}
