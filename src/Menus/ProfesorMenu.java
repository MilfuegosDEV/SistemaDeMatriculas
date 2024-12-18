package Menus;

import Entidades.CursoEntity;
import Entidades.UserEntity;
import Servicios.CursoService;
import javax.swing.JOptionPane;

public class ProfesorMenu {

    public final UserEntity profesor;
    public final CursoService cursoService;

    public ProfesorMenu(UserEntity profesor, CursoService cursoService) {
        this.profesor= profesor;
        this.cursoService= cursoService;

        String[] options= {"VER CURSOS", "VER ESTUDIANTES", "SALIR"};
        int option;

        do {
            option= JOptionPane.showOptionDialog(null, "Bienvenido profesor" + profesor.GetUsername(), "\nSistema de matrículas\nSeleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0:
                    VerCursos();
                    break;
                case 1:
                    VerEstudiantes();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saliendo del menú de profesor.");
                    break;
                default:
                    break;
            }
        } while (option != 2);
    }

    //Ver cursos asignados al profesor
    public void VerCursos() {
        StringBuilder cursosAsignados= new StringBuilder("Cursos Asignados:\n");
        CursoEntity[] cursos= cursoService.GetCursosList();

        boolean tieneCursos= false;
        for (CursoEntity curso : cursos) {
            if (curso != null && curso.GetProfesor().equals(profesor)) {
                cursosAsignados.append("- ID: ").append(curso.GetId()).append(", Nombre: ").append(curso.GetNombre()).append(", Grado: ").append(curso.GetGrado()).append("\n");
                tieneCursos= true;
            }
        }

        if (!tieneCursos) {
            cursosAsignados.append("No tiene cursos asignados.");
        }
        JOptionPane.showMessageDialog(null, cursosAsignados.toString());
    }

    //Ver estudiantes matriculados en los cursos
    public void VerEstudiantes() {
        StringBuilder estudiantesInfo= new StringBuilder("Estudiantes Matriculados:\n");
        CursoEntity[] cursos= cursoService.GetCursosList();

        boolean tieneEstudiantes= false;

        for (CursoEntity curso : cursos) {
            if (curso != null && curso.GetProfesor().equals(profesor)) {
                estudiantesInfo.append("\nCurso: ").append(curso.GetNombre()).append(" (ID: ").append(curso.GetId()).append(")\n");

                UserEntity[] estudiantes= curso.GetEstudiantes();
                int totalEstudiantes= 0;

                for (UserEntity estudiante : estudiantes) {
                    if (estudiante != null) {
                        estudiantesInfo.append("  - ").append(estudiante.GetUsername()).append("\n");
                        totalEstudiantes++;
                    }
                }
                estudiantesInfo.append("Total de estudiantes: ").append(totalEstudiantes).append("\n");
                tieneEstudiantes= true;
            }
        }

        if (!tieneEstudiantes) {
            estudiantesInfo.append("No hay estudiantes matriculados en sus cursos.");
        }
        JOptionPane.showMessageDialog(null, estudiantesInfo.toString());

    }
        public void close() {

    }

}