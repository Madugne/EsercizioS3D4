package chunyinyu.dao;

import chunyinyu.entities.Concerto;
import chunyinyu.entities.Evento;
import chunyinyu.entities.Genere;
import chunyinyu.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento evento){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " aggiunto.");
    }

    public Evento getById(long id){
        Evento evento = entityManager.find(Evento.class, id);
        if (evento == null) throw new NotFoundException(id);
        return evento;
    }

    public void delete(long id) {
        Evento evento = getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " rimosso.");
    }
    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }
    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> query = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }
}
