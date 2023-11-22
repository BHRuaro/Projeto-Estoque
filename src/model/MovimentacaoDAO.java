package model;

import java.util.List;
import jakarta.persistence.EntityManager;

public class MovimentacaoDAO {

    private final DAO<Movimentacao> dao;
    private final EntityManager em;

    public MovimentacaoDAO() {
        this.em = JpaUtil.getEmPostgres();
        this.dao = new DAO<Movimentacao>(em, Movimentacao.class);
    }

    public void add(Movimentacao movimentacao) {
        this.dao.add(movimentacao);
    }

    public void remove(Movimentacao movimentacao) {
        this.dao.remove(movimentacao);
    }

    public Movimentacao update(Movimentacao movimentacao) {
        movimentacao = this.dao.update(movimentacao);
        return movimentacao;
    }

    public Movimentacao find(Integer id) {
        return dao.find(id);
    }

    public List<Movimentacao> list() {
        return this.dao.list();
    }
}
