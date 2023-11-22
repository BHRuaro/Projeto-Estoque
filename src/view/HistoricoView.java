package view;

import java.util.HashMap;
import controller.HistoricoController;
import javax.swing.JOptionPane;
import model.Historico;
import java.util.List;
import model.TipoMovimentacao;

public class HistoricoView {
    static TipoMovimentacao tipoMovimentacao = new TipoMovimentacao();

    public static void init() {
        HashMap<String, String> parametros = new HashMap<>();

        int opcao = 0;

        opcao = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                        "1 - Visualizar Entradas\n2 - Visualizar Saídas\n3 - Voltar"));

        parametros.put("opcao", String.valueOf(opcao));

        HistoricoController.goTo(parametros);
    }

    public static void invalidOption() {
        JOptionPane.showMessageDialog(null, "Opção inválida");
        HistoricoView.init();
    }

    public static void listEntradas(List<Historico> listaHistorico) {
        String lista = "";
        for (Historico historico : listaHistorico) {
            lista += "Código: " + historico.getHistorico_id() + "\n";
            lista += "Data: " + historico.getData_movimentacao() + "\n";
            lista += "Tipo de Movimentação: " + historico.getTipoMovimentacao() + " - "
                    + tipoMovimentacao.getDescricao() + "\n";
            lista += "Item: " + historico.getItem() + "\n";
            lista += "Quantidade: " + historico.getQuantidade() + "\n";
            lista += "Operador: " + historico.getOperador() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, lista);

        HistoricoView.init();
    }

    public static void listSaidas(List<Historico> listaHistorico) {
        String lista = "";
        for (Historico historico : listaHistorico) {
            lista += "Código: " + historico.getHistorico_id() + "\n";
            lista += "Data: " + historico.getData_movimentacao() + "\n";
            lista += "Tipo de Movimentação: " + historico.getTipoMovimentacao() + " - "
                    + tipoMovimentacao.getDescricao() + "\n";
            lista += "Item: " + historico.getItem() + "\n";
            lista += "Quantidade: " + historico.getQuantidade() + "\n";
            lista += "Usuário: " + historico.getUsuario() + "\n";
            lista += "Operador: " + historico.getOperador() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, lista);

        HistoricoView.init();
    }
}
