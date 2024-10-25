package licence.control.services;

import licence.control.entities.Secteur;
import licence.control.repositories.SecteursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
import java.util.List;
import java.util.Optional;



@Service
public class SecteursService {

    @Autowired
    private SecteursRepository secteurRepository;

    public List<Secteur> getAllSecteurs() {
        return secteurRepository.findAll();
    }

    public Optional<Secteur> getSecteurById(int id) {
        return secteurRepository.findById(id);
    }
    
}
