package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.MicroparticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MicroparticlesRepository extends JpaRepository<MicroparticlesEntity, Integer> {
    @Query("SELECT m._particlesPerCubicCentimeter FROM Microparticles m")
    List<Object> getParticlesPerCubicCentimeter();
}
