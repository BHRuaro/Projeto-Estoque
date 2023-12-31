package controller;

import java.util.*;
import java.util.stream.Collectors;

import model.Usuario;
import model.UsuarioDAO;
import view.UsuarioView;

public class UsuarioController {
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static void init() {
        UsuarioView.init();
    }

    public static void goTo(HashMap<String, String> params) {
        int destino = Integer.parseInt(params.get("opcao"));

        switch (destino) {
            case 1 -> UsuarioController.register();
            case 2 -> UsuarioController.list();
            case 3 -> UsuarioController.requestSearch();
            case 4 -> UsuarioController.update();
            case 5 -> UsuarioController.remove();
            case 6 -> MainController.init();
            default -> UsuarioView.invalidOption();
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

    public static void list() {
        List<Usuario> listaUsuario = usuarioDAO.list();
        StringBuilder lista = new StringBuilder();
        listaUsuario.stream().sorted(Comparator.comparing(Usuario::getUsuario_id)).forEach(usuario -> {
            lista.append(usuario);
        });
        UsuarioView.list(lista.toString());
    }

    public static void requestSearch() {
        UsuarioView.requestSearch();
    }

    public static void search(HashMap<String, String> params) {
        int opcao = Integer.parseInt(params.get("opcao"));
        Usuario usuario = null;
        switch (opcao) {
            case 1:
                usuario = usuarioDAO.find(Integer.parseInt(params.get("codigo")));
                UsuarioView.list(usuario.toString());
                break;
            case 2:
                List<Usuario> listaUsuarioNome = usuarioDAO.searchName(params.get("nome"));
                String listaUsuarioNomeStr = listaUsuarioNome.stream()
                        .map(Usuario::toString)
                        .collect(Collectors.joining("\n"));
                UsuarioView.list(listaUsuarioNomeStr);
                break;
            case 3:
                List<Usuario> listaUsuarioCPF = usuarioDAO.searchCPF(params.get("cpf"));
                String listaUsuarioCPFStr = listaUsuarioCPF.stream()
                        .map(Usuario::toString)
                        .collect(Collectors.joining("\n"));
                UsuarioView.list(listaUsuarioCPFStr);
                break;
            case 4:
                List<Usuario> listaUsuarioEmail = usuarioDAO.searchEmail(params.get("email"));
                String listaUsuarioEmailStr = listaUsuarioEmail.stream()
                        .map(Usuario::toString)
                        .collect(Collectors.joining("\n"));
                UsuarioView.list(listaUsuarioEmailStr);
                break;
            case 5:
                UsuarioView.init();
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void update() {
        HashMap<String, String> parametros = new HashMap<>();

        parametros = UsuarioView.update();

        Usuario usuario = new Usuario();
        usuario.setUsuario_id(Integer.parseInt(parametros.get("codigo")));
        usuario.setNome(parametros.get("nome"));
        usuario.setCpf(parametros.get("cpf"));
        usuario.setEmail(parametros.get("email"));
        usuarioDAO.update(usuario);

        UsuarioView.init();
    }

    public static void remove() {
        HashMap<String, String> parametros = new HashMap<>();

        parametros = UsuarioView.remove();

        int usuario_id = Integer.parseInt(parametros.get("codigo"));
        Usuario usuario = usuarioDAO.find(usuario_id);
        if (usuario != null) {
            usuario = usuarioDAO.merge(usuario);
            usuarioDAO.remove(usuario);
        }

        UsuarioView.init();
    }

}
