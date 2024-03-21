package chunyinyu;

import chunyinyu.dao.EventoDAO;
import chunyinyu.dao.LocationDAO;
import chunyinyu.dao.PartecipazioneDAO;
import chunyinyu.dao.PersonaDAO;
import chunyinyu.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EsercizioD2S3");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);


        Persona persona1 = new Persona("Mario", "Rossi", "mario@rossi.com",new Date() ,Sesso.M, null);
        Persona persona2 = new Persona("Chris", "Keya", "chris@keya.com",new Date() ,Sesso.M, null);

        List<Persona> listaAtleti = new ArrayList<>();
        listaAtleti.add(persona1);
        listaAtleti.add(persona2);

        Location location1 = new Location("Location1", "Citta'1");
        Location location2 = new Location("Location2", "Citta'2");
        Location location3 = new Location("Location3", "Citta'3");

        Evento evento1 = new Evento("Evento1", new Date(),"Evento1 di prova" ,TipoEvento.PRIVATO, 50, location1);

        Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, Stato.CONFERMATA);

        Concerto concerto1 = new Concerto("Concerto1", new Date(), "Concerto di prova1", TipoEvento.PUBBLICO, 100, location1, Genere.CLASSICO, true);
        Concerto concerto2 = new Concerto("Concerto2", new Date(), "Concerto di prova2", TipoEvento.PRIVATO, 50, location1, Genere.POP, false);

        PartitaDiCalcio partita1 = new PartitaDiCalcio("Partita1", new Date(), "Partita in casa", TipoEvento.PUBBLICO, 200, location2, "Squadra di casa Roma", "Squadra ospite Napoli", "Roma", 2, 1);
        PartitaDiCalcio partita2 = new PartitaDiCalcio("Partita2", new Date(), "Partita ospite", TipoEvento.PUBBLICO, 200, location2, "Squadra di casa Napoli", "Squadra ospite Roma", "Napoli", 1, 2);

        GaraDIAtletica gara1 = new GaraDIAtletica("Atletica1", new Date(), "Atletica prova 1", TipoEvento.PRIVATO, 20, location3, listaAtleti, persona1);

        locationDAO.save(location1);
        locationDAO.save(location2);
        locationDAO.save(location3);
        eventoDAO.save(evento1);
        personaDAO.save(persona1);
        personaDAO.save(persona2);
        eventoDAO.save(concerto1);
        eventoDAO.save(concerto2);
        eventoDAO.save(partita1);
        eventoDAO.save(partita2);
        eventoDAO.save(gara1);
        partecipazioneDAO.save(partecipazione1);
        List<Partecipazione> parteciazioni = new ArrayList<>();
        parteciazioni.add(partecipazioneDAO.getById(1L));

        System.out.println("Concerti in streaming: " + (eventoDAO.getConcertiInStreaming(true)));
        System.out.println("Concerti non in streaming: " + (eventoDAO.getConcertiInStreaming(false)));
        System.out.println("Concerti di genere classico: " + (eventoDAO.getConcertiPerGenere(Genere.CLASSICO)));

        List<PartitaDiCalcio> partiteVinteInCasa = eventoDAO.getPartiteVinteInCasa("Squadra di casa Roma");
        List<PartitaDiCalcio> partiteVinteInTrasferta = eventoDAO.getPartiteVinteInTrasferta("Squadra ospite Napoli");

        System.out.println("Partite vinte in casa:");
        if (partiteVinteInCasa.isEmpty()) {
            System.out.println("Nessuna partita vinta");
        } else {
            for (PartitaDiCalcio partita : partiteVinteInCasa) {
                System.out.println("ID: " + partita.getId() + ", " + partita.getSquadraDiCasa() + ", " + partita.getSquadraOspite());
            }
        }

        System.out.println("Partite vinte in trasferta:");
        if (partiteVinteInTrasferta.isEmpty()) {
            System.out.println("Nessuna partita vinta");
        } else {
            for (PartitaDiCalcio partita : partiteVinteInTrasferta) {
                System.out.println("ID: " + partita.getId() + ", " + partita.getSquadraDiCasa() + ", " + partita.getSquadraOspite());
            }
        }
    }
}
