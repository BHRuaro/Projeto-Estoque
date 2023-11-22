package controller;

import java.util.HashMap;
import view.MovimentacaoView;
import model.ItemDAO;
import model.Movimentacao;
import model.MovimentacaoDAO;
import model.Operador;
import model.OperadorDAO;
import model.TipoMovimentacao;
import model.TipoMovimentacaoDAO;
import model.UsuarioDAO;
import model.Usuario;
import model.Item;

public class MovimentacaoController {

    public static void init() {
        MovimentacaoView.init();
    }

    public static void goTo(HashMap<String, String> params) {
        int destino = Integer.parseInt(params.get("opcao"));

        switch (destino) {
            case 1 -> MovimentacaoController.entrada();
            case 2 -> MovimentacaoController.saida();
            case 3 -> MainController.init();
            default -> MovimentacaoView.invalidOption();
        }
    }

    public static void entrada() {
        MovimentacaoView.entrada();
    }

    public static void saida() {
        MovimentacaoView.saida();
    }

    public static void insert(HashMap<String, String> params) {
        Movimentacao movimentacao = new Movimentacao();

        OperadorDAO operadorDAO = new OperadorDAO();
        Operador operador = operadorDAO.find(Integer.parseInt(params.get("operador")));
        movimentacao.setOperador(operador);

        TipoMovimentacaoDAO tipoMovimentacaoDAO = new TipoMovimentacaoDAO();
        TipoMovimentacao tipoMovimentacao = tipoMovimentacaoDAO.find(Integer.parseInt(params.get("tipo")));
        movimentacao.setTipoMovimentacao(tipoMovimentacao);

        ItemDAO itemDAO = new ItemDAO();
        Item item = itemDAO.find(Integer.parseInt(params.get("codigo")));

        if (tipoMovimentacao.getTipo_movimentacao_id() == 1) {
            item.setQuantidade(Integer.toString(item.getQuantidade() + movimentacao.getQuantidade()));
        } else {
            item.setQuantidade(Integer.toString(item.getQuantidade() - movimentacao.getQuantidade()));
        }

        movimentacao.setItem(item);

        movimentacao.setQuantidade(params.get("quantidade"));

        if (params.get("usuario") != null) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.find(Integer.parseInt(params.get("usuario")));
            movimentacao.setUsuario(usuario);
        }

        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
        movimentacaoDAO.add(movimentacao);

    }
}