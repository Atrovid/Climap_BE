package ENSICAEN.intensive_project.Climap.database.controller;

import ENSICAEN.intensive_project.Climap.database.entities.CharacteristicEntity;
import ENSICAEN.intensive_project.Climap.database.repository.CharacteristicRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    private final CharacteristicRepository _characteristicRepository;

    public SensorController(CharacteristicRepository characteristicRepository) {
        _characteristicRepository = characteristicRepository;
    }

    @GetMapping
    public List<CharacteristicEntity> getAllSensor() {
        return _characteristicRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/position")
    public List<Object> getPosition() {
        List<Object> charac = _characteristicRepository.getSensorPosition();
        return charac;
    }

    @ResponseBody
    @GetMapping("/date")
    public List<Object> getDate() {
        List<Object> date = _characteristicRepository.getDay();
        return date;
    }
}

