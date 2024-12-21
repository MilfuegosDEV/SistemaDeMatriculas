
//Clase principal del sistema de matrícula. Encargado de crear los usuarios para realizar pruebas.
//Además de hacer llamado a la clase para la autenticación de menú según el rol quién esté iniciando sesión.

//Importación de bibliotecas contenedoras de clases para el funcionamiento del sistema en general.
import Entidades.*;
import Menus.*;
import Servicios.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SistemaDeMatriculas {

    public static void main(String[] args) {
        //Llamado para la creación de objetos usuarios y cursos para realizar pruebas al correr el código.
        List<UserEntity> users = new ArrayList<>();
        List<CursoEntity> courses = new ArrayList<>();
        CursoService cursoService = new CursoService(courses);
        UserService userService = new UserService(users);
        //Creación de objetos usuarios.
        UserEntity user1 = new UserEntity("admin", "admin", "Sarai", "Valle", userService.Admin);
        UserEntity user2 = new UserEntity("teacher", "123456", "Daniel", "Luna Cienfuegos", userService.Teacher);
        UserEntity user3 = new UserEntity("student", "123456", "Dario", "", userService.Student);
        userService.CreateUser(user1);
        userService.CreateUser(user2);
        userService.CreateUser(user3);

        //Creación de objetos cursos.
        CursoEntity curso1 = new CursoEntity( 1, "Matemática", user2);
        CursoEntity curso2 = new CursoEntity( 1, "Español", user2);
        CursoEntity curso3 = new CursoEntity(2, "Matemática", user2);
        cursoService.AddCurso(curso1);
        cursoService.AddCurso(curso2);
        cursoService.AddCurso(curso3);

        String[] options = {"INGRESAR", "SALIR"};

        int option = JOptionPane.showOptionDialog(null, "Bienvenido al sistema de matrículas", "Sistema de matrículas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        //Después de seleccionar la opción de ingresar, se hace llamado a los métodos para la autenticación del menú según el tipo de rol.
        //Además del método de inicar sesión para determinar si es un usuario existente para iniciar sesión.
        if (option == 0) {
            AuthMenu authMenu = new AuthMenu(userService, cursoService);
            authMenu.Login();
        }

    }
}
