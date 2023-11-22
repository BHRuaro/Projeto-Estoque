package model;

import java.util.List;

import jakarta.persistence.EntityManager;

public class HistoricoDAO {
    private final DAO<Historico> dao;
    private EntityManager em;

    public HistoricoDAO() {
        this.em = JpaUtil.getEmPostgres();
        this.dao = new DAO<Historico>(em, Historico.class);
    }

    public void add(Historico historico) {
        this.dao.add(historico);
    }

    public void remove(Historico historico) {
        this.dao.remove(historico);
    }

    public Historico update(Historico historico) {
        historico = this.dao.update(historico);
        return historico;
    }

    public Historico find(Integer id) {
        return this.dao.find(id);
    }

    public List<Historico> list() {
        return this.dao.list();
    }

    public List<Historico> listEntradas() {
        return this.em.createQuery("SELECT h FROM Historico h WHERE h.tipo_movimentacao_id = '1'", Historico.class)
                .getResultList();
    }

    public List<Historico> listSaidas() {
        return this.em.createQuery("SELECT h FROM Historico h WHERE h.tipo_movimentacao_id = '2'", Historico.class)
                .getResultList();
    }
}
