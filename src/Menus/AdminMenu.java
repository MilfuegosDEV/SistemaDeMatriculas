package Menus;

import Entidades.*;
import Servicios.CursoService;
import Servicios.PasswordService;
import Servicios.UserService;
import javax.swing.*;

public class AdminMenu {

    UserService userService;
    CursoService cursoService;
    PasswordService passwordService = new PasswordService();

    public AdminMenu(UserEntity user, UserService userService, CursoService cursoService) {
        this.userService = userService;
        this.cursoService = cursoService;
        String[] Options = {"USUARIOS", "CURSOS", "SALIR"};
        do {
            int option = JOptionPane.showOptionDialog(null, "Bienvenido " + user.GetUsername(), "Sistema de matrículas\nSeleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
            switch (option) {
                case 0 ->
                    ShowUsers();
                case 1 -> {
                    ShowCourses();
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
        String[] options = {"AGREGAR", "EDITAR", "SALIR"};

        JTable table = new JTable(users, cols);
        OUTER:
        do {
            int option = JOptionPane.showOptionDialog(null, new JScrollPane(table), "Usuarios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (option) {
                case 0 ->
                    AddUser();
                case 1 ->
                    EditUser();
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
        JComboBox<String> rol = new JComboBox<>(new String[]{"Admin", "Profesor", "Estudiante"});

        Object[] message = {
            "Username:", username,
            "Password:", password,
            "Nombre:", nombre,
            "Apellido:", apellido,
            "Rol:", rol
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Agregar usuario", JOptionPane.OK_CANCEL_OPTION);
        if (this.userService.GetUser(username.getText()) != null) {
            JOptionPane.showMessageDialog(null, "Error el nombre de usuario ya esta en uso", "Usuario existe", JOptionPane.ERROR_MESSAGE);
            return;

        }

        if (option == JOptionPane.OK_OPTION) {
            RoleEntity role;
            if (rol.getSelectedItem().equals("Admin")) {
                role = this.userService.Admin;
            } else if (rol.getSelectedItem().equals("Profesor")) {
                role = this.userService.Teacher;

            } else {
                role = this.userService.Student;
            }


            UserEntity user = new UserEntity(username.getText(), String.valueOf(password.getPassword()), nombre.getText(), apellido.getText(), role);
            this.userService.CreateUser(user);

        }
    }

    private void EditUser() {
        String[][] users = this.userService.GetUsers();
        String[] usernames = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            usernames[i] = users[i][1];
        }

        JComboBox<String> currentusers = new JComboBox<>(usernames);

        Object[] message = {
            "Usuarios", currentusers
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Editar usuario", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            for (int i = 0; i < users.length; i++) {
                if (currentusers.getSelectedItem().equals(users[i][1])) {
                    UserEntity user = userService.GetUser(users[i][1]);

                    JTextField nombre = new JTextField(user.name);
                    JTextField apellido = new JTextField(user.lastname);
                    JComboBox<String> rol = new JComboBox<>(new String[]{"Admin", "Profesor", "Estudiante"});
                    Object[] editmessage = {
                        "Nombre: ", nombre,
                        "Apellido: ", apellido,
                        "Rol: ", rol


                    };
                    JOptionPane.showConfirmDialog(null, editmessage, "Editar usuario", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        if (!nombre.getText().isEmpty()) {
                            user.name = nombre.getText();
                        }
                        if (!apellido.getText().isEmpty()) {
                            user.lastname = apellido.getText();
                        }

                        switch ((String) rol.getSelectedItem()) {
                            case "Admin":
                                user.role = this.userService.Admin;
                                break;
                            case "Profesor":
                                user.role = this.userService.Teacher;
                                break;
                            default:
                                user.role = this.userService.Student;
                        }

                    }
                    //password, id are protected;
                }
            }
        }

    }

    private void ShowCourses() {
        String[][] courses = this.cursoService.ShowInfo();
        String[] cols = {"ID", "CURSO", "GRADO", "PROFESOR", "MATRICULADOS"};

        String[] options = {"AGREGAR", "SALIR"};

        JTable table = new JTable(courses, cols);
        OUTER:
        do {
            int option = JOptionPane.showOptionDialog(null, new JScrollPane(table), "Usuarios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (option) {
                case 0 ->
                    AddCourse();
                case 1 -> {
                    break OUTER;
                }
                default -> {
                }
            }
        } while (true);

    }

    private void AddCourse() {
        JTextField nombre = new JTextField();
        JTextField grado = new JTextField();
        JComboBox<String> profesores = new JComboBox<>(userService.FilterByRole(userService.Teacher).toArray(new String[0]));


        Object[] message = {
            "Nombre:", nombre,
            "Grado:", grado,
            "Profesor:", profesores

        };
        int option = JOptionPane.showConfirmDialog(null, message, "Agregar curso", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            UserEntity profesor = this.userService.GetUser((String) profesores.getSelectedItem());
            CursoEntity curso = new CursoEntity((int) Integer.parseInt(grado.getText()), nombre.getText(), profesor);
            
            cursoService.AddCurso(curso);
        }
    }

    public UserService close() {
        return this.userService;
    }

}
