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

}
