package Config;

import java.util.HashMap;
import controller.MainController;

public class Main {

    public static HashMap<String, String> parametros = new HashMap<>();

    public static void main(String[] args) {
        MainController.init(parametros);
    }
}
