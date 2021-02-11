package com.lewandowski.service;

import com.lewandowski.entity.Pet;

public interface PetService {
    Pet findById(int id);
    void delete(Pet pet);
}
