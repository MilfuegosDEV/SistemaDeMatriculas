
import Entidades.*;
import Menus.*;
import Servicios.*;
import javax.swing.JOptionPane;

public class SistemaDeMatriculas {

    public static void main(String[] args) {
        UserService userService = new UserService();
        UserEntity user1 = new UserEntity("1", "1", "", "", userService.Admin);
        userService.AddUser(user1);
        String[] options = {"Ingresar", "Salir"};

        PoblateUsers();
        int option = JOptionPane.showOptionDialog(null, "Bienvenido al sistema de matrículas", "Sistema de matrículas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (option == 0) {
            AuthMenu.Login(userService);
        }

    }

    private static void PoblateUsers() {
    }
}
