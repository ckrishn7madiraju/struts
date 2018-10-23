package org.superbiz.struts;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void add(User user) {
        manager.persist(user);
    }

    public User find(long id) {
        return manager.find(User.class, id);
    }

    public List<User> findAll() {
        return manager.createQuery("select u from User u").getResultList();
    }

}
