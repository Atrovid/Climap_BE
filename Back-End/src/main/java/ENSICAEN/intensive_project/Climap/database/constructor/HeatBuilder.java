package ENSICAEN.intensive_project.Climap.database.constructor;

import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.entities.HeatEntity;
import ENSICAEN.intensive_project.Climap.database.repository.HeatRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Scope("prototype")
@Validated
public class HeatBuilder {
    private final HeatRepository _heatRepository;
    private HeatEntity _heat;
    private MeasurementEntity _characteristic;
    private Double _celsiusDegree = 0.0;


    public HeatBuilder(HeatRepository heatRepository) {
        _heatRepository = heatRepository;
        resetValues();
    }

    private void resetValues() {
        _heat = null;
        _celsiusDegree = null;
        _characteristic = null;
    }

    public HeatBuilder setCelsiusDegree(Double celsiusDegree) {
        _celsiusDegree = celsiusDegree;
        return this;
    }

    public HeatBuilder setCharacteristic(MeasurementEntity characteristic) {
        _characteristic = characteristic;
        return this;
    }

    public HeatBuilder build() {
        _heat = new HeatEntity(_celsiusDegree, _characteristic);
        return this;
    }

    public void save() {
        _heatRepository.save(_heat);
        resetValues();
    }
}
