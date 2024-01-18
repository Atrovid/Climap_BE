package ENSICAEN.intensive_project.Climap.database.constructor;

import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.entities.SoundEntity;
import ENSICAEN.intensive_project.Climap.database.repository.SoundRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Scope("prototype")
@Validated
public class SoundBuilder {
    private final SoundRepository _soundRepository;
    private SoundEntity _sound;
    private MeasurementEntity _characteristic;
    private Double _decibel;

    public SoundBuilder(SoundRepository soundRepository) {
        _soundRepository = soundRepository;
        resetValues();
    }

    private void resetValues() {
        _sound = null;
        _decibel = null;
        _characteristic = null;
    }

    public SoundBuilder setDecibel(Double decibel) {
        _decibel = decibel;
        return this;
    }

    public SoundBuilder setCharacteristic(MeasurementEntity characteristic) {
        _characteristic = characteristic;
        return this;
    }

    public SoundBuilder build() {
        _sound = new SoundEntity(_decibel, _characteristic);
        return this;
    }

    public void save() {
        _soundRepository.save(_sound);
        resetValues();
    }
}

