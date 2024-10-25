package licence.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import licence.control.entities.Travailler;
import java.util.List;

@Repository
public interface TravailleursRepository extends JpaRepository<Travailler, Integer> {

    @Query(value = "SELECT e.prenomE , t.temps, t.date FROM Travailler t " +
            "inner join Employe e on t.codeE = e.numE WHERE t.codeR = :codeR", nativeQuery = true)
    List<Object[]> findTravauxByRayon(@Param("codeR") int codeR);

    @Override
    <S extends Travailler> S saveAndFlush(S entity);
}
