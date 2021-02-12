package com.lewandowski.service;

import com.lewandowski.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    void save(Appointment appointment);
    void delete(Appointment appointment);
    Appointment findById(int id);
    List<Appointment> findAllByPetId(int petId);
}
