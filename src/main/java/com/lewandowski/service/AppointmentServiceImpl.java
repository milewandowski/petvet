package com.lewandowski.service;

import com.lewandowski.entity.Appointment;
import com.lewandowski.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    @Transactional
    public void save(Appointment appointment) {
        appointmentRepository.saveOrUpdate(appointment);
    }
}
