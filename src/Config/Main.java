package Config;

import java.util.HashMap;
import controller.MainController;

public class Main {

    public static HashMap<String, String> parameters = new HashMap<>();

    public static void main(String[] args) {
        MainController.init(parameters);
    }
}
