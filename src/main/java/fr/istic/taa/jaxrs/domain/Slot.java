package fr.istic.taa.jaxrs.domain;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

@XmlRootElement(name = "Slot")
public class Slot {

    private Long id;
    private Date start;
    private Date end;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Appointment appointment;

    @XmlTransient
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    public Slot(){}

    public Slot(Date start, Date end){
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() { return start; }

    public void setStart(Date start) { this.start = start; }

    public Date getEnd() { return end; }

    public void setEnd(Date end) { this.end = end; }

    public void setTeacher(Teacher teacher) {
        if(teacher != null)
            this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setAppointment(Appointment appointment) {
        if(appointment != null)
            this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return this.appointment;
    }

}
