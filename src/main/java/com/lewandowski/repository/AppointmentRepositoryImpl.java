package com.lewandowski.repository;

import com.lewandowski.entity.Appointment;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepositoryImpl extends EntityRepositoryImpl<Appointment> implements AppointmentRepository {
}
