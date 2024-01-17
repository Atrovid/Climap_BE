package ENSICAEN.intensive_project.Climap.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Heat")
@Table(name = "`Heat`", schema = "`Sensor`")
public class HeatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`idHeat`")
    private int _idHeat;
    @ManyToOne
    @JoinColumn(name = "`idCharacteristic`")
    private CharacteristicEntity _characteristic;
    @Basic
    @Column(name = "`CelsiusDegree`")
    private double _celsiusDegree;

    protected HeatEntity() {}

    public HeatEntity(Double celsiusDegree, CharacteristicEntity characteristic) {
        _celsiusDegree = celsiusDegree;
        _characteristic = characteristic;
    }

    @JsonIgnore
    public int getIdHeat() {
        return _idHeat;
    }

    public void setIdHeat(int idHeat) {
        _idHeat = idHeat;
    }

    @JsonIgnore
    public CharacteristicEntity getCharacteristic() {
        return _characteristic;
    }

    public void setCharacteristic(CharacteristicEntity characteristic) {
        _characteristic = characteristic;
    }

    public double getCelsiusDegree() {
        return _celsiusDegree;
    }

    public void setCelsiusDegree(double celsiusDegree) {
        _celsiusDegree = celsiusDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeatEntity that = (HeatEntity) o;

        if (_idHeat != that._idHeat) return false;
        if (_characteristic != that._characteristic) return false;
        return Objects.equals(_celsiusDegree, that._celsiusDegree);
    }
}
