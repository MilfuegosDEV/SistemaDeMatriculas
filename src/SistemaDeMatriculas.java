
import Entidades.*;
import Menus.*;
import Servicios.*;
import javax.swing.JOptionPane;

public class SistemaDeMatriculas {

    public static void main(String[] args) {
        UserService userService = new UserService();
        CursoService cursoService = new CursoService();
        UserEntity user1 = new UserEntity("admin", "admin", "", "", userService.Admin);
        UserEntity user2 = new UserEntity("teacher", "123456", "", "", userService.Teacher);
        UserEntity user3 = new UserEntity("student", "123456", "", "", userService.Student);
        CursoEntity curso1 = new CursoEntity(123, 1, "Matemática", user3);
        CursoEntity curso2 = new CursoEntity(456, 1, "Español", user3);
        CursoEntity curso3 = new CursoEntity(789, 2, "Matemática", user3);
        userService.AddUser(user1);
        userService.AddUser(user2);
        userService.AddUser(user3);
        cursoService.AddCursoStudents(curso1);
        cursoService.AddCursoStudents(curso2);
        cursoService.AddCursoStudents(curso3);



        String[] options = {"INGRESAR", "SALIR"};

        int option = JOptionPane.showOptionDialog(null, "Bienvenido al sistema de matrículas", "Sistema de matrículas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (option == 0) {
            AuthMenu authMenu = new AuthMenu(userService, cursoService);
            authMenu.Login();
        }

    }
}
