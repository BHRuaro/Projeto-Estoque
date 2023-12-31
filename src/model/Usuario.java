package model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_id;
    @Column
    private String cpf;
    @Column
    private String nome;
    @Column
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Movimentacao> movimentacoes;

    public Usuario() {
    }

    public Usuario(int usuario_id, String nome, String cpf, String email) {
        this.usuario_id = usuario_id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;

    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;

    }

    @Override
    public String toString() {
        return "Código: " + this.usuario_id + "\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nEmail: " + this.email
                + "\n";
    }
}
