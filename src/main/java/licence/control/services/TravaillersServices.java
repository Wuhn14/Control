package licence.control.services;

import java.util.List;

import licence.control.entities.Travailler;
import licence.control.repositories.TravailleursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravaillersServices {

    @Autowired
    private TravailleursRepository TravailleursRepository;

    public List<Object[]> getTravauxByRayon(int rayonId) {
        return TravailleursRepository.findTravauxByRayon(rayonId);
    }


    public void save(Travailler travailler)
    {
        TravailleursRepository.saveAndFlush(travailler);
    }

}
