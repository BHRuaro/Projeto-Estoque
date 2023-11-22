package model;

import java.io.Serializable;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "historico")
public class Historico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historico_id;
    @Column
    private Date data_movimentacao;
    @Column
    private int quantidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipomovimentacao_id", referencedColumnName = "tipomovimentacao_id")
    private TipoMovimentacao tipoMovimentacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    public Historico() {
    }

    public Historico(int historico_id, Date data_movimentacao, int quantidade, TipoMovimentacao tipoMovimentacao,
            Operador operador, Usuario usuario, Item item) {
        this.historico_id = historico_id;
        this.data_movimentacao = data_movimentacao;
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao;
        this.operador = operador;
        this.usuario = usuario;
        this.item = item;
    }

    public int getHistorico_id() {
        return historico_id;
    }

    public void setHistorico_id(int historico_id) {
        this.historico_id = historico_id;
    }

    public Date getData_movimentacao() {
        return data_movimentacao;
    }

    public void setData_movimentacao(Date data_movimentacao) {
        this.data_movimentacao = data_movimentacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        }
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        if (tipoMovimentacao != null) {
            this.tipoMovimentacao = tipoMovimentacao;
        }
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        if (operador != null) {
            this.operador = operador;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario != null) {
            this.usuario = usuario;
        }
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        if (item != null) {
            this.item = item;
        }
    }

    @Override
    public String toString() {
        return "Historico" + historico_id + " - " + data_movimentacao + " - " + quantidade + " - " + tipoMovimentacao
                + " - " + operador + " - " + usuario + " - " + item;
    }
}
