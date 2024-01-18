package ENSICAEN.intensive_project.Climap.database.json;

public class DeviceResponseJson {
    private Double _latitude;
    private Double _longitude;
    private Double _lux;
    private Double _celsiusDegree;
    private Double _relativeHumidityPercentage;
    private Double _particlesPerCubicCentimeter;
    private Double _decibel;

    protected DeviceResponseJson() { }

    public Double getLatitude() {
        return _latitude;
    }

    public Double getLongitude() {
        return _longitude;
    }

    public Double getLux() {
        return _lux;
    }

    public Double getCelsiusDegree() {
        return _celsiusDegree;
    }

    public Double get_relativeHumidityPercentage() {
        return _relativeHumidityPercentage;
    }

    public Double get_particlesPerCubicCentimeter() {
        return _particlesPerCubicCentimeter;
    }

    public Double get_decibel() {
        return _decibel;
    }
}
