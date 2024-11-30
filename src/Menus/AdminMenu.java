package Menus;

import Entidades.*;
import Servicios.UserService;
import javax.swing.*;

public class AdminMenu {

    UserService userService;

    public AdminMenu(UserEntity user, UserService userService) {
        do {
            this.userService = userService;
            String[] Options = {"USUARIOS", "CURSOS", "SALIR"};
            JOptionPane.showOptionDialog(null, "Bienvenido " + user.GetUsername(), "Sistema de matrículas\nSeleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);

            if (Options[0].equals("USUARIOS")) {
                ShowUsers();
            } else if (Options[1].equals("CURSOS")) {
                // ShowCourses();
            } else if (Options[2].equals("SALIR")) {
                break;
            }

        } while (true);
    }

    private void ShowUsers() {
        String[][] users = this.userService.GetUsers();
        String[] cols = {"ID", "USERNAME", "PASSWORD", "NOMBRE", "APELLIDO", "ROL"};

        String[] options = {"AGREGAR", "EDITAR", "SALIR"};

        JTable table = new JTable(users, cols);
        OUTER:
        do {
            int option = JOptionPane.showOptionDialog(null, new JScrollPane(table), "Usuarios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (option) {
                case 0 ->
                    AddUser();
                case 1 -> {
                }
                case 2 -> {
                    break OUTER;
                }
                default -> {
                }
            }
            // EditUser();
                    } while (true);


    }

    private void AddUser() {
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JTextField nombre = new JTextField();
        JTextField apellido = new JTextField();
        JComboBox<String> rol = new JComboBox<>(new String[]{"Admin", "Estudiante"});

        Object[] message = {
            "Username:", username,
            "Password:", password,
            "Nombre:", nombre,
            "Apellido:", apellido,
            "Rol:", rol
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Agregar usuario", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            RoleEntity role;
            if (rol.getSelectedItem().equals("Admin")) {
                role = this.userService.Admin;
            } else {
                role = this.userService.Student;
            }

            UserEntity user = new UserEntity(username.getText(), new String(password.getPassword()), nombre.getText(), apellido.getText(), role);
            this.userService.AddUser(user);

        }
    }

    public void close() {

    }

}
