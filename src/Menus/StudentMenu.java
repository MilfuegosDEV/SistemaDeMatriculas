package Menus;

import Entidades.UserEntity;
import Servicios.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class StudentMenu {
    
    private final CursoService cursoService;
    private final UserService userService;
    private final UserEntity user;

    public StudentMenu(UserEntity user, UserService userService, CursoService cursoService) {
        
        this.userService = userService;
        this.cursoService = cursoService;
        this.user = user;
        
        String[] Options = {"CONTINUAR", "SALIR"};
        JOptionPane.showOptionDialog(null, "Bienvenido " + user.GetUsername(), "Sistema de matrículas\nSeleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
    
        OUTER:
        do { 
            
            String[] options = {"VER CURSOS", "SALIR"};
            int option = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú de estudiante", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (option) {
                case 0 -> {
                    this.ShowCourses();
                    break;
                }
                case 1 -> {
                    break OUTER;
                }
                default -> {
                }
            }
        } while (true);
    
    }


    private void ShowCourses() {

        String[][] courses = this.cursoService.ShowInfoByStudent(this.user);
        String[] cols = {"ID", "CURSO", "GRADO", "PROFESOR", "MATRICULADOS"};
        String[] options = {"MATRICULAR", "SALIR"};
        JTable table = new JTable(courses, cols);
        OUTER:
        do {
            int option = JOptionPane.showOptionDialog(null, new JScrollPane(table), "Cursos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (option) {
                case 0 -> {
                    this.Enroll();
                    break;
                }
                case 1 -> {
                    break OUTER;
                }
                default -> {
                }
            }
        } while (true);

    }

    private void Enroll() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del curso");
        int course_id = Integer.parseInt(id);
        this.cursoService.Enroll(this.user, course_id);
    }

    public void close() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }
}
