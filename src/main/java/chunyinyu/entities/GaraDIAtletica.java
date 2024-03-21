package chunyinyu.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class GaraDIAtletica extends Evento{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    @JoinColumn(name = "persone")
    private List<Persona> persone;

    @OneToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDIAtletica(String titolo, Date data, String descrizione, TipoEvento tipoEvento, int maxNumeroPartecipanti, Location location, List<Persona> persone, Persona vincitore) {
        super(titolo, data, descrizione, tipoEvento, maxNumeroPartecipanti, location);
        this.persone = persone;
        this.vincitore = vincitore;
    }

    public GaraDIAtletica() {

    }

    public List<Persona> getPersone() {
        return persone;
    }

    public void setPersone(List<Persona> persone) {
        this.persone = persone;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GaraDIAtletica{" +
                "id=" + id +
                ", persone=" + persone +
                ", vincitore=" + vincitore +
                '}';
    }
}
