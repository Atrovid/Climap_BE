package ENSICAEN.intensive_project.Climap.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Microparticles")
@Table(name = "`Microparticles`", schema = "`Sensor`")
public class MicroparticlesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`idMicroparticles`")
    private int _idMicroparticles;
    @ManyToOne
    @JoinColumn(name = "`idMeasurement`")
    private MeasurementEntity _measurement;
    @Basic
    @Column(name = "`ParticlesPerCubicCentimeter`")
    private Double _particlesPerCubicCentimeter;

    protected MicroparticlesEntity() {}

    public MicroparticlesEntity(Double particlesPerCubicCentimeter, MeasurementEntity characteristic) {
        _particlesPerCubicCentimeter = particlesPerCubicCentimeter;
        _measurement = characteristic;
    }

    @JsonIgnore
    public int getIdMicroparticles() {
        return _idMicroparticles;
    }

    public void setIdMicroparticles(int idMicroparticles) {
        _idMicroparticles = idMicroparticles;
    }

    @JsonIgnore
    public MeasurementEntity getCharacteristic() {
        return _measurement;
    }

    public void setCharacteristic(MeasurementEntity idCharacteristic) {
        _measurement = idCharacteristic;
    }

    public Double getParticlesPerCubicCentimeter() {
        return _particlesPerCubicCentimeter;
    }

    public void setParticlesPerCubicCentimeter(Double particlesPerCubicCentimeter) {
        _particlesPerCubicCentimeter = particlesPerCubicCentimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MicroparticlesEntity that = (MicroparticlesEntity) o;
        return _idMicroparticles == that._idMicroparticles && _measurement == that._measurement && Objects.equals(_particlesPerCubicCentimeter, that._particlesPerCubicCentimeter);
    }
}
