package ENSICAEN.intensive_project.Climap.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Humidity")
@Table(name = "`Humidity`", schema = "`Sensor`")
public class HumidityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`idHumidity`")
    private Integer _idHumidity;
    @ManyToOne
    @JoinColumn(name = "`idCharacteristic`")
    private MeasurementEntity _characteristic;
    @Basic
    @Column(name = "`RelativeHumidityPercentage`")
    private double _relativeHumidityPercentage;

    protected HumidityEntity() { }

    public HumidityEntity(Double particlesPerCubicCentimeter, MeasurementEntity characteristic) {
        _relativeHumidityPercentage =  particlesPerCubicCentimeter;
        _characteristic = characteristic;
    }

    @JsonIgnore
    public Integer getIdHumidity() {
        return _idHumidity;
    }

    public void setIdHumidity(Integer idHumidity) {
        _idHumidity = idHumidity;
    }

    @JsonIgnore
    public MeasurementEntity getCharacteristic() {
        return _characteristic;
    }

    public void setCharacteristic(MeasurementEntity idSensor) {
        _characteristic = idSensor;
    }

    public double getRelativeHumidityPercentage() {
        return _relativeHumidityPercentage;
    }

    public void setRelativeHumidityPercentage(double relativeHumidityPercentage) {
        _relativeHumidityPercentage = relativeHumidityPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HumidityEntity that = (HumidityEntity) o;

        if (!Objects.equals(_idHumidity, that._idHumidity)) return false;
        if (_characteristic != that._characteristic) return false;
        return Objects.equals(_relativeHumidityPercentage, that._relativeHumidityPercentage);
    }
}
