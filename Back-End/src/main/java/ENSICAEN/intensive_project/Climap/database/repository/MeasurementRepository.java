package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Integer> {
    @Query("SELECT c._latitude, c._longitude FROM Measurement c")
    List<Object> getSensorPosition();

    @Query(
            "SELECT year(c._dateDataCapture) AS year, " +
            "month(c._dateDataCapture) AS Month, " +
            "day(c._dateDataCapture) AS Day " +
            "FROM Measurement c"
    )
    List<Object> getDay();

}


