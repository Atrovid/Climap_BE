package ENSICAEN.intensive_project.Climap.database.repository;

import ENSICAEN.intensive_project.Climap.database.entities.MicroparticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicroparticlesRepository extends JpaRepository<MicroparticlesEntity, Integer> {
}
