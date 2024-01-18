package ENSICAEN.intensive_project.Climap.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Sound")
@Table(name = "`Sound`", schema = "`Sensor`")
public class SoundEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`idSound`")
    private Integer _idSound;
    @ManyToOne
    @JoinColumn(name = "`idMeasurement`")
    private MeasurementEntity _measurement;
    @Basic
    @Column(name = "`Decibel`")
    private double _decibel;

    protected SoundEntity() {}

    public SoundEntity(double decibel) {
        _decibel = decibel;
    }

    public SoundEntity(Double decibel, MeasurementEntity characteristic) {
        _decibel = decibel;
        _measurement = characteristic;
    }

    @JsonIgnore
    public Integer getIdSound() {
        return _idSound;
    }

    public void setIdSound(Integer idSound) {
        _idSound = idSound;
    }

    @JsonIgnore
    public MeasurementEntity getCharacteristic() {
        return _measurement;
    }

    public void setCharacteristic(MeasurementEntity idSensor) {
        _measurement = idSensor;
    }

    public double getDecibel() {
        return _decibel;
    }

    public void setDecibel(double decibel) {
        _decibel = decibel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoundEntity that = (SoundEntity) o;

        if (!Objects.equals(_idSound, that._idSound)) return false;
        if (_measurement != that._measurement) return false;
        return Objects.equals(_decibel, that._decibel);
    }
}
