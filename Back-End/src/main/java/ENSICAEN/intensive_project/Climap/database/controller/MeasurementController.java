package ENSICAEN.intensive_project.Climap.database.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.repository.MeasurementRepository;

@RestController
@RequestMapping("/sensor")
public class MeasurementController {

    private final MeasurementRepository _characteristicRepository;

    public MeasurementController(MeasurementRepository characteristicRepository) {
        _characteristicRepository = characteristicRepository;
    }

    @GetMapping
    public List<MeasurementEntity> getAllSensor(
            @RequestParam(required = false) Double minLat,
            @RequestParam(required = false) Double maxLat,
            @RequestParam(required = false) Double minLng,
            @RequestParam(required = false) Double maxLng) {

        if (minLat != null && maxLat != null && minLng != null && maxLng != null) {
            return _characteristicRepository.findAllInRect(minLat, maxLat, minLng, maxLng);
        }

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

