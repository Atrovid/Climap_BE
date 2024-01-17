package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.BrightnessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrightnessRepository extends JpaRepository<BrightnessEntity, Integer> {
    @Query("SELECT b._lux FROM Brightness b")
    List<Object> getLux();
}
