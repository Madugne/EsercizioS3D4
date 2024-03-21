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

        Location location1 = new Location("Location1", "Citta'1");
        Evento evento1 = new Evento("Evento1", new Date(),"Evento1 di prova" ,TipoEvento.PRIVATO, 50, location1);
        Persona persona1 = new Persona("Mario", "Rossi", "mario@rossi.com",new Date() ,Sesso.M, null);
        Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, Stato.CONFERMATA);

        locationDAO.save(location1);
        eventoDAO.save(evento1);
        personaDAO.save(persona1);
        partecipazioneDAO.save(partecipazione1);
        List<Partecipazione> parteciazioni = new ArrayList<>();
        parteciazioni.add(partecipazioneDAO.getById(1L));
        Persona persona2 = personaDAO.getById(1L);
        persona2.setPartecipazioni(parteciazioni);
        personaDAO.save(persona2);


    }
}
