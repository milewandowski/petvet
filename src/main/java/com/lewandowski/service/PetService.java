package com.lewandowski.service;

import com.lewandowski.entity.Pet;

public interface PetService {
    Pet findById(int id);
    Pet findByName(String name);
    void save(Pet pet);
    void delete(Pet pet);
}
