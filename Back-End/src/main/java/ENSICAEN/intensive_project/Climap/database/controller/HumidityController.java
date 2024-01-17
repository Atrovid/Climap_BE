package ENSICAEN.intensive_project.Climap.database.controller;

import ENSICAEN.intensive_project.Climap.database.entities.HumidityEntity;
import ENSICAEN.intensive_project.Climap.database.repository.HumidityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/humidity")
public class HumidityController {
    private final HumidityRepository _humidityRepository;

    public HumidityController(HumidityRepository humidityRepository) {
        _humidityRepository = humidityRepository;
    }

    @GetMapping
    public List<HumidityEntity> getAllHumidity() {
        return _humidityRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/relativeHumidityPercentage")
    public List<Object> getRelativeHumidityPercentage() {
        List<Object> relativeHumidityPercentage = _humidityRepository.getRelativeHumidityPercentage();
        return relativeHumidityPercentage;
    }
}
