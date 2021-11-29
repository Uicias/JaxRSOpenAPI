package fr.istic.taa.jaxrs.dao.generic;


import fr.istic.taa.jaxrs.domain.Teacher;

import javax.persistence.*;
import java.util.List;

public class TeacherDAO {

    public EntityManager manager;

    public TeacherDAO(){
        this.manager = EntityManagerHelper.getEntityManager();
    }

    public Teacher findById(Long id){
        return this.manager.find(Teacher.class, id);
    }

    public List<Teacher> findAll(){
        return this.manager.createQuery("Select a From Teacher a", Teacher.class).getResultList();
    }

    public void create (Teacher teacher) {
        if(teacher.getId() != null)
            return;

        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        this.manager.persist(teacher);
        t.commit();
    }

    public Teacher update (Teacher teacher) {
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        Teacher res = manager.merge(teacher);
        t.commit();
        return res;
    }

    public void delete (Teacher teacher) {
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        this.manager.remove(teacher);
        t.commit();
    }

    public void deleteById (Long id) {
        Teacher teacher = this.findById(id);
        this.delete(teacher);
    }

}
