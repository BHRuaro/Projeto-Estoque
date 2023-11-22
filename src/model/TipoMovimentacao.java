package model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "tipoMovimentacao")
public class TipoMovimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipo_movimentacao_id;
    @Column
    private String descricao;

    @OneToMany(mappedBy = "tipoMovimentacao")
    private List<Movimentacao> movimentacoes;

    public TipoMovimentacao() {
    }

    public TipoMovimentacao(int tipo_movimentacao_id, String descricao) {
        this.tipo_movimentacao_id = tipo_movimentacao_id;
        this.descricao = descricao;
    }

    public int getTipo_movimentacao_id() {
        return tipo_movimentacao_id;
    }

    public void setTipo_movimentacao_id(int tipo_movimentacao_id) {
        this.tipo_movimentacao_id = tipo_movimentacao_id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return "Tipo de movimentacao: " + tipo_movimentacao_id + " - " + descricao;
    }
}
