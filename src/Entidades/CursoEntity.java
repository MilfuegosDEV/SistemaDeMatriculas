package Entidades;

import java.util.ArrayList;
import java.util.List;

public class CursoEntity {

    private int id;
    public List<UserEntity> estudiantes;
    private final int grado;
    private final String nombre;
    public UserEntity profesor;

    public CursoEntity(int grado, String nombre, UserEntity profesor) {
        this.grado = grado;
        this.estudiantes = new ArrayList<>();
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public void AddEstudiante(UserEntity estudiante) {
        this.estudiantes.add(estudiante);
    }

    public String[] ShowInfo() {
        return new String[]{
            Integer.toString(this.id), this.nombre, Integer.toString(this.grado), (this.profesor.name + " " + this.profesor.lastname), Integer.toString(this.estudiantes.size())
        };
    }

    public String[] ShowTeacherDetails(){
        return new String[]{
            Integer.toString(this.id), this.nombre, Integer.toString(this.grado), Integer.toString(this.estudiantes.size())
        };
    }


    public void SetId(int id) {
        this.id = id;
    }

    public int GetId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id + "," + this.nombre + "," + this.grado + "," + this.profesor.GetUsername();
    }
}
