package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.SoundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SoundRepository extends JpaRepository<SoundEntity, Integer> {
    @Query("SELECT s._decibel FROM Sound s")
    List<Object> getDecibel();
}
