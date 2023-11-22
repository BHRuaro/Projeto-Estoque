package model;

import jakarta.persistence.EntityManager;

public class TipoMovimentacaoDAO {

    private final DAO<TipoMovimentacao> dao;
    private EntityManager em;

    public TipoMovimentacaoDAO() {
        this.em = JpaUtil.getEmPostgres();
        this.dao = new DAO<TipoMovimentacao>(em, TipoMovimentacao.class);
    }

    public void add(TipoMovimentacao tipoMovimentacao) {
        this.dao.add(tipoMovimentacao);
    }

    public void remove(TipoMovimentacao tipoMovimentacao) {
        this.dao.remove(tipoMovimentacao);
    }

    public TipoMovimentacao update(TipoMovimentacao tipoMovimentacao) {
        tipoMovimentacao = this.dao.update(tipoMovimentacao);
        return tipoMovimentacao;
    }

    public TipoMovimentacao find(Integer id) {
        return dao.find(id);
    }

    public void list() {
        this.dao.list();
    }

    public void removeAll() {
        this.em.getTransaction().begin();
        this.em.createQuery("delete from tipomovimentacao").executeUpdate();
        this.em.flush();
        this.em.getTransaction().commit();
    }
}
