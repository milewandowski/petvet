package com.lewandowski.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {

    @Column(name = "appointment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "must not be empty")
    private LocalDate appointmentDate;

    @Column(name = "description")
    @NotEmpty
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
