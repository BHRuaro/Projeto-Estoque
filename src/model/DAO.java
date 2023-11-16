package model;

import java.util.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.*;

public class DAO<T> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoEstoquePU");
    EntityManager em = emf.createEntityManager();
    private final Class<T> classe;

    public DAO(EntityManager em, Class<T> classe) {
        this.em = em;
        this.classe = classe;
    }

    public T busca(Integer id) {
        return this.em.getReference(classe, id);
    }

    public List<T> list() {
        return em.createQuery("select a from " + classe.getName() + " a", classe).getResultList();
    }

    public void add(T t) {
        this.em.getTransaction().begin();
        this.em.persist(t);
        this.em.flush();
        this.em.getTransaction().commit();
    }

    public void remove(T t) {
        this.em.getTransaction().begin();
        this.em.remove(t);
        this.em.flush();
        this.em.getTransaction().commit();
    }

    public T update(T t) {
        this.em.getTransaction().begin();
        t = this.em.merge(t);
        this.em.flush();
        this.em.getTransaction().commit();
        return t;
    }
}