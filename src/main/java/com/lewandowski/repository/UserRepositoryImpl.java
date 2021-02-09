package com.lewandowski.repository;

import com.lewandowski.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserRepositoryImpl extends EntityRepositoryImpl<User> implements UserRepository {

    @Override
    public User findByUsername(String username) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root)
                .where(cb.equal(root.get("username"), username));

        User user;
        try {
            user = getSession().createQuery(cq).getSingleResult();
        } catch (Exception e) {
            user = null;
        }

        return user;
    }
}
