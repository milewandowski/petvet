package com.lewandowski.repository;

import com.lewandowski.entity.Pet;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class PetRepositoryImpl extends EntityRepositoryImpl<Pet> implements PetRepository {

    @Override
    public Pet findByName(String name) {

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Pet> cq = cb.createQuery(Pet.class);
        Root<Pet> root = cq.from(Pet.class);
        cq.select(root)
                .where(cb.equal(root.get("name"),name));
        Pet pet;
        try {
            pet = getSession().createQuery(cq).getSingleResult();
        } catch (Exception e) {
            pet = null;
        }

        return pet;
    }
}
