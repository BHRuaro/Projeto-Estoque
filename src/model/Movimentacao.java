package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "movimentacoes")
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movimentacao_id;
    @Column
    private int quantidade;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tipo_movimentacao_id", referencedColumnName = "tipo_movimentacao_id")
    private TipoMovimentacao tipoMovimentacao;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @OneToOne(mappedBy = "movimentacao")
    private List<Movimentacao> movimentacoes;

    public Movimentacao() {
    }

    public Movimentacao(int movimentacao_id, TipoMovimentacao tipoMovimentacao, Operador operador, Usuario usuario,
            Item item) {
        this.movimentacao_id = movimentacao_id;
        this.tipoMovimentacao = tipoMovimentacao;
        this.operador = operador;
        this.usuario = usuario;
        this.item = item;
    }

    public int getMovimentacao_id() {
        return movimentacao_id;
    }

    public void setMovimentacao_id(int movimentacao_id) {
        this.movimentacao_id = movimentacao_id;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador_id) {
        this.operador = operador_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario_id) {
        this.usuario = usuario_id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item_id) {
        this.item = item_id;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = Integer.parseInt(quantidade);
    }

    public int getQuantidade() {
        return this.quantidade;

    }

    @Override
    public String toString() {
        return "Tipo da movimentação: " + tipoMovimentacao
                + ", operador: " + operador + ", usuario: " + usuario + "," + getQuantidade() + item + "\n";
    }
}
