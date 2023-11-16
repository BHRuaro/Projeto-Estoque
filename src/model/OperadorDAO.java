package model;

import java.util.HashMap;
import java.util.List;
import jakarta.persistence.EntityManager;
import javax.swing.JOptionPane;

public class OperadorDAO {
    private final DAO<Operador> dao;
    private EntityManager em;

    public OperadorDAO() {
        this.em = JpaUtil.getEmPostgres();
        this.dao = new DAO<Operador>(em, Operador.class);
    }

    public void add(Operador operador) {
        this.dao.add(operador);
    }

    public void remove(Operador operador) {
        this.dao.remove(operador);
    }

    public Operador update(Operador operador) {
        operador = this.dao.update(operador);
        return operador;
    }

    public List<Operador> list() {
        return this.dao.list();
    }

    public Operador busca(Integer id) {
        return dao.find(id);
    }

    public void removeAll() {
        this.em.getTransaction().begin();
        this.em.createQuery("delete from operador").executeUpdate();
        this.em.flush();
        this.em.getTransaction().commit();
    }

    public static boolean login(HashMap<String, String> parameters) {
        String user = parameters.get("user");
        String password = parameters.get("password");
        OperadorDAO operadorDAO = new OperadorDAO();
        List<Operador> operadores = operadorDAO.list();
        for (Operador operador : operadores) {
            if (operador.getNome().equals(user) && operador.getSenha().equals(password)) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso", "LOGADO!!", 1);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Verifique os campos Usuário e Senha", "Erro ao logar", 2);
        return false;
    }
}