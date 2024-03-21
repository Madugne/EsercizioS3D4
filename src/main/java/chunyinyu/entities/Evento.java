package chunyinyu.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_evento")
    private Date data;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column(name = "numero_massimo_partecipanti")
    private int maxNumeroPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Evento() {
        //costruttore vuoto
    }

    public Evento(String titolo, Date data, String descrizione, TipoEvento tipoEvento, int maxNumeroPartecipanti, Location location) {
        this.titolo = titolo;
        this.data = data;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.maxNumeroPartecipanti = maxNumeroPartecipanti;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getMaxNumeroPartecipanti() {
        return maxNumeroPartecipanti;
    }

    public void setMaxNumeroPartecipanti(int maxNumeroPartecipanti) {
        this.maxNumeroPartecipanti = maxNumeroPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", maxNumeroPartecipanti=" + maxNumeroPartecipanti +
                ", location=" + location +
                '}';
    }
}
