package chunyinyu.dao;

import chunyinyu.entities.Evento;
import chunyinyu.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
