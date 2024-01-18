package ENSICAEN.intensive_project.Climap.database.initialisation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import ENSICAEN.intensive_project.Climap.database.constructor.*;
import ENSICAEN.intensive_project.Climap.database.entities.MeasurementEntity;
import ENSICAEN.intensive_project.Climap.database.json.DeviceResponseJson;
import ENSICAEN.intensive_project.Climap.database.json.JsonParser;
import ENSICAEN.intensive_project.Climap.database.repository.*;

@Configuration
public class DataInitialisation {
    private final JsonParser _jsonParser;
    private final static double LOWER_BOUND_LONGITUDE = -0.265388;
    private final static double UPPER_BOUND_LONGITUDE = -0.43499;
    private final static double LOWER_BOUND_LATITUDE = 49.128039;
    private final static double UPPER_BOUND_LATITUDE = 49.238;
    private final static double LOWER_BOUND_TEMPERATURE = 10.0;
    private final static double UPPER_BOUND_TEMPERATURE = 18.0;
    private final static double LOWER_BOUND = 0.0;
    private final static double UPPER_BOUND = 100.0;
    private final MeasurementRepository _characteristicRepository;
    private final BrightnessRepository _brightnessRepository;
    private final HeatRepository _heatRepository;
    private final HumidityRepository _humidityRepository;
    private final MicroparticlesRepository _microparticlesRepository;
    private final SoundRepository _soundRepository;
    private final BrightnessBuilder _brightnessBuilder;
    private final MeasurementBuilder _measurementBuilder;
    private final HeatBuilder _heatBuilder;
    private final HumidityBuilder _humidityBuilder;
    private final SoundBuilder _soundBuilder;
    private final MicroparticlesBuilder _microparticlesBuilder;

    public DataInitialisation(
            MeasurementRepository characteristicRepository,
            BrightnessRepository brightnessRepository,
            HeatRepository heatRepository,
            HumidityRepository humidityRepository,
            MicroparticlesRepository microparticlesRepository,
            SoundRepository soundRepository,
            BrightnessBuilder brightnessBuilder,
            MeasurementBuilder characteristicBuilder,
            HeatBuilder heatBuilder,
            HumidityBuilder humidityBuilder,
            SoundBuilder soundBuilder,
            MicroparticlesBuilder microparticlesBuilder,
            JsonParser jsonParser
    ) {
        _characteristicRepository = characteristicRepository;
        _brightnessRepository = brightnessRepository;
        _heatRepository = heatRepository;
        _humidityRepository = humidityRepository;
        _microparticlesRepository = microparticlesRepository;
        _soundRepository = soundRepository;
        _brightnessBuilder = brightnessBuilder;
        _measurementBuilder = characteristicBuilder;
        _heatBuilder = heatBuilder;
        _humidityBuilder = humidityBuilder;
        _soundBuilder = soundBuilder;
        _microparticlesBuilder = microparticlesBuilder;
        _jsonParser = jsonParser;
    }

    // @TODO Remove this class in prod : we want the history of the database
    private void reset() {
        _microparticlesRepository.deleteAll();
        _brightnessRepository.deleteAll();
        _heatRepository.deleteAll();
        _soundRepository.deleteAll();
        _humidityRepository.deleteAll();
        _characteristicRepository.deleteAll();
    }

    private static double generateRandom(double lowerBound, double upperBound) {
        Random random = new Random();
        return lowerBound + (upperBound - lowerBound) * random.nextDouble();
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

    @Bean
    public void init() throws IOException {
        reset();

        for(int i = 0; i < 25; i++) {
            MeasurementEntity measurement = _measurementBuilder
                    .setSerialNumber(generateSerialNumber())
                    .setLatitude(generateRandom(LOWER_BOUND_LATITUDE, UPPER_BOUND_LATITUDE))
                    .setLongitude(generateRandom(LOWER_BOUND_LONGITUDE, UPPER_BOUND_LONGITUDE))
                    .build().save();

            _brightnessBuilder.setCharacteristic(measurement)
                    .setLux(generateRandom(LOWER_BOUND, UPPER_BOUND))
                    .build().save();
            _heatBuilder.setCharacteristic(measurement)
                    .setCelsiusDegree(generateRandom(LOWER_BOUND_TEMPERATURE, UPPER_BOUND_TEMPERATURE))
                    .build().save();
             _humidityBuilder.setCharacteristic(measurement)
                    .setRelativeHumidityPercentage(generateRandom(LOWER_BOUND, UPPER_BOUND))
                    .build().save();
            _microparticlesBuilder.setCharacteristic(measurement)
                    .setParticlesPerCubicCentimeter(generateRandom(LOWER_BOUND, UPPER_BOUND))
                    .build().save();
            _soundBuilder.setCharacteristic(measurement)
                    .setDecibel(generateRandom(LOWER_BOUND, UPPER_BOUND))
                    .build().save();
        }

        ClassPathResource deviceResource = new ClassPathResource("Device.json");
        List<DeviceResponseJson> deviceResponseJsonList = _jsonParser.parseJson(deviceResource.getContentAsString(Charset.defaultCharset()));
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

        }
    }
}
