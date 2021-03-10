package com.lewandowski.service.impl;

import com.lewandowski.entity.Vet;
import com.lewandowski.repository.VetRepository;
import com.lewandowski.service.VetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public List<Vet> getAllVetsList() {
        return vetRepository.findAll();
    }
}
