package ENSICAEN.intensive_project.Climap.database.constructor;

import ENSICAEN.intensive_project.Climap.database.entities.BrightnessEntity;
import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.repository.BrightnessRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Scope("prototype")
@Validated
public class BrightnessBuilder {
    private final BrightnessRepository _brightnessRepository;
    private BrightnessEntity _brightness;
    private MeasurementEntity _characteristic;
    private Double _lux = 0.0;

    public BrightnessBuilder(BrightnessRepository brightnessRepository) {
        _brightnessRepository = brightnessRepository;
        resetValues();
    }

    private void resetValues() {
        _brightness = null;
        _lux = null;
        _characteristic = null;
    }

    public BrightnessBuilder setLux(double lux) {
        _lux = lux;
        return this;
    }

    public BrightnessBuilder setCharacteristic(MeasurementEntity characteristic) {
        _characteristic = characteristic;
        return this;
    }

    public BrightnessBuilder build() {
        _brightness = new BrightnessEntity(_lux, _characteristic);
        return this;
    }

    public void save() {
        _brightnessRepository.save(_brightness);
        resetValues();
    }


}