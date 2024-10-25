package licence.control.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Table(name = "travailler", schema = "bddsupermarche")
public class Travailler {
    @EmbeddedId
    private TravaillerId id;

    @MapsId("codeE")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codeE", nullable = false)
    private Employe codeE;

    @MapsId("codeR")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codeR", nullable = false)
    private Rayon codeR;

    @ColumnDefault("0")
    @Column(name = "temps")
    private Integer temps;

    @Column(name = "date", insertable = false, updatable = false)
    private Date date;


    public TravaillerId getId() {
        return id;
    }

    public void setId(TravaillerId id) {
        this.id = id;
    }

    public Employe getCodeE() {
        return codeE;
    }

    public void setCodeE(Employe codeE) {
        this.codeE = codeE;
    }

    public Rayon getCodeR() {
        return codeR;
    }

    public void setCodeR(Rayon codeR) {
        this.codeR = codeR;
    }

    public Integer getTemps() {
        return temps;
    }

    public void setTemps(Integer temps) {
        this.temps = temps;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

}