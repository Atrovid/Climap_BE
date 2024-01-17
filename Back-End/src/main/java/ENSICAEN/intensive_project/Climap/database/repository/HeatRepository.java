package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.HeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeatRepository extends JpaRepository<HeatEntity, Integer> {

    @Query("SELECT h._celsiusDegree FROM Heat h")
    List<Object> getCelsiusDegree();
}
