package model;

import java.util.List;
import java.util.logging.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ItemDAO {
    private final DAO<Item> dao;
    private EntityManager em;
    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class.getName());

    public ItemDAO() {
        this.em = JpaUtil.getEmPostgres();
        this.dao = new DAO<Item>(em, Item.class);
    }

    public void add(Item item) {
        this.dao.add(item);
    }

    public void remove(Item item) {
        this.dao.remove(item);
    }

    public Item update(Item item) {
        item = this.dao.update(item);
        return item;
    }

    public List<Item> list() {
        return this.dao.list();
    }

    public Item find(Integer id) {
        return dao.find(id);
    }

    public List<Item> searchName(String nome) {
        List<Item> result = null;
        try {
            Query query = em.createQuery("select x from Item x where x.nome like :parametro");
            query.setParameter("parametro", "%" + nome + "%");
            result = query.getResultList();
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
        }
        return result;
    }

    public List<Item> searchDescricao(String descricao) {
        List<Item> result = null;
        try {
            Query query = em.createQuery("select x from Item x where x.descricao like :parametro ");
            query.setParameter("parametro", "%" + descricao + "%");
            result = query.getResultList();
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
        }
        return result;
    }

}
