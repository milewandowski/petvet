package com.lewandowski.repository;

import com.lewandowski.entity.Pet;
import org.springframework.stereotype.Repository;

@Repository
public class PetRepositoryImpl extends EntityRepositoryImpl<Pet> implements PetRepository {
}
