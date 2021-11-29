package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UserDAO {

    public EntityManager manager;

    public UserDAO(){
        this.manager = EntityManagerHelper.getEntityManager();
    }

    public User findById(Long id){
        return this.manager.find(User.class, id);
    }

    public List<User> findAll(){
        return this.manager.createQuery("Select a From User a", User.class).getResultList();
    }

    public void create (User user) {
        if(user.getId() != null)
            return;

        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        this.manager.persist(user);
        t.commit();
    }

    public User update (User user) {
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        User res = manager.merge(user);
        t.commit();
        return res;
    }

    public void delete (User user) {
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        this.manager.remove(user);
        t.commit();
    }

    public void deleteById (Long id) {
        User user = this.findById(id);
        this.delete(user);
    }
}

