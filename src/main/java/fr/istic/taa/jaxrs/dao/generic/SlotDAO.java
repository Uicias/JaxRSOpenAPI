package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Slot;
import javax.persistence.*;
import java.util.List;

public class SlotDAO {

    public EntityManager manager;

    public SlotDAO(){
        this.manager = EntityManagerHelper.getEntityManager();
    }

    public Slot findById(Long id){
        return this.manager.find(Slot.class, id);
    }

    public List<Slot> findAll(){
        return this.manager.createQuery("Select a From Slot a", Slot.class).getResultList();
    }

    public List<Slot> findAllByTeacherId(long id) {
        TypedQuery<Slot> query = this.manager.createQuery("Select a From Slot a where teacher = ?1", Slot.class);
        long teacher = id;
        return query.setParameter(1, teacher).getResultList();
    }

    public void create (Slot slot) {
        if(slot.getId() != null)
            return;
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        this.manager.persist(slot);
        t.commit();
    }

    public Slot update (Slot Slot) {
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        Slot res = manager.merge(Slot);
        t.commit();
        return res;
    }

    public void delete (Slot slot) {
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        System.out.println("-------------------REMOVING---------------------");
        System.out.println("\t" + slot);
        System.out.println("\t" + slot.getId());
        System.out.println("\t" + slot.getTeacher().getId());
        System.out.println("\t" + slot.getAppointment().getId());
        System.out.println("-------------------END---------------------");

        slot.setAppointment(this.manager.merge(slot.getAppointment()));

        this.manager.remove(slot);
        t.commit();
    }

    public void deleteById (Long id) {
        Slot Slot = this.findById(id);
        this.delete(Slot);
    }
}
