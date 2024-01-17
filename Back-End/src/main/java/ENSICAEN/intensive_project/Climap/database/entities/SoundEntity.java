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
    @JoinColumn(name = "`idCharacteristic`")
    private CharacteristicEntity _characteristic;
    @Basic
    @Column(name = "`Decibel`")
    private double _decibel;

    protected SoundEntity() {}

    public SoundEntity(double decibel) {
        _decibel = decibel;
    }

    public SoundEntity(Double decibel, CharacteristicEntity characteristic) {
        _decibel = decibel;
        _characteristic = characteristic;
    }

    @JsonIgnore
    public Integer getIdSound() {
        return _idSound;
    }

    public void setIdSound(Integer idSound) {
        _idSound = idSound;
    }

    @JsonIgnore
    public CharacteristicEntity getCharacteristic() {
        return _characteristic;
    }

    public void setCharacteristic(CharacteristicEntity idSensor) {
        _characteristic = idSensor;
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
        if (_characteristic != that._characteristic) return false;
        return Objects.equals(_decibel, that._decibel);
    }
}
