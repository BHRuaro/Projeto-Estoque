package controller;

import java.util.HashMap;

import model.Usuario;
import model.UsuarioDAO;
import view.UsuarioView;

public class UsuarioController {

    public static void init() {
        UsuarioView.init();
    }

    public static void goTo(HashMap<String, String> params) {
        int destino = Integer.parseInt(params.get("opcao"));

        switch (destino) {
            case 1 -> UsuarioController.register();
            // case 2 -> UsuarioController.list();
            // case 3 -> UsuarioController.search();
            // case 4 -> UsuarioController.update();
            // case 5 -> UsuarioController.remove();
            case 6 -> MainController.init();
            default -> throw new AssertionError();
        }
    }

    public static void register() {
        UsuarioView.register();
    }

    public static void insert(HashMap<String, String> params) {
        Usuario usuario = new Usuario();
        usuario.setNome(params.get("nome"));
        usuario.setCpf(params.get("cpf"));
        usuario.setEmail(params.get("email"));
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.add(usuario);

        UsuarioView.init();
    }

    // public static void list() {
    // UsuarioView.list();
    // }

    // public static void search() {
    // UsuarioView.search();
    // }

    // public static void remove() {
    // UsuarioView.remove();
    // }

    // public static void update() {
    // UsuarioView.update();
    // }
}
