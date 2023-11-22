package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private float preco_unitario;
    @Column
    private int quantidade_estoque;

    @OneToMany(mappedBy = "item")
    private java.util.List<Movimentacao> movimentacoes;

    public Item() {
    }

    public Item(int item_id, String nome, String descricao, String preco_unitario, String quantidade_estoque) {
        this.item_id = item_id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_unitario = Float.parseFloat(preco_unitario);
        this.quantidade_estoque = Integer.parseInt(quantidade_estoque);
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int usuario_id) {
        this.item_id = usuario_id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;

    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;

    }

    public void setPreco(String preco_unitario) {
        this.preco_unitario = Float.parseFloat(preco_unitario);
    }

    public float getPreco() {
        return this.preco_unitario;

    }

    public void setQuantidade(String quantidade_estoque) {
        this.quantidade_estoque = Integer.parseInt(quantidade_estoque);
    }

    public int getQuantidade() {
        return this.quantidade_estoque;

    }

    @Override
    public String toString() {
        return "Código:" + this.item_id + "\nNome:" + this.nome + "\nDescrição:" + this.descricao + "\nPreço:"
                + this.preco_unitario + "\nQuantidade:" + this.quantidade_estoque + "\n\n";
    }
}
