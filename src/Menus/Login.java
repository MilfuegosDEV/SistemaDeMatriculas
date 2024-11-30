package Menus;

import Servicios.UserService;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

    public static void ShowMenu(UserService userService) {
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
            "Username:", username,
            "Password:", password
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                var user = userService.GetUser(username.getText());
                if (user != null && user.ValidatePassword(password.getText())) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + user.GetUsername(), "Login exitoso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
