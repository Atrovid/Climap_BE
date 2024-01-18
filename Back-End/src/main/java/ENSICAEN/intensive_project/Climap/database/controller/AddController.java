package ENSICAEN.intensive_project.Climap.database.controller;

import ENSICAEN.intensive_project.Climap.database.constructor.*;
import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.json.DeviceResponseJson;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/add")
public class AddController {
    private final MeasurementBuilder _measurementBuilder;
    private final BrightnessBuilder _brightnessBuilder;
    private final HeatBuilder _heatBuilder;
    private final HumidityBuilder _humidityBuilder;
    private final MicroparticlesBuilder _microparticlesBuilder;
    private final SoundBuilder _soundBuilder;

    public AddController(
            MeasurementBuilder measurementBuilder,
            BrightnessBuilder brightnessBuilder,
            HeatBuilder heatBuilder,
            HumidityBuilder humidityBuilder,
            MicroparticlesBuilder microparticlesBuilder,
            SoundBuilder soundBuilder
    ) {
        _measurementBuilder = measurementBuilder;
        _brightnessBuilder = brightnessBuilder;
        _heatBuilder = heatBuilder;
        _humidityBuilder = humidityBuilder;
        _microparticlesBuilder = microparticlesBuilder;
        _soundBuilder = soundBuilder;
    }

    private static String generateSerialNumber() {
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            char randomLetter = (char) ('A' + random.nextInt(26));
            randomString.append(randomLetter);
        }

        for (int i = 0; i < 7; i++) {
            int randomNumber = random.nextInt(10);
            randomString.append(randomNumber);
        }

        return randomString.toString();
    }

    @PostMapping
    public void receiveFileFromDevice(@RequestBody String file) throws IOException {

        String existingJsonFilePath = "src/main/java/ENSICAEN/intensive_project/Climap/database/resource/Device.json";
        ClassPathResource deviceResource = new ClassPathResource("Device.json");

        ObjectMapper mapper = new ObjectMapper();

        JsonNode node1 = mapper.readTree(file);

        System.out.println("node1");
        System.out.println(node1);

        DeviceResponseJson[] deviceResponseJsonList = mapper.treeToValue(node1, DeviceResponseJson[].class);

        for (DeviceResponseJson deviceResponse : deviceResponseJsonList) {
            MeasurementEntity measurement = _measurementBuilder
                    .setSerialNumber(generateSerialNumber())
                    .setLatitude(deviceResponse.getLatitude())
                    .setLongitude(deviceResponse.getLongitude())
                    .build()
                    .save();

            _brightnessBuilder
                    .setCharacteristic(measurement)
                    .setLux(deviceResponse.getLux())
                    .build()
                    .save();
            _heatBuilder
                    .setCharacteristic(measurement)
                    .setCelsiusDegree(deviceResponse.getCelsiusDegree())
                    .build().save();
            _humidityBuilder
                    .setCharacteristic(measurement)
                    .setRelativeHumidityPercentage(deviceResponse.get_relativeHumidityPercentage())
                    .build().save();
            _microparticlesBuilder
                    .setCharacteristic(measurement)
                    .setParticlesPerCubicCentimeter(deviceResponse.get_particlesPerCubicCentimeter())
                    .build().save();
            _soundBuilder
                    .setCharacteristic(measurement)
                    .setDecibel(deviceResponse.get_decibel())
                    .build().save();


            System.out.println("Pass 1");
        }


    }
}
