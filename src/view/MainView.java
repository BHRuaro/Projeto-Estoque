package view;

import java.util.HashMap;

import javax.swing.JOptionPane;

import model.Operador;
import model.OperadorDAO;

/**
 *
 * @author bruno
 */
public class MainView {
    // Login nome + senha do operador
    // Menu com:
    // Cadastro de usuario (incluir, atualizar, buscar e deletar),
    // Cadastro de produto (incluir, atualizar, buscar e deletar),
    // Movimentacoes (entrada e saida de produtos para usuarios),
    // Historico (Usuario: inclusao/alterao/delecao, Produto:
    // -----------inclusao/alterao/delecao, Movimentacao: entrada e saida)
    // Sair do sistema

    // Operador operador = new Operador();
    // operador.setNome("Bruno");
    // operador.setSenha("123456");
    // operador.setCargo("Administrador");
    // operador.setData_contratacao(new java.sql.Date(System.currentTimeMillis()));
    // operador.setSalario((float) 1500.92);

    // OperadorDAO operadorDAO = new OperadorDAO();
    // operadorDAO.adiciona(operador);

    public static void init() {
        HashMap<String, String> parametros = new HashMap<>();
        int opcao = 0;
        String user, password;

        user = JOptionPane.showInputDialog("Digite o nome do usuário:");
        password = JOptionPane.showInputDialog("Digite a senha do usuário:");
        parametros.put("user", user);
        parametros.put("password", password);
        OperadorDAO.login(parametros);

        // opcao = Integer.parseInt(JOptionPane.showInputDialog(
        // "Escolha uma opção:\n1 - Cadastrar usuário\n2 - Cadastrar produto\n3 -
        // Movimentações\n4 - Histórico\n5 - Sair do sistema\n"));
    }

}