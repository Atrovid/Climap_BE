package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.SoundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoundRepository extends JpaRepository<SoundEntity, Integer> {
}
