package com.lewandowski.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet extends NamedEntity {

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birthDate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "species_id")
    private Species species;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "pet", cascade = {CascadeType.ALL})
    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        if(appointments == null) {
            appointments = new ArrayList<>();
        }
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
