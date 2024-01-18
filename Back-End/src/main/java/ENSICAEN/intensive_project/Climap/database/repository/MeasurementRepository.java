package ENSICAEN.intensive_project.Climap.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;

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

    @Query("SELECT c FROM Measurement c " +
            "WHERE c._latitude >= ?1 AND c._latitude <= ?2 " +
            "AND c._longitude >= ?3 AND c._longitude <= ?4")
    List<MeasurementEntity> findAllInRect(Double minLat, Double maxLat, Double minLng, Double maxLng);

}


