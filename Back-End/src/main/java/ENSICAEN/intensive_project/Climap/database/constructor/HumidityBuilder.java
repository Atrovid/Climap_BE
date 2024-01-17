package ENSICAEN.intensive_project.Climap.database.constructor;

import ENSICAEN.intensive_project.Climap.database.entities.CharacteristicEntity;
import ENSICAEN.intensive_project.Climap.database.entities.HumidityEntity;
import ENSICAEN.intensive_project.Climap.database.repository.HumidityRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Scope("prototype")
@Validated
public class HumidityBuilder {
    private final HumidityRepository _humidityRepository;
    private HumidityEntity _humidity;
    private CharacteristicEntity _characteristic;
    private Double _relativeHumidityPercentage;

    public HumidityBuilder(HumidityRepository humidityRepository) {
        _humidityRepository = humidityRepository;
        resetValues();
    }

    private void resetValues() {
        _humidity = null;
        _characteristic = null;
        _relativeHumidityPercentage = null;
    }

    public HumidityBuilder setRelativeHumidityPercentage(Double relativeHumidityPercentage) {
        _relativeHumidityPercentage = relativeHumidityPercentage;
        return this;
    }

    public HumidityBuilder setCharacteristic(CharacteristicEntity characteristic) {
        _characteristic = characteristic;
        return this;
    }

    public HumidityBuilder build() {
        _humidity = new HumidityEntity(_relativeHumidityPercentage, _characteristic);
        return this;
    }

    public HumidityEntity save() {
        HumidityEntity save = _humidityRepository.save(_humidity);
        resetValues();
        return save;
    }
}
