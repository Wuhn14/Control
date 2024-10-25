package licence.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import licence.control.entities.Secteur;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SecteursRepository extends JpaRepository<Secteur, Integer> {
    // Tu peux ajouter des méthodes de requêtes spécifiques ici, si nécessaire
    
    @Override
    List<Secteur> findAll();
    
    @Override
    Optional<Secteur> findById(Integer integer);
}
