package ENSICAEN.intensive_project.Climap.database.controller;

import ENSICAEN.intensive_project.Climap.database.entities.HeatEntity;
import ENSICAEN.intensive_project.Climap.database.repository.HeatRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/heat")
public class HeatController {
    private final HeatRepository _heatRepository;

    public HeatController(HeatRepository heatRepository) {
        _heatRepository = heatRepository;
    }

    @GetMapping
    public List<HeatEntity> getAllHeat() {
        return _heatRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/celcius")
    public List<Object> getCelsius() {
        return _heatRepository.getCelsiusDegree();
    }
}
