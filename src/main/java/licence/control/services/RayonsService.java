package licence.control.services;

import licence.control.entities.Rayon;
import licence.control.repositories.RayonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RayonsService {

    @Autowired
    private RayonsRepository rayonRepository;

    public List<Rayon> getRayonsBySecteur(int secteurId) {
        return rayonRepository.findBySecteur(secteurId);
    }

    public Optional<Rayon> getRayonById(int id) {
        return rayonRepository.findById(id);
    }

}
