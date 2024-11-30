package Menus;

import Entidades.UserEntity;
import Servicios.UserService;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AuthMenu {

    public static void Login(UserService userService) {
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();
        Object[] message = {
            "Username:", username,
            "Password:", password
        };

        do {
            int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                if (username.getText().isEmpty() || password.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    UserEntity user = userService.GetUser(username.getText());
                    if (user != null && user.ValidatePassword(password.getText())) {
                        if (user.role.GetRole().equals("Admin")) {
                            JOptionPane.showMessageDialog(null, "Bienvenido " + user.username, "Sistema de matrículas", JOptionPane.INFORMATION_MESSAGE);
                            AdminMenu adminMenu = new AdminMenu(user, userService);
                            adminMenu.close();
                        } else if (user.role.GetRole().equals("Estudiante")) {
                            JOptionPane.showMessageDialog(null, "Bienvenido " + user.username, "Sistema de matrículas", JOptionPane.INFORMATION_MESSAGE);
                            StudentMenu studentMenu = new StudentMenu(user);
                        } else if (user.role.GetRole().equals("Profesor")) {
                            JOptionPane.showMessageDialog(null, "Bienvenido " + user.username, "Sistema de matrículas", JOptionPane.INFORMATION_MESSAGE);
                            ProfesorMenu profesorMenu = new ProfesorMenu(user);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } else {
                break;
            }
        } while (true);
    }

    public static void Logout() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }
}
