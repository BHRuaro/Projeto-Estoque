package controller;

import view.ItemView;
import java.util.HashMap;
import model.Item;
import model.ItemDAO;
import java.util.Arrays;
import java.util.List;

public class ItemController {
    private static ItemDAO itemDAO = new ItemDAO();

    public static void init() {
        ItemView.init();
    }

    public static void goTo(HashMap<String, String> params) {
        int destino = Integer.parseInt(params.get("opcao"));

        switch (destino) {
            case 1 -> ItemController.register();
            case 2 -> ItemController.list();
            case 3 -> ItemController.requestSearch();
            case 4 -> ItemController.update();
            case 5 -> ItemController.remove();
            case 6 -> MainController.init();
            default -> ItemView.invalidOption();
        }
    }

    public static void register() {
        ItemView.register();
    }

    public static void insert(HashMap<String, String> params) {
        Item item = new Item();
        item.setNome(params.get("nome"));
        item.setDescricao(params.get("descricao"));
        item.setPreco(params.get("preco"));
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.add(item);

        ItemView.init();
    }

    public static void list() {
        ItemDAO itemDAO = new ItemDAO();
        ItemView.list(itemDAO.list());
    }

    public static void requestSearch() {
        ItemView.requestSearch();
    }

    public static void search(HashMap<String, String> params) {
        int opcao = Integer.parseInt(params.get("opcao"));
        Item item = null;
        switch (opcao) {
            case 1:
                item = itemDAO.find(Integer.parseInt(params.get("codigo")));
                ItemView.list(Arrays.asList(item));
                break;
            case 2:
                List<Item> listaItemNome = itemDAO.searchName(params.get("nome"));
                ItemView.list(listaItemNome);
                break;
            case 3:
                List<Item> listaItemDesc = itemDAO.searchDescricao(params.get("descricao"));
                ItemView.list(listaItemDesc);
                break;
            case 4:
                ItemView.init();
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void update() {

        HashMap<String, String> parametros = new HashMap<>();
        parametros = ItemView.update();

        Item item = new Item();
        item.setItem_id(Integer.parseInt(parametros.get("codigo")));
        item.setNome(parametros.get("nome"));
        item.setDescricao(parametros.get("descricao"));
        item.setPreco(parametros.get("preco"));
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.update(item);

        ItemView.init();
    }

    public static void remove() {
        HashMap<String, String> parametros = new HashMap<>();

        parametros = ItemView.remove();

        int item_id = Integer.parseInt(parametros.get("codigo"));
        Item item = itemDAO.find(item_id);
        if (item != null) {
            itemDAO.remove(item);
        }

        ItemView.init();
    }
}
