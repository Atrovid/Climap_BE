package ENSICAEN.intensive_project.Climap.database.constructor;

import ENSICAEN.intensive_project.Climap.database.entities.CharacteristicEntity;
import ENSICAEN.intensive_project.Climap.database.repository.CharacteristicRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Scope("prototype")
@Validated
public class CharacteristicBuilder {
    private final CharacteristicRepository _characteristicRepository;
    private CharacteristicEntity _characteristic;
    private Double _latitude;
    private Double _longitude;

    public CharacteristicBuilder(CharacteristicRepository characteristicRepository) {
        _characteristicRepository = characteristicRepository;
        resetValues();
    }

    private void resetValues() {
        _characteristic = null;
        _latitude = null;
        _longitude = null;
    }

    public CharacteristicBuilder setLatitude(Double latitude) {
        _latitude = latitude;
        return this;
    }

    public CharacteristicBuilder setLongitude(Double longitude) {
        _longitude = longitude;
        return this;
    }

    public CharacteristicBuilder build() {
        _characteristic = new CharacteristicEntity(_latitude, _longitude);
        return this;
    }

    public CharacteristicEntity save() {
        CharacteristicEntity save = _characteristicRepository.save(_characteristic);
        resetValues();
        return save;
    }
}
