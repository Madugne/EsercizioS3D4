package chunyinyu.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "concerto")
public class Concerto extends Evento{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "genere")
    @Enumerated(EnumType.STRING)
    private Genere genere;
    @Column(name = "in_streaming")
    private boolean inStreaming;

    public Concerto(String titolo, Date data, String descrizione, TipoEvento tipoEvento, int maxNumeroPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, data, descrizione, tipoEvento, maxNumeroPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }
    public Concerto() {

    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public long getId() {
        return id;
    }

//    public boolean getConcertoInStreaming() {
//        return inStreaming;
//    }

    @Override
    public String toString() {
        return "Concerto{" +
                "id=" + id +
                ", genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }

}
