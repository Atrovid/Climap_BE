package ENSICAEN.intensive_project.Climap.database.initialisation;

import ENSICAEN.intensive_project.Climap.database.constructor.*;
import ENSICAEN.intensive_project.Climap.database.entities.*;
import ENSICAEN.intensive_project.Climap.database.json.DeviceResponseJson;
import ENSICAEN.intensive_project.Climap.database.json.JsonParser;
import ENSICAEN.intensive_project.Climap.database.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Configuration
public class DataInitialisation {
    private final String _filePath = "D:\\3A\\ProjetIntensif\\Climap\\Back-End\\src\\main\\java\\ENSICAEN\\intensive_project\\Climap\\Device.json";
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

    //@TODO Remove this class in prod : we want the history of the database
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

    private static String generateRandomString(int lettersCount, int numbersCount) {
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        // Générer les lettres
        for (int i = 0; i < lettersCount; i++) {
            char randomLetter = (char) ('A' + random.nextInt(26));
            randomString.append(randomLetter);
        }

        // Générer les chiffres
        for (int i = 0; i < numbersCount; i++) {
            int randomNumber = random.nextInt(10);
            randomString.append(randomNumber);
        }

        return randomString.toString();
    }

    @Bean
    public void init() throws IOException {
        reset();
        /*for(int i = 0; i < 25; i++) {
            MeasurementEntity charac = _measurementBuilder
                    .setSerialNumber(generateRandomString(3,7))
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
        }*/
        List<DeviceResponseJson> deviceResponseJsonList = _jsonParser.parseJsonFile(_filePath);
        for (DeviceResponseJson deviceResponse : deviceResponseJsonList) {
            MeasurementEntity charac = _measurementBuilder
                    .setSerialNumber(generateRandomString(3,7))
                    .setLatitude(deviceResponse.get_latitude())
                    .setLongitude(deviceResponse.get_longitude())
                    .build()
                    .save();

            _brightnessBuilder
                    .setCharacteristic(charac)
                    .setLux(deviceResponse.get_lux())
                    .build()
                    .save();
            _heatBuilder
                    .setCharacteristic(charac)
                    .setCelsiusDegree(deviceResponse.get_celsiusDegree())
                    .build().save();
            _humidityBuilder
                    .setCharacteristic(charac)
                    .setRelativeHumidityPercentage(deviceResponse.get_relativeHumidityPercentage())
                    .build().save();
            _microparticlesBuilder
                    .setCharacteristic(charac)
                    .setParticlesPerCubicCentimeter(deviceResponse.get_particlesPerCubicCentimeter())
                    .build().save();
            _soundBuilder
                    .setCharacteristic(charac)
                    .setDecibel(deviceResponse.get_decibel())
                    .build().save();

        }

    }
}
