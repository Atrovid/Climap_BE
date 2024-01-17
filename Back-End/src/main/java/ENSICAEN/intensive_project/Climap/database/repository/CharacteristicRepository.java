package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.CharacteristicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacteristicRepository extends JpaRepository<CharacteristicEntity, Integer> {
    @Query(
            "SELECT c._latitude, c._longitude FROM Characteristic c"
    )
    List<Object> findSensorPosition();

}


