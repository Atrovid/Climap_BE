package ENSICAEN.intensive_project.Climap.database.controller;

import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.repository.MeasurementRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensor")
public class MeasurementController {

    private final MeasurementRepository _characteristicRepository;

    public MeasurementController(MeasurementRepository characteristicRepository) {
        _characteristicRepository = characteristicRepository;
    }

    @GetMapping
    public List<MeasurementEntity> getAllSensor() {
        return _characteristicRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/position")
    public List<Object> getPosition() {
        return _characteristicRepository.getSensorPosition();
    }

    @ResponseBody
    @GetMapping("/date")
    public List<Object> getDate() {
        return _characteristicRepository.getDay();
    }
}

