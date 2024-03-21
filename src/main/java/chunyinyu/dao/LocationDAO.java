package chunyinyu.dao;

import chunyinyu.entities.Location;
import chunyinyu.entities.Partecipazione;
import chunyinyu.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location location){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(location);
        transaction.commit();
        System.out.println("Location " + location.getNome() + " aggiunto.");
    }

    public Location getById(long id){
        Location location = entityManager.find(Location.class, id);
        if (location == null) throw new NotFoundException(id);
        return location;
    }

    public void delete(long id) {
        Location location = getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(location);
        transaction.commit();
        System.out.println("Location " + location.getNome() + " rimosso.");
    }
}