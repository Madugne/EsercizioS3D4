package chunyinyu.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "partitaDiCalcio")
public class PartitaDiCalcio extends Evento{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Squadra_di_casa")
    private String squadraDiCasa;
    @Column(name = "Squadra_ospite")
    private String squadraOspite;
    @Column(name = "Squadra_vincente")
    private String squadraVincente;
    @Column(name = "nGol_SquadraDiCasa")
    private int nGolSquadraDiCasa;
    @Column(name = "nGol_SquadraOspite")
    private int nGolSquadraOspite;


    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, Date data, String descrizione, TipoEvento tipoEvento, int maxNumeroPartecipanti, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int nGolSquadraDiCasa, int nGolSquadraOspite) {
        super(titolo, data, descrizione, tipoEvento, maxNumeroPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.nGolSquadraDiCasa = nGolSquadraDiCasa;
        this.nGolSquadraOspite = nGolSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getnGolSquadraDiCasa() {
        return nGolSquadraDiCasa;
    }

    public void setnGolSquadraDiCasa(int nGolSquadraDiCasa) {
        this.nGolSquadraDiCasa = nGolSquadraDiCasa;
    }

    public int getnGolSquadraOspite() {
        return nGolSquadraOspite;
    }

    public void setnGolSquadraOspite(int nGolSquadraOspite) {
        this.nGolSquadraOspite = nGolSquadraOspite;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "id=" + id +
                ", squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", nGolSquadraDiCasa=" + nGolSquadraDiCasa +
                ", nGolSquadraOspite=" + nGolSquadraOspite +
                '}';
    }
}
