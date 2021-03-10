package com.lewandowski.repository.impl;

import com.lewandowski.entity.Role;
import com.lewandowski.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class RoleRepositoryImpl extends EntityRepositoryImpl<Role> implements RoleRepository {

    @Override
    public Role findRoleByName(String roleName) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        cq.select(root)
                .where(cb.equal(root.get("name"), roleName));

        Role role;
        try {
            role = getSession().createQuery(cq).getSingleResult();
        } catch (Exception e) {
            role = null;
        }

        return role;
    }

}
