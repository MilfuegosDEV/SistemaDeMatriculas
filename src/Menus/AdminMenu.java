package Menus;

import Entidades.*;
import Servicios.PasswordService;
import Servicios.UserService;
import javax.swing.*;

public class AdminMenu {

    UserService userService;

    public AdminMenu(UserEntity user, UserService userService) {
        this.userService = userService;
        String[] Options = {"USUARIOS", "CURSOS", "SALIR"};
        do {
            int option = JOptionPane.showOptionDialog(null, "Bienvenido " + user.GetUsername(), "Sistema de matrículas\nSeleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
            switch (option) {
                case 0 ->
                    ShowUsers();
                case 1 -> {
                }
                case 2 -> {
                    return;
                }
                default -> {
                }
            }
        } while (true);
    }

    private void ShowUsers() {
        String[][] users = this.userService.GetUsers();
        String[] cols = {"ID", "USERNAME", "PASSWORD", "NOMBRE", "APELLIDO", "ROL"};

        String[] options = {"AGREGAR", "SALIR"};

        JTable table = new JTable(users, cols);
        OUTER:
        do {
            int option = JOptionPane.showOptionDialog(null, new JScrollPane(table), "Usuarios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (option) {
                case 0 ->
                    AddUser();
                case 1 -> {
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
        JComboBox<String> rol = new JComboBox<>(new String[]{"Admin", "Profesor", "Estudiante"});

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

            PasswordService passwordService = new PasswordService();
            String testingpassword = String.valueOf(password.getPassword());
            passwordService.PasswordVerifier(testingpassword);
            //La verificacion sirve pero no guarda la contraseña modificada

            UserEntity user = new UserEntity(username.getText(), testingpassword, nombre.getText(), apellido.getText(), role);
            //new String(password.getPassword())
            this.userService.AddUser(user);

        }
    }

    public UserService close() {
        return this.userService;
    }

}
