package licence.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import licence.control.entities.Rayon;

import java.util.List;

@Repository
public interface RayonsRepository extends JpaRepository<Rayon, Integer> {
    @Query("SELECT r FROM Rayon r WHERE r.numSecteur = :numSecteur")
    List<Rayon> findBySecteur(@Param("numSecteur") int numSecteur);

}
