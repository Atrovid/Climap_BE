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
    @JoinColumn(name = "`idMeasurement`")
    private MeasurementEntity _measurement;
    @Basic
    @Column(name = "`CelsiusDegree`")
    private double _celsiusDegree;

    protected HeatEntity() {}

    public HeatEntity(Double celsiusDegree, MeasurementEntity characteristic) {
        _celsiusDegree = celsiusDegree;
        _measurement = characteristic;
    }

    @JsonIgnore
    public int getIdHeat() {
        return _idHeat;
    }

    public void setIdHeat(int idHeat) {
        _idHeat = idHeat;
    }

    @JsonIgnore
    public MeasurementEntity getCharacteristic() {
        return _measurement;
    }

    public void setCharacteristic(MeasurementEntity characteristic) {
        _measurement = characteristic;
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
        if (_measurement != that._measurement) return false;
        return Objects.equals(_celsiusDegree, that._celsiusDegree);
    }
}
