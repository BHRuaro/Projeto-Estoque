/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import view.MainView;

/**
 *
 * @author bruno
 */
public class MainController {

    public static void login() {
        MainView.login();
        init();
    }

    public static void init() {
        MainView.init();
    }

    public static void goTo(HashMap<String, String> parametros) {
        int destino = Integer.parseInt(parametros.get("destino"));

        switch (destino) {
            case 1 -> UsuarioController.init();
            // case 2 -> ItemController.register();
            // case 3 -> MovimentacaoController.register();
            // case 4 -> HistoricoController.register();
            case 5 -> System.exit(0);
            default -> throw new AssertionError();
        }
    }
}
