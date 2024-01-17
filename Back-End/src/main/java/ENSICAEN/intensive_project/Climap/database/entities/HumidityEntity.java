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
    private CharacteristicEntity _characteristic;
    @Basic
    @Column(name = "`ParticlesPerCubicCentimeter`")
    private double _particlesPerCubicCentimeter;

    protected HumidityEntity() { }

    public HumidityEntity(Double particlesPerCubicCentimeter, CharacteristicEntity characteristic) {
        _particlesPerCubicCentimeter =  particlesPerCubicCentimeter;
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
    public CharacteristicEntity getCharacteristic() {
        return _characteristic;
    }

    public void setCharacteristic(CharacteristicEntity idSensor) {
        _characteristic = idSensor;
    }

    public double getParticlesPerCubicCentimeter() {
        return _particlesPerCubicCentimeter;
    }

    public void setParticlesPerCubicCentimeter(double particlesPerCubicCentimeter) {
        _particlesPerCubicCentimeter = particlesPerCubicCentimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HumidityEntity that = (HumidityEntity) o;

        if (!Objects.equals(_idHumidity, that._idHumidity)) return false;
        if (_characteristic != that._characteristic) return false;
        return Objects.equals(_particlesPerCubicCentimeter, that._particlesPerCubicCentimeter);
    }
}
