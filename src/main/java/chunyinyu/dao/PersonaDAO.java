package chunyinyu.dao;

import chunyinyu.entities.Persona;
import chunyinyu.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona persona){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(persona);
        transaction.commit();
        System.out.println("Persona " + persona.getNome() + persona.getCognome() + " aggiunto.");
    }

    public Persona getById(long id){
        Persona persona = entityManager.find(Persona.class, id);
        if (persona == null) throw new NotFoundException(id);
        return persona;
    }

    public void delete(long id) {
        Persona persona = getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(persona);
        transaction.commit();
        System.out.println("Persona " + persona.getNome() + " rimosso.");
    }
}
