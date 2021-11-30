package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Appointment;

import javax.persistence.*;
import java.util.List;

public class AppointmentDAO {
    public EntityManager manager;

    public AppointmentDAO(){
        this.manager = EntityManagerHelper.getEntityManager();
    }

    public Appointment findById(Long id){
        return this.manager.find(Appointment.class, id);
    }

    public List<Appointment> findAll(){
        return this.manager.createQuery("Select a From Appointment a", Appointment.class).getResultList();
    }

    public void create (Appointment appointment) {
        if(appointment.getId() != null)
            return;
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        this.manager.persist(appointment);
        t.commit();
    }

    public Appointment update (Appointment Appointment) {
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        Appointment res = manager.merge(Appointment);
        t.commit();
        return res;
    }

    public void delete (Appointment appointment) {
        System.out.println("trying to delete appointment " + appointment.getSlot().getId());
        EntityTransaction t = this.manager.getTransaction();
        t.begin();
        appointment.setSlot(this.manager.merge(appointment.getSlot()));
        this.manager.remove(appointment);
        t.commit();
    }

    public void deleteById (Long id) {
        Appointment appointment = this.findById(id);
        this.delete(appointment);
    }
}
