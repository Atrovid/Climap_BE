package ENSICAEN.intensive_project.Climap.database.controller;

import ENSICAEN.intensive_project.Climap.database.entities.SoundEntity;
import ENSICAEN.intensive_project.Climap.database.repository.SoundRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sound")
public class SoundController {
    private final SoundRepository _soundRepository;

    public SoundController(SoundRepository soundRepository) {
        _soundRepository = soundRepository;
    }

    @GetMapping
    public List<SoundEntity> getAllSoundSensor() {
        return _soundRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/decibel")
    public List<Object> getDecibel() {
        return _soundRepository.getDecibel();
    }
}
