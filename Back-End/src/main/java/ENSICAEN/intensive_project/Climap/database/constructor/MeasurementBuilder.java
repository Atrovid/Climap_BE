package ENSICAEN.intensive_project.Climap.database.constructor;

import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.repository.MeasurementRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static ENSICAEN.intensive_project.Climap.AssignValues.assignIfNotNull;

@Service
@Scope("prototype")
@Validated
public class MeasurementBuilder {
    private final MeasurementRepository _characteristicRepository;
    private MeasurementEntity _measurement;
    private Double _latitude;
    private Double _longitude;
    private String _serialNumber;
    private Integer _id;

    public MeasurementBuilder(MeasurementRepository characteristicRepository) {
        _characteristicRepository = characteristicRepository;
        resetValues();
    }

    private void resetValues() {
        _measurement = null;
        _latitude = null;
        _longitude = null;
        _serialNumber = null;
        _id = null;
    }

    public MeasurementBuilder setFromMeasurement(MeasurementEntity measurement) {
        assignIfNotNull(measurement.getIdMeasurement(), value -> _id = (Integer) value);
        _latitude = measurement.getLatitude();
        _longitude = measurement.getLongitude();
        _serialNumber = measurement.getSerialNumber();
        return this;
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
        _measurement = new MeasurementEntity(_latitude, _longitude, _serialNumber);
        return this;
    }

    public MeasurementEntity save() {
        MeasurementEntity save = _characteristicRepository.save(_measurement);
        resetValues();
        return save;
    }
}
