package view;

import javax.swing.JOptionPane;
import java.util.*;
import controller.UsuarioController;
import model.Usuario;

public class UsuarioView {
    public static void init() {
        HashMap<String, String> parametros = new HashMap<>();
        int opcao = 0;

        opcao = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                        "1 - Cadastrar\n2 - Listar\n3 - Buscar\n4 - Atualizar\n5 - Remover\n6 - Voltar"));

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

    public static void list(String lista) {
        JOptionPane.showMessageDialog(null, lista.toString());

        UsuarioView.init();
    }

    public static void requestSearch() {
        HashMap<String, String> parametros = new HashMap<>();
        int opcao = 0;
        opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1 - Buscar por código\n2 - Buscar por nome\n3 - Buscar por CPF\n4 - Buscar por email\n5 - Voltar"));

        switch (opcao) {
            case 1:
                parametros.put("opcao", String.valueOf(opcao));
                String codigo = JOptionPane.showInputDialog("Informe o código do usuário");
                parametros.put("codigo", codigo);
                UsuarioController.search(parametros);
                break;
            case 2:
                parametros.put("opcao", String.valueOf(opcao));
                String nome = JOptionPane.showInputDialog("Informe o nome do usuário");
                parametros.put("nome", nome);
                UsuarioController.search(parametros);
                break;
            case 3:
                parametros.put("opcao", String.valueOf(opcao));
                String cpf = JOptionPane.showInputDialog("Informe o CPF do usuário");
                parametros.put("cpf", cpf);
                UsuarioController.search(parametros);
                break;
            case 4:
                parametros.put("opcao", String.valueOf(opcao));
                String email = JOptionPane.showInputDialog("Informe o email do usuário");
                parametros.put("email", email);
                UsuarioController.search(parametros);
                break;
            case 5:
                UsuarioView.init();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                UsuarioView.requestSearch();
                break;
        }

    }

    public static HashMap<String, String> update() {
        HashMap<String, String> parametros = new HashMap<>();

        int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o código do usuário que deseja atualizar os dados:\n(Pode ser visualizado na lista ou na busca)"));

        parametros.put("codigo", String.valueOf(codigo));

        String nome = JOptionPane.showInputDialog("Informe o nome do usuário");
        parametros.put("nome", nome);
        String cpf = JOptionPane.showInputDialog("Informe o CPF do usuário");
        parametros.put("cpf", cpf);
        String email = JOptionPane.showInputDialog("Informe o email do usuário");
        parametros.put("email", email);

        return parametros;
    }

    public static HashMap<String, String> remove() {
        HashMap<String, String> parametros = new HashMap<>();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o código do usuário que deseja remover:\n(Pode ser visualizado na lista ou na busca)"));

        parametros.put("codigo", String.valueOf(codigo));

        return parametros;
    }

    public static void invalidOption() {
        JOptionPane.showMessageDialog(null, "Opção inválida");
        UsuarioView.init();
    }
}
