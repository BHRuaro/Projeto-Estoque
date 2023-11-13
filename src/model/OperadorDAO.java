package model;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import javax.swing.JOptionPane;

public class OperadorDAO {
    private final DAO<Operador> dao;
    private EntityManager em;
    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class.getName());

    public OperadorDAO() {
        this.em = JpaUtil.getEmPostgres();
        this.dao = new DAO<Operador>(em, Operador.class);
    }

    public void adiciona(Operador operador) {
        this.dao.adiciona(operador);
    }

    public void remove(Operador operador) {
        this.dao.remove(operador);
    }

    public Operador atualiza(Operador operador) {
        operador = this.dao.atualiza(operador);
        return operador;
    }

    public List<Operador> lista() {
        return this.dao.lista();
    }

    public Operador busca(Integer id) {
        return dao.busca(id);
    }

    public List<Operador> buscaPorNome(String nome) {
        List<Operador> result = null;
        try {
            Query query = em.createQuery("select x from operador x where x.nome like :parametro ");
            query.setParameter("parametro", "%" + nome + "%");
            result = query.getResultList();
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
        }
        return result;
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
        List<Operador> operadores = operadorDAO.lista();
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