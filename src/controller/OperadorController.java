/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import model.OperadorDAO;
import view.OperadorView;

/**
 *
 * @author bruno
 */
public class OperadorController {
    static HashMap<String, String> parameters = new HashMap<>();

    public static boolean validateLogin() {

        parameters = OperadorView.requestLogin();

        if (OperadorDAO.login(parameters)) {
            return true;
        } else {
            return false;
        }
    }
}
