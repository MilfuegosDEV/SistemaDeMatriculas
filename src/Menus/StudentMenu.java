package Menus;

import Entidades.UserEntity;
import javax.swing.JOptionPane;

public class StudentMenu {

    public StudentMenu(UserEntity user) {
        String[] Options = {"MATRICULAR", "HORARIO", "Salir"};
        JOptionPane.showOptionDialog(null, "Bienvenido " + user.GetUsername(), "Sistema de matrículas\nSeleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
    }

    public void close() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }
}
