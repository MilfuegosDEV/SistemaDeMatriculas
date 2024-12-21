
import Entidades.*;
import Menus.*;
import Servicios.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SistemaDeMatriculas {

    public static void main(String[] args) {
        List<UserEntity> users = new ArrayList<>();
        List<CursoEntity> courses = new ArrayList<>();
        CursoService cursoService = new CursoService(courses);
        UserService userService = new UserService(users);
        UserEntity user1 = new UserEntity("admin", "admin", "Sarai", "Valle", userService.Admin);
        UserEntity user2 = new UserEntity("teacher", "123456", "Daniel", "Luna Cienfuegos", userService.Teacher);
        UserEntity user3 = new UserEntity("student", "123456", "Dario", "", userService.Student);
        userService.CreateUser(user1);
        userService.CreateUser(user2);
        userService.CreateUser(user3);

        CursoEntity curso1 = new CursoEntity( 1, "Matemática", user2);
        CursoEntity curso2 = new CursoEntity( 1, "Español", user2);
        CursoEntity curso3 = new CursoEntity(2, "Matemática", user2);
        cursoService.AddCurso(curso1);
        cursoService.AddCurso(curso2);
        cursoService.AddCurso(curso3);

        String[] options = {"INGRESAR", "SALIR"};

        int option = JOptionPane.showOptionDialog(null, "Bienvenido al sistema de matrículas", "Sistema de matrículas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (option == 0) {
            AuthMenu authMenu = new AuthMenu(userService, cursoService);
            authMenu.Login();
        }

    }
}
