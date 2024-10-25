package licence.control.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @Column(name = "numE", nullable = false)
    private Integer numE;

    @Column(name = "prenomE", nullable = false, length = 20)
    private String prenomE;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "codeE")
    private Set<Travailler> travaillers = new LinkedHashSet<>();

    public Integer getNumE() {
        return numE;
    }

    public void setNumE(Integer id) {
        this.numE = id;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Travailler> getTravaillers() {
        return travaillers;
    }

    public void setTravaillers(Set<Travailler> travaillers) {
        this.travaillers = travaillers;
    }

}