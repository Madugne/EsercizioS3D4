package chunyinyu.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; //PK

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona; //FK

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento; //FK

    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Partecipazione() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona.getNome() + " " + persona.getCognome() +
                ", evento=" + evento.getTitolo() +
                ", stato=" + stato +
                '}';
    }
}
