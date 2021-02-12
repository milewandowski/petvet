package com.lewandowski.repository;

import com.lewandowski.entity.Pet;

public interface PetRepository extends EntityRepository<Pet> {
    Pet findByName(String name);
}
