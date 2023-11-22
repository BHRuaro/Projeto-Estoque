package controller;

import java.util.HashMap;
import java.util.List;
import view.HistoricoView;
import model.Historico;
import model.HistoricoDAO;

public class HistoricoController {
    static HistoricoDAO historicoDAO = new HistoricoDAO();

    public static void init() {
        HistoricoView.init();
    }

    public static void goTo(HashMap<String, String> params) {
        int destino = Integer.parseInt(params.get("opcao"));

        switch (destino) {
            case 1 -> HistoricoController.listEntradas();
            case 2 -> HistoricoController.listSaidas();
            case 3 -> MainController.init();
            default -> HistoricoView.invalidOption();
        }
    }

    public static void listEntradas() {
        List<Historico> listaHistorico = historicoDAO.listEntradas();
        HistoricoView.listEntradas(listaHistorico);
    }

    public static void listSaidas() {
        List<Historico> listaHistorico = historicoDAO.listSaidas();
        HistoricoView.listSaidas(listaHistorico);
    }
}
