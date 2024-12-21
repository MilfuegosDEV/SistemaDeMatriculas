package Servicios;

import Entidades.*;
import java.util.*;


public class CursoService {
    public List<CursoEntity> cursos;
    public CursoService(List<CursoEntity> CursoList) {
        this.cursos = CursoList;
    }
    public void AddCurso(CursoEntity curso) {
        int next_id = 1 + this.cursos.size();
        curso.SetId(next_id);
        this.cursos.add(curso);        
    }

    public CursoEntity GetCurso(int id) {
        for (CursoEntity curso : this.cursos) {
            if (curso != null && curso.GetId() == id) {
                return curso;
            }
        }
        return null;
    }
    public String[][] ShowInfo() {
        String[][] data = new String [this.cursos.size()][4];
        for (int i = 0; i < this.cursos.size(); i++) {
                data[i] = this.cursos.get(i).ShowInfo();

        }
        return data;
    }
    public String[][] ShowInfoByProfessor(UserEntity profesor) {
        String[][] data = new String [this.cursos.size()][4];
        for (int i = 0; i < this.cursos.size(); i++) {

            if (this.cursos.get(i).profesor == profesor) {
                data[i] = this.cursos.get(i).ShowTeacherDetails();
            }
        }
        return data;
    }
    public String[][] ShowStudentsByCourse() {
        int id;
        CursoEntity curso = this.GetCurso(id);
        String[][] data = new String[curso.estudiantes.size()][6];
        for (int i = 0; i < curso.estudiantes.size(); i++) {
            data[i] = curso.estudiantes.get(i).ShowInfo();
        }
        return data;
    }
    public String[][] ShowInfoByStudent(UserEntity student) {
        List<String[]> data = new ArrayList<>();
        for (CursoEntity curso : this.cursos) {
            for (UserEntity estudiante : curso.estudiantes) {
                if (estudiante == student) {
                    data.add(curso.ShowInfo());
                }
            }
        }
        return data.toArray(new String[0][0]);
    }

    public void Enroll(UserEntity student, int id) {
        CursoEntity curso = this.GetCurso(id);
        curso.AddEstudiante(student);
    }
}
