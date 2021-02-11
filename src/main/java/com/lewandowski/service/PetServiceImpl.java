package com.lewandowski.service;

import com.lewandowski.entity.Pet;
import com.lewandowski.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    @Transactional
    public Pet findById(int id) {
        return petRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }
}
