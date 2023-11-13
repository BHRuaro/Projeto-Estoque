package view;

import controller.OperadorController;
import controller.MainController;
import java.util.HashMap;
import javax.swing.JOptionPane;

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
    // Relatorios: Usuario e produto
    // Sair do sistema

    // Operador operador = new Operador();
    // operador.setNome("Bruno");
    // operador.setSenha("123456");
    // operador.setCargo("Administrador");
    // operador.setData_contratacao(new java.sql.Date(System.currentTimeMillis()));
    // operador.setSalario((float) 1500.92);
    // OperadorDAO operadorDAO = new OperadorDAO();
    // operadorDAO.adiciona(operador);

    public static void login() {
        do {
        } while (OperadorController.validateLogin() == false);
    }

    public static void init() {
        int destino = 0;
        HashMap<String, String> parameters = new HashMap<>();

        destino = Integer.parseInt(JOptionPane.showInputDialog(
                "Escolha uma opção:\n1 - Usuários\n2 - Itens\n3 - Movimentações\n4 - Histórico\n5 - Sair do sistema\n(Informe uma opção)"));

        parameters.put("destino", String.valueOf(destino));

        MainController.goTo(parameters);
    }

}
