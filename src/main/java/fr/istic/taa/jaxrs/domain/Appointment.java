package fr.istic.taa.jaxrs.domain;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

public class Appointment {
    private Long id;
    @XmlTransient
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToOne(mappedBy = "appointment", cascade = CascadeType.REMOVE)
    private Slot slot;

    public Appointment(){}

    public Appointment(User user, Slot slot) {
        this.user = user;
        this.slot = slot;
        this.user.addAppointment(this);
        this.slot.setAppointment(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) { this.user = user; }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) { this.slot = slot; }

    public Long getId() {
        return id;
    }

}
