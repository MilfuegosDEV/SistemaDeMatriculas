//Clase contenedora de métodos de uso exclusivo para la autentificación del rol del usuario y mostrar su respectivo menú.
package Menus;

import Entidades.UserEntity;
import Servicios.CursoService;
import Servicios.UserService;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AuthMenu {

    //Objetos establecidos para utilizar información ya existente de ambos tipos.
    UserService userService;
    CursoService cursoService;

    public AuthMenu(UserService userService, CursoService cursoService) {
        this.userService = userService;
        this.cursoService = cursoService;

    }

    //Método para inicar sesión y determinar si es un usuario existente para iniciar sesión.
    public void Login() {

        boolean loggedIn = false;

        while (!loggedIn) {
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
                    //Una vez se identifique como un usuario existente, la información que contiene implica los detalles que se desplegan.
                    UserEntity user = this.userService.GetUser(username.getText());
                    if (user != null && user.ValidatePassword(password.getText())) {
                        loggedIn = true;
                        //Estructura condicional switch llamando a la clase de menú según el tipo de rol.
                        switch (user.role.GetRole()) {
                            case "Admin" -> {
                                JOptionPane.showMessageDialog(null, "Bienvenido " + user.username, "Sistema de matrículas", JOptionPane.INFORMATION_MESSAGE);
                                AdminMenu adminMenu = new AdminMenu(user, this.userService, this.cursoService);
                                this.userService = adminMenu.close();
                                username.setText("");
                                password.setText("");
                                loggedIn = false;
                            }
                            case "Esudiante" -> {
                                JOptionPane.showMessageDialog(null, "Bienvenido " + user.username, "Sistema de matrículas", JOptionPane.INFORMATION_MESSAGE);
                                StudentMenu studentMenu = new StudentMenu(user);
                                studentMenu.close();
                            }
                            case "Profesor" -> {
                                JOptionPane.showMessageDialog(null, "Bienvenido " + user.username, "Sistema de matrículas", JOptionPane.INFORMATION_MESSAGE);
                                ProfesorMenu profesorMenu = new ProfesorMenu(user);
                                profesorMenu.close();
                            }
                            default -> {
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                break; // Salir del bucle si el usuario cancela
            }
        }
    }

    //Método para cerrar sesión.
    public UserService Logout() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada", "Logout", JOptionPane.INFORMATION_MESSAGE);
        return this.userService;
    }
}
