package com.lewandowski.repository;

import com.lewandowski.entity.Appointment;

import java.util.List;

public interface AppointmentRepository extends EntityRepository<Appointment> {
    List<Appointment> findAllByPetId(int id);
}
