package view;

import java.util.HashMap;
import javax.swing.JOptionPane;
import controller.MovimentacaoController;

public class MovimentacaoView {

    public static void init() {

        HashMap<String, String> parametros = new HashMap<>();
        int opcao = 0;

        opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1 - Entrada\n2 - Saída\n3 - Voltar"));

        parametros.put("opcao", String.valueOf(opcao));

        MovimentacaoController.goTo(parametros);
    }

    public static void invalidOption() {
        JOptionPane.showMessageDialog(null, "Opção inválida");
        MovimentacaoView.init();
    }

    public static void entrada() {
        HashMap<String, String> parametros = new HashMap<>();
        String codigo = JOptionPane.showInputDialog("Informe o código do item");
        parametros.put("codigo", codigo);
        String quantidade = JOptionPane.showInputDialog("Informe a quantidade");
        parametros.put("quantidade", quantidade);
        parametros.put("tipo", "1");
        parametros.put("operador", "1");

        MovimentacaoController.insert(parametros);
    }

    public static void saida() {
        HashMap<String, String> parametros = new HashMap<>();
        String usuario = JOptionPane.showInputDialog("Informe o código do usuário que está recebendo o item");
        parametros.put("usuario", usuario);
        String codigo = JOptionPane.showInputDialog("Informe o código do item");
        parametros.put("codigo", codigo);
        String quantidade = JOptionPane.showInputDialog("Informe a quantidade");
        parametros.put("quantidade", quantidade);
        parametros.put("tipo", "2");
        parametros.put("operador", "1");

        MovimentacaoController.insert(parametros);
    }
}
