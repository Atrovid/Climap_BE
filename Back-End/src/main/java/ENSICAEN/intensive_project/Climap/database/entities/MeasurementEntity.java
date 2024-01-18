package ENSICAEN.intensive_project.Climap.database.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Entity(name = "Measurement")
@Table(name = "`Measurement`", schema = "`Sensor`")
public class MeasurementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`idMeasurement`")
    private Integer _idMeasurement;
    @Basic
    @Column(name = "`SerialNumber`")
    private String _serialNumber;

    @Basic
    @Column(name = "`Latitude`")
    private double _latitude;
    @Basic
    @Column(name = "`Longitude`")
    private double _longitude;
    @Basic
    @Column(name = "`DateDataCapture`")
    private Timestamp _dateDataCapture;
    @OneToMany(mappedBy = "_measurement")
    private List<BrightnessEntity> _brightness;
    @OneToMany(mappedBy = "_measurement")
    private List<HeatEntity> _heat;
    @OneToMany(mappedBy = "_measurement")
    private List<HumidityEntity> _humidity;
    @OneToMany(mappedBy = "_measurement")
    private List<MicroparticlesEntity> _microparticle;
    @OneToMany(mappedBy = "_measurement")
    private List<SoundEntity> _sound;

    protected MeasurementEntity() {}

    public MeasurementEntity(double latitude, double longitude, String serialNumber) {
        _dateDataCapture = generateRandomDate();
        _latitude = latitude;
        _longitude = longitude;
        _serialNumber = serialNumber;
    }

    private static Timestamp generateRandomDate() {
        Calendar calendar = Calendar.getInstance();
        Random random = new Random();
        int randomDays = random.nextInt(365);

        calendar.add(Calendar.DAY_OF_YEAR, -randomDays);

        return new Timestamp(calendar.getTimeInMillis());
    }

    public int getIdMeasurement() {
        return _idMeasurement;
    }

    public void setIdCharacteristic(int idCharacteristic) {
        _idMeasurement = idCharacteristic;
    }

    public double getLatitude() {
        return _latitude;
    }

    public void setLatitude(double latitude) {
        _latitude = latitude;
    }

    public double getLongitude() {
        return _longitude;
    }

    public void setLongitude(double longitude) {
        _longitude = longitude;
    }

    public Timestamp getDateDataCapture() {
        return _dateDataCapture;
    }

    public void setDateDataCapture(Timestamp dateDataCapture) {
        _dateDataCapture = dateDataCapture;
    }

    public List<BrightnessEntity> getBrightness() {
        return _brightness;
    }

    public void setBrightness(List<BrightnessEntity> brightness) {
        _brightness = brightness;
    }

    public List<HeatEntity> getHeat() {
        return _heat;
    }

    public void setHeat(List<HeatEntity> heat) {
        _heat = heat;
    }

    public List<HumidityEntity> getHumidity() {
        return _humidity;
    }

    public void setHumidity(List<HumidityEntity> humidity) {
        _humidity = humidity;
    }

    public List<SoundEntity> getSound() {
        return _sound;
    }

    public void setSound(List<SoundEntity> sound) {
        _sound = sound;
    }

    public List<MicroparticlesEntity> getMicroparticle() {
        return _microparticle;
    }

    public void setMicroparticle(List<MicroparticlesEntity> microparticle) {
        _microparticle = microparticle;
    }

    public String getSerialNumber() {
        return _serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        _serialNumber = serialNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasurementEntity that = (MeasurementEntity) o;

        if (!Objects.equals(_idMeasurement, that._idMeasurement)) return false;
        if (!Objects.equals(_latitude, that._latitude)) return false;
        if (!Objects.equals(_longitude, that._longitude)) return false;
        return Objects.equals(_dateDataCapture, that._dateDataCapture);
    }
}
