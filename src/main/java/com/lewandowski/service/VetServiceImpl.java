package com.lewandowski.service;

import com.lewandowski.entity.Vet;
import com.lewandowski.repository.VetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vet> getAllVetsList() {
        return vetRepository.findAll();
    }
}
