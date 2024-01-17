package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.HeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeatRepository extends JpaRepository<HeatEntity, Integer> {
}
