package Menus;

import Entidades.*;
import Servicios.CursoService;
import Servicios.PasswordService;
import Servicios.UserService;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class AdminMenu {

    UserService userService;
    CursoService cursoService = new CursoService();
    PasswordService passwordService = new PasswordService();

    public AdminMenu(UserEntity user, UserService userService) {
        this.userService = userService;
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
        JComboBox<String> rol = new JComboBox<>(users[1]);

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

        if (option == JOptionPane.OK_OPTION) {
            RoleEntity role;
            if (rol.getSelectedItem().equals("Admin")) {
                role = this.userService.Admin;
            } else {
                role = this.userService.Student;
            }

            UserEntity user = new UserEntity(username.getText(), passwordService.PasswordVerifier(String.valueOf(password.getPassword())), nombre.getText(), apellido.getText(), role);
            this.userService.AddUser(user);

        }
    }
    
    private void EditUser(){
        String[][] users = this.userService.GetUsers();
        String [] usernames = new String[users.length];
        for(int i = 0; i < users.length; i++){
            usernames[i] = users[i][1];
        }    

        JComboBox<String> currentusers = new JComboBox<>(usernames);

        Object[] message = {
            "Usuarios", currentusers
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Editar usuario", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            for(int i = 0; i < users.length; i++){
                if(currentusers.getSelectedItem().equals(users[i][1])){
                    UserEntity user = userService.GetUser(users[i][1]);
                    
                    JTextField username = new JTextField();
                    JTextField password = new JTextField();
                    JTextField nombre = new JTextField();
                    JTextField apellido = new JTextField();
                    JComboBox<String> rol = new JComboBox<>(new String[]{"Admin", "Profesor", "Estudiante"});
                    Object[] editmessage = {
                        "Username actual: "+user.username,
                        "Nuevo Username:", username,
                        "\n",
                        "Contraseña actual: "+user.GetPassword(),
                        "Nueva contraseña: ", password,
                        "\n",
                        "Nombre actual: "+user.name,
                        "Nuevo nombre:", nombre,
                        "\n",
                        "Apellido actual: "+user.lastname,
                        "Nuevo apellido:", apellido,
                        "\n",
                        "Rol actual: "+user.role,
                        "Nuevo rol", rol
                    };
                    int editoption = JOptionPane.showConfirmDialog(null, editmessage, "Editar usuario", JOptionPane.OK_CANCEL_OPTION);
            
                    if (option == JOptionPane.OK_OPTION) {
                        if(!username.getText().isEmpty()){
                            user.username = username.getText();
                        }
                        if(!password.getText().isEmpty()){
                            //user. = passwordService.PasswordVerifier(password.getText());

                        }
                        if(!nombre.getText().isEmpty()){
                            user.name = nombre.getText();
                        }
                        if(!apellido.getText().isEmpty()){
                            user.lastname = apellido.getText();
                        }
                        RoleEntity newrole;
                        if (rol.getSelectedItem().equals("Admin")) {
                        newrole = this.userService.Admin;
                        } if (rol.getSelectedItem().equals("Profesor")){
                            newrole = this.userService.Teacher;
                        } else {
                        newrole = this.userService.Student;
                        }
                        user.role = newrole;

                    }
                    //password, id are protected;
                }     
            }    
        }
    
    }
    private void ShowCourses() {
        String[][] courses = this.cursoService.GetCursos();
        String[] cols = {"ID", "NOMBRE", "GRADO", "PROFESOR"};

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
        JTextField id = new JTextField();
        JTextField nombre = new JTextField();
        JTextField grado = new JTextField();
        Object profesor = cursoService.GetCurso(789);
        JComboBox<String> rol = new JComboBox<>(new String[]{"Admin", "Profesor", "Estudiante"});
        
        Object[] message = {
            "ID:", id,
            "Nombre:", nombre,
            "Grado:", grado,
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Agregar curso", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            RoleEntity role;
            if (rol.getSelectedItem().equals("Admin")) {
                role = this.userService.Admin;
            } else {
                role = this.userService.Student;
            }

            UserEntity user4 = new UserEntity("teacher", "123456", "", "", userService.Teacher);
            CursoEntity curso3 = new CursoEntity(777, 2, "Matemática", user4);


            //CursoEntity curso = new CursoEntity(id.getText(), grado.getText(), nombre.getText(), user4.GetUsername());
            this.cursoService.AddCurso(curso3);
        }    
    }    

    public UserService close() {
        return this.userService;
    }

}
