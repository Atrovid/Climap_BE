package ENSICAEN.intensive_project.Climap.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Brightness")
@Table(name = "`Brightness`", schema = "`Sensor`")
public class BrightnessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`idBrightness`")
    private Integer _idBrightness;
    @ManyToOne
    @JoinColumn(name = "`idCharacteristic`")
    private CharacteristicEntity _characteristic;
    @Basic
    @Column(name = "`Lux`")
    private double _lux;

    protected BrightnessEntity() {}

    public BrightnessEntity(Double lux,  CharacteristicEntity characteristic) {
        _lux = lux;
        _characteristic = characteristic;
    }

    @JsonIgnore
    public Integer getIdBrightness() {
        return _idBrightness;
    }

    public void setIdBrightness(int idBrightness) {
        _idBrightness = idBrightness;
    }

    @JsonIgnore
    public CharacteristicEntity getCharacteristic() {
        return _characteristic;
    }

    public void setCharacteristic(CharacteristicEntity characteristic) {
        _characteristic = characteristic;
    }

    public double getLux() {
        return _lux;
    }

    public void setLux(double lux) {
        _lux = lux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrightnessEntity that = (BrightnessEntity) o;

        if (_idBrightness != that._idBrightness) return false;
        if (_characteristic != that._characteristic) return false;
        return Objects.equals(_lux, that._lux);
    }

}
