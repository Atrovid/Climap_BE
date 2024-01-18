package ENSICAEN.intensive_project.Climap.database.constructor;

import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.entities.MicroparticlesEntity;
import ENSICAEN.intensive_project.Climap.database.repository.MicroparticlesRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Scope("prototype")
@Validated
public class MicroparticlesBuilder {
    private final MicroparticlesRepository _microparticlesRepository;
    private MicroparticlesEntity _microparticles;
    private MeasurementEntity _characteristic;
    private Double _particlesPerCubicCentimeter;

    public MicroparticlesBuilder(MicroparticlesRepository microparticlesRepository) {
        _microparticlesRepository = microparticlesRepository;
        resetValues();
    }

    private void resetValues() {
        _microparticles = null;
        _characteristic = null;
        _particlesPerCubicCentimeter = null;
    }

    public MicroparticlesBuilder setParticlesPerCubicCentimeter(Double particlesPerCubicCentimeter) {
        _particlesPerCubicCentimeter = particlesPerCubicCentimeter;
        return this;
    }

    public MicroparticlesBuilder setCharacteristic(MeasurementEntity characteristic) {
        _characteristic = characteristic;
        return this;
    }

    public MicroparticlesBuilder build() {
        _microparticles = new MicroparticlesEntity(_particlesPerCubicCentimeter, _characteristic);
        return this;
    }

    public void save() {
        _microparticlesRepository.save(_microparticles);
        resetValues();
    }
}
