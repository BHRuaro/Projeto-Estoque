package view;

import java.util.HashMap;

import javax.swing.JOptionPane;

import controller.UsuarioController;

public class UsuarioView {
    public static void init() {
        HashMap<String, String> parametros = new HashMap<>();
        int opcao = 0;

        opcao = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                        "1 - Cadastrar\n2 - listr\n3 - Buscar\n4- Atualizar\n5 - Remover\n6 - Voltar"));

        parametros.put("opcao", String.valueOf(opcao));

        UsuarioController.goTo(parametros);
    }

    public static void register() {
        HashMap<String, String> parametros = new HashMap<>();
        String nome = JOptionPane.showInputDialog("Informe o nome do usuário");
        parametros.put("nome", nome);
        String cpf = JOptionPane.showInputDialog("Informe o CPF do usuário");
        parametros.put("cpf", cpf);
        String email = JOptionPane.showInputDialog("Informe o email do usuário");
        parametros.put("email", email);

        UsuarioController.insert(parametros);
    }

}
