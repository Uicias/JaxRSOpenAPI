package fr.istic.taa.jaxrs.domain;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    public User () {}

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    public User (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


    public void addAppointment(Appointment app){
        if(app != null)
            this.appointments.add(app);
    }

}

