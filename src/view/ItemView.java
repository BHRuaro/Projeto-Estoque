package view;

import java.util.HashMap;
import javax.swing.JOptionPane;
import controller.ItemController;
import model.Item;
import java.util.List;

public class ItemView {

    public static void init() {
        HashMap<String, String> parametros = new HashMap<>();
        int opcao = 0;

        opcao = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                        "1 - Cadastrar\n2 - Listar\n3 - Buscar\n4 - Atualizar\n5 - Remover\n6 - Voltar"));

        parametros.put("opcao", String.valueOf(opcao));

        ItemController.goTo(parametros);
    }

    public static void register() {
        HashMap<String, String> parametros = new HashMap<>();
        String nome = JOptionPane.showInputDialog("Informe o nome do item");
        parametros.put("nome", nome);
        String descricao = JOptionPane.showInputDialog("Informe a descrição do item");
        parametros.put("descricao", descricao);
        String preco = JOptionPane.showInputDialog("Informe o preço do item");
        parametros.put("preco", preco);

        ItemController.insert(parametros);
    }

    public static void list(List<Item> listaItem) {
        String lista = "";
        for (Item item : listaItem) {
            lista += item;
        }
        JOptionPane.showMessageDialog(null, lista);

        ItemView.init();
    }

    public static void requestSearch() {
        HashMap<String, String> parametros = new HashMap<>();
        int opcao = 0;
        opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1 - Buscar por código\n2 - Buscar por nome\n3 - Buscar por descrição\n4 - Voltar"));

        switch (opcao) {
            case 1:
                parametros.put("opcao", String.valueOf(opcao));
                String codigo = JOptionPane.showInputDialog("Informe o código do item");
                parametros.put("codigo", codigo);
                ItemController.search(parametros);
                break;
            case 2:
                parametros.put("opcao", String.valueOf(opcao));
                String nome = JOptionPane.showInputDialog("Informe o nome do item");
                parametros.put("nome", nome);
                ItemController.search(parametros);
                break;
            case 3:
                parametros.put("opcao", String.valueOf(opcao));
                String descricao = JOptionPane.showInputDialog("Informe a descrição do item");
                parametros.put("descricao", descricao);
                ItemController.search(parametros);
                break;
            case 4:
                ItemView.init();
                break;
            default:
                throw new AssertionError();
        }
    }

    public static HashMap<String, String> update() {
        HashMap<String, String> parametros = new HashMap<>();
        String codigo = JOptionPane.showInputDialog("Informe o código do item");
        parametros.put("codigo", codigo);
        String nome = JOptionPane.showInputDialog("Informe o nome do item");
        parametros.put("nome", nome);
        String descricao = JOptionPane.showInputDialog("Informe a descrição do item");
        parametros.put("descricao", descricao);
        String preco = JOptionPane.showInputDialog("Informe o preço do item");
        parametros.put("preco", preco);

        return parametros;
    }

    public static HashMap<String, String> remove() {
        HashMap<String, String> parametros = new HashMap<>();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o código do item que deseja remover:\n(Pode ser visualizado na lista ou na busca)"));

        parametros.put("codigo", String.valueOf(codigo));

        return parametros;
    }

    public static void invalidOption() {
        JOptionPane.showMessageDialog(null, "Opção inválida");
        ItemView.init();
    }
}