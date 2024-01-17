package ENSICAEN.intensive_project.Climap.database.initialisation;

import ENSICAEN.intensive_project.Climap.database.constructor.*;
import ENSICAEN.intensive_project.Climap.database.entities.*;
import ENSICAEN.intensive_project.Climap.database.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class DataInitialisation {
    private final static double LOWER_BOUND_LONGITUDE = -0.265388;
    private final static double UPPER_BOUND_LONGITUDE = -0.43499;
    private final static double LOWER_BOUND_LATITUDE = 49.128039;
    private final static double UPPER_BOUND_LATITUDE = 49.238;
    private final static double LOWER_BOUND_TEMPERATURE = 10.0;
    private final static double UPPER_BOUND_TEMPERATURE = 13.0;
    private final static double LOWER_BOUND = 0.0;
    private final static double UPPER_BOUND = 100.0;
    private final CharacteristicRepository _characteristicRepository;
    private final BrightnessRepository _brightnessRepository;
    private final HeatRepository _heatRepository;
    private final HumidityRepository _humidityRepository;
    private final MicroparticlesRepository _microparticlesRepository;
    private final SoundRepository _soundRepository;
    private final BrightnessBuilder _brightnessBuilder;
    private final CharacteristicBuilder _characteristicBuilder;
    private final HeatBuilder _heatBuilder;
    private final HumidityBuilder _humidityBuilder;
    private final SoundBuilder _soundBuilder;
    private final MicroparticlesBuilder _microparticlesBuilder;

    public DataInitialisation(
            CharacteristicRepository characteristicRepository,
            BrightnessRepository brightnessRepository,
            HeatRepository heatRepository,
            HumidityRepository humidityRepository,
            MicroparticlesRepository microparticlesRepository,
            SoundRepository soundRepository,
            BrightnessBuilder brightnessBuilder,
            CharacteristicBuilder characteristicBuilder,
            HeatBuilder heatBuilder,
            HumidityBuilder humidityBuilder,
            SoundBuilder soundBuilder,
            MicroparticlesBuilder microparticlesBuilder
    ) {
        _characteristicRepository = characteristicRepository;
        _brightnessRepository = brightnessRepository;
        _heatRepository = heatRepository;
        _humidityRepository = humidityRepository;
        _microparticlesRepository = microparticlesRepository;
        _soundRepository = soundRepository;
        _brightnessBuilder = brightnessBuilder;
        _characteristicBuilder = characteristicBuilder;
        _heatBuilder = heatBuilder;
        _humidityBuilder = humidityBuilder;
        _soundBuilder = soundBuilder;
        _microparticlesBuilder = microparticlesBuilder;
    }

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

    @Bean
    public void init() {
        reset();
        for(int i = 0; i < 25; i++) {
            CharacteristicEntity charac = _characteristicBuilder
                    .setLatitude(generateRandom(LOWER_BOUND_LATITUDE, UPPER_BOUND_LATITUDE))
                    .setLongitude(generateRandom(LOWER_BOUND_LONGITUDE, UPPER_BOUND_LONGITUDE))
                    .build().save();

            _brightnessBuilder.setCharacteristic(charac)
                    .setLux(generateRandom(LOWER_BOUND, UPPER_BOUND))
                    .build().save();
            _heatBuilder.setCharacteristic(charac)
                    .setCelsiusDegree(generateRandom(LOWER_BOUND_TEMPERATURE, UPPER_BOUND_TEMPERATURE))
                    .build().save();
             _humidityBuilder.setCharacteristic(charac)
                    .setRelativeHumidityPercentage(generateRandom(LOWER_BOUND, UPPER_BOUND))
                    .build().save();
            _microparticlesBuilder.setCharacteristic(charac)
                    .setParticlesPerCubicCentimeter(generateRandom(LOWER_BOUND, UPPER_BOUND))
                    .build().save();
            _soundBuilder.setCharacteristic(charac)
                    .setDecibel(generateRandom(LOWER_BOUND, UPPER_BOUND))
                    .build().save();
        }

    }
}
