package licence.control.repositories;

import licence.control.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployesRepository extends JpaRepository<Employe, Integer>  {

    @Override
    List<Employe> findAll();

    @Override
    Optional<Employe> findById(Integer integer);
}
