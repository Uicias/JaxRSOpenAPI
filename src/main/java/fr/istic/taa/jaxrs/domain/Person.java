package fr.istic.taa.jaxrs.domain;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {

    protected Long id;
    protected String firstName;
    protected String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return this.getFirstName()+" "+this.getLastName();
    }
}
