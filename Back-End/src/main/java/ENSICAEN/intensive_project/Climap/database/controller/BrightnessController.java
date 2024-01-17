package ENSICAEN.intensive_project.Climap.database.controller;

import ENSICAEN.intensive_project.Climap.database.entities.BrightnessEntity;
import ENSICAEN.intensive_project.Climap.database.repository.BrightnessRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brightness")
public class BrightnessController {
    private final BrightnessRepository _brightnessRepository;

    public BrightnessController(BrightnessRepository brightnessRepository) {
        _brightnessRepository = brightnessRepository;
    }

    @GetMapping
    public List<BrightnessEntity> getAllBrightness() {
        return _brightnessRepository.findAll();
    }

    @GetMapping("/lux")
    public List<Object> getLux() {
        List<Object> lux = _brightnessRepository.getLux();
        return lux;
    }
}
