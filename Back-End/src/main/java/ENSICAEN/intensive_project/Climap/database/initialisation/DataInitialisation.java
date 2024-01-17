package ENSICAEN.intensive_project.Climap.database.initialisation;

import ENSICAEN.intensive_project.Climap.database.constructor.*;
import ENSICAEN.intensive_project.Climap.database.entities.*;
import ENSICAEN.intensive_project.Climap.database.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class DataInitialisation {
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

    private static double generateRandomDouble() {
        Random random = new Random();
        // Générer un nombre aléatoire de type double entre 0.0 (inclus) et 1.0 (exclus)
        double randomValue = random.nextDouble();

        // Par exemple, pour obtenir un double entre 0.0 (inclus) et 100.0 (exclus)
        return randomValue * 100.0;
    }

    @Bean
    public void init() {
        reset();
        for(int i = 0; i < 100; i++) {
            Double random1 = generateRandomDouble();
            Double random2 = generateRandomDouble();
            Double random3 = generateRandomDouble();
            Double random4 = generateRandomDouble();
            Double random5 = generateRandomDouble();
            Double random6 = generateRandomDouble();
            Double random7 = generateRandomDouble();
            CharacteristicEntity charac = _characteristicBuilder.setLatitude(random1).setLongitude(random2).build().save();
            BrightnessEntity bright = _brightnessBuilder.setCharacteristic(charac).setLux(random3).build().save();
            HeatEntity heat = _heatBuilder.setCharacteristic(charac).setCelsiusDegree(random4).build().save();
            HumidityEntity humidity = _humidityBuilder.setCharacteristic(charac).setRelativeHumidityPercentage(random5).build().save();
            MicroparticlesEntity microparticles = _microparticlesBuilder.setCharacteristic(charac).setParticlesPerCubicCentimeter(random6).build().save();
            SoundEntity sound = _soundBuilder.setCharacteristic(charac).setDecibel(random7).build().save();
        }

    }
}
