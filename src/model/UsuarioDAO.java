package model;

import java.util.List;
import java.util.logging.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UsuarioDAO {
    private final DAO<Usuario> dao;
    private EntityManager em;
    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class.getName());

    public UsuarioDAO() {
        this.em = JpaUtil.getEmPostgres();
        this.dao = new DAO<Usuario>(em, Usuario.class);
    }

    public void add(Usuario usuario) {
        this.dao.add(usuario);
    }

    public void remove(Usuario usuario) {
        this.dao.remove(usuario);
    }

    public Usuario update(Usuario usuario) {
        usuario = this.dao.update(usuario);
        return usuario;
    }

    public List<Usuario> list() {
        return this.dao.list();
    }

    public Usuario find(Integer id) {
        return dao.find(id);
    }

    public List<Usuario> searchName(String nome) {
        List<Usuario> result = null;
        try {
            Query query = em.createQuery("select x from Usuario x where x.nome like :parametro");
            query.setParameter("parametro", "%" + nome + "%");
            result = query.getResultList();
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
        }
        return result;
    }

    public List<Usuario> searchCPF(String cpf) {
        List<Usuario> result = null;
        try {
            Query query = em.createQuery("select x from Usuario x where x.cpf like :parametro ");
            query.setParameter("parametro", "%" + cpf + "%");
            result = query.getResultList();
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
        }
        return result;
    }

    public List<Usuario> searchEmail(String email) {
        List<Usuario> result = null;
        try {
            Query query = em.createQuery("select x from Usuario x where x.email like :parametro ");
            query.setParameter("parametro", "%" + email + "%");
            result = query.getResultList();
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
        }
        return result;
    }

    public void removeAll() {
        this.em.getTransaction().begin();
        this.em.createQuery("delete from usuario").executeUpdate();
        this.em.flush();
        this.em.getTransaction().commit();
    }

    public Usuario merge(Usuario usuario) {
        return this.em.merge(usuario);
    }
}
