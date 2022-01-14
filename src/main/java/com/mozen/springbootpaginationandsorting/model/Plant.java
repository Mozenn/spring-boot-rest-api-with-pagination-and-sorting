package com.mozen.springbootpaginationandsorting.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "plant")
@Getter
@Setter
public class Plant {

    public Plant() {
        this.createdAt = Instant.now();
    }
    public Plant(String name, String scientificName, String family) {
        this.name = name;
        this.scientificName = scientificName;
        this.family = family;
        this.createdAt = Instant.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NaturalId()
    @Column(name = "name")
    private String name;

    @NaturalId()
    @Column(name = "scientificName")
    private String scientificName;

    @Column(name = "family")
    private String family;

    @Column(name = "createdAt")
    private Instant createdAt = Instant.now();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plant)) return false;
        Plant plant = (Plant) o;
        return Objects.equals(id, plant.id) && Objects.equals(name, plant.name) && Objects.equals(scientificName,
                plant.scientificName) && Objects.equals(family, plant.family) && Objects.equals(createdAt,
                plant.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, scientificName, family, createdAt);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", family='" + family + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
