//Clase contenedora de métodos de uso exclusivo cuando una acción sea respectiva a la entidad de cursos.
package Servicios;

import Entidades.*;
import java.util.*;


public class CursoService {

    //Arreglo o lista array contenedora de los cursos disponibles.
    public List<CursoEntity> cursos;

    public CursoService(List<CursoEntity> CursoList) {
        this.cursos = CursoList;
    }

    //Método que añade un curso más una sola extensión del arreglo contenedor.
    public void AddCurso(CursoEntity curso) {
        int next_id = 1 + this.cursos.size();
        curso.SetId(next_id);
        this.cursos.add(curso);        
    }

    //Método que por parámetro solicita la identificación de un curso y retorna el curso con dicha identificación,
    public CursoEntity GetCurso(int id) {
        for (CursoEntity curso : this.cursos) {
            if (curso != null && curso.GetId() == id) {
                return curso;
            }
        }
        return null;
    }


    //Método de tipo arreglo bidemensional que retorna la información de los cursos respectivo si el usuario lo solicita.
    public String[][] ShowInfo() {
        String[][] data = new String [this.cursos.size()][4];
        for (int i = 0; i < this.cursos.size(); i++) {
            data[i] = this.cursos.get(i).ShowInfo();
        }
        return data;
    }

}
