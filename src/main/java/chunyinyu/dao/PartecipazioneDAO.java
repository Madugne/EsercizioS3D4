package chunyinyu.dao;

import chunyinyu.entities.Partecipazione;
import chunyinyu.entities.Persona;
import chunyinyu.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione partecipazione){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione " + partecipazione.getId() + " aggiunto.");
    }

    public Partecipazione getById(long id){
        Partecipazione partecipazione = entityManager.find(Partecipazione.class, id);
        if (partecipazione == null) throw new NotFoundException(id);
        return partecipazione;
    }

    public void delete(long id) {
        Partecipazione partecipazione = getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione " + partecipazione.getId() + " rimosso.");
    }
}
