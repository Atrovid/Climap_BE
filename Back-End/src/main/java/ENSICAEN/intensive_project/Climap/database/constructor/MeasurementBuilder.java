package ENSICAEN.intensive_project.Climap.database.constructor;

import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.repository.MeasurementRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Scope("prototype")
@Validated
public class MeasurementBuilder {
    private final MeasurementRepository _characteristicRepository;
    private MeasurementEntity _characteristic;
    private Double _latitude;
    private Double _longitude;
    private String _serialNumber;

    public MeasurementBuilder(MeasurementRepository characteristicRepository) {
        _characteristicRepository = characteristicRepository;
        resetValues();
    }

    private void resetValues() {
        _characteristic = null;
        _latitude = null;
        _longitude = null;
        _serialNumber = null;
    }

    public MeasurementBuilder setLatitude(Double latitude) {
        _latitude = latitude;
        return this;
    }

    public MeasurementBuilder setLongitude(Double longitude) {
        _longitude = longitude;
        return this;
    }

    public MeasurementBuilder setSerialNumber(String serialNumber) {
        _serialNumber = serialNumber;
        return this;
    }

    public MeasurementBuilder build() {
        _characteristic = new MeasurementEntity(_latitude, _longitude, _serialNumber);
        return this;
    }

    public MeasurementEntity save() {
        MeasurementEntity save = _characteristicRepository.save(_characteristic);
        resetValues();
        return save;
    }
}
