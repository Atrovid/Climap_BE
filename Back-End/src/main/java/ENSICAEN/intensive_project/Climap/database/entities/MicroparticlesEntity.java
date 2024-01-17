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
    private int idMicroparticles;
    @ManyToOne
    @JoinColumn(name = "`idCharacteristic`")
    private MeasurementEntity _characteristic;
    @Basic
    @Column(name = "`ParticlesPerCubicCentimeter`")
    private Double _particlesPerCubicCentimeter;

    protected MicroparticlesEntity() {}

    public MicroparticlesEntity(Double particlesPerCubicCentimeter, MeasurementEntity characteristic) {
        _particlesPerCubicCentimeter = particlesPerCubicCentimeter;
        _characteristic = characteristic;
    }

    @JsonIgnore
    public int getIdMicroparticles() {
        return idMicroparticles;
    }

    public void setIdMicroparticles(int idMicroparticles) {
        idMicroparticles = idMicroparticles;
    }

    @JsonIgnore
    public MeasurementEntity getCharacteristic() {
        return _characteristic;
    }

    public void setCharacteristic(MeasurementEntity idCharacteristic) {
        _characteristic = idCharacteristic;
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
        return idMicroparticles == that.idMicroparticles && _characteristic == that._characteristic && Objects.equals(_particlesPerCubicCentimeter, that._particlesPerCubicCentimeter);
    }
}
