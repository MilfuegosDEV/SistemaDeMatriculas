package Menus;

import Entidades.UserEntity;
import Servicios.CursoService;
import Servicios.UserService;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProfesorMenu {
  CursoService cursoService;
    UserEntity user;

    public ProfesorMenu(UserEntity user, UserService userService, CursoService cursoService) {
        this.cursoService = cursoService;
        this.user = user;
        this.ShowCourses();
    }


    private void ShowCourses() {
        String[][] courses = this.cursoService.ShowInfoByProfessor(this.user);
        String[] cols = {"ID", "CURSO", "GRADO", "MATRICULADOS"};
        String[] options = {"SALIR"};
        JTable table = new JTable(courses, cols);
        OUTER:
        do {
            int option = JOptionPane.showOptionDialog(null, new JScrollPane(table), "Usuarios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (option) {
                case 0 -> {
                    break OUTER;
                }
            }
        } while (true);

    }

    private void ShowStudentList() {
    
        String[][] students = this.cursoService.ShowStudentsByCourse();
        String[] cols = {"ID", "USERNAME", "PASSWORD", "NOMBRE", "APELLIDO", "ROL"};
        String[] options = {"SALIR"};
        JTable table = new JTable(students, cols);
        
        JOptionPane.showOptionDialog(null, new JScrollPane(table), "Usuarios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

    
    }

    public void close() {
        this.ShowCourses();
    }
    
}
