/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class OperadorView {
    static HashMap<String, String> parameters = new HashMap<>();

    public static HashMap<String, String> requestLogin() {
        String user, password;

        user = JOptionPane.showInputDialog("Digite o nome do usuário:");
        password = JOptionPane.showInputDialog("Digite a senha do usuário:");
        parameters.put("user", user);
        parameters.put("password", password);

        return parameters;
    }
}
