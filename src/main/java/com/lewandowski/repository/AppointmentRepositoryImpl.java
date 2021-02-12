package com.lewandowski.repository;

import com.lewandowski.entity.Appointment;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRepositoryImpl extends EntityRepositoryImpl<Appointment> implements AppointmentRepository {

    @Override
    public List<Appointment> findAllByPetId(int id) {
        Query<Appointment> query = getSession().
                createQuery("from Appointment a where a.pet.id =:petId", Appointment.class);
        query.setParameter("petId", id);

        return query.getResultList();
    }
}
