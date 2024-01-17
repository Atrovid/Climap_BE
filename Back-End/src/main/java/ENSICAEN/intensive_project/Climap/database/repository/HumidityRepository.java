package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.HumidityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HumidityRepository extends JpaRepository<HumidityEntity, Integer> {
    @Query("SELECT h._relativeHumidityPercentage FROM Humidity h")
    List<Object> getRelativeHumidityPercentage();
}
