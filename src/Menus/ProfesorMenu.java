//Clase contenedora de métodos de uso exclusivo para el menú de los usuarios de rol profesor.
package Menus;

import Entidades.UserEntity;
import javax.swing.JOptionPane;

public class ProfesorMenu {

    public ProfesorMenu(UserEntity user) {
        String[] Options = {"VER CURSOS", "VER ESTUDIANTES", "Salir"};
        JOptionPane.showOptionDialog(null, "Bienvenido profesor", "Sistema de matrículas\nSeleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
    }

    public void close() {

    }

}
