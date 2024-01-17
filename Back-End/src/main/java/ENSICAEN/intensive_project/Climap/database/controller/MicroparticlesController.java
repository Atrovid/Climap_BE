package ENSICAEN.intensive_project.Climap.database.controller;

import ENSICAEN.intensive_project.Climap.database.entities.MicroparticlesEntity;
import ENSICAEN.intensive_project.Climap.database.repository.MicroparticlesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/microparticles")
public class MicroparticlesController {
    private final MicroparticlesRepository _microparticleRepository;

    public MicroparticlesController(MicroparticlesRepository microparticleRepository) {
        _microparticleRepository = microparticleRepository;
    }

    @GetMapping
    public List<MicroparticlesEntity> getAllMicroparticle() {
        return _microparticleRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/particlesPerCubicCentimeter")
    public List<Object> getParticlesPerCubicCentimeter() {
        List<Object> particlesPerCubicCentimeter= _microparticleRepository.getParticlesPerCubicCentimeter();
        return particlesPerCubicCentimeter;
    }
}
