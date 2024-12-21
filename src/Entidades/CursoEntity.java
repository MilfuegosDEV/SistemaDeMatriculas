//Clase contenedora de métodos para la entidad de curso.
package Entidades;

import java.util.ArrayList;
import java.util.List;

public class CursoEntity {

    //Se establecen atributos privados integrados en la entidad.
    private int id;
    private final List<UserEntity> estudiantes;
    private final int grado;
    private final String nombre;
    private final UserEntity profesor;

    //Constructor de objetos tipo entidad curso con parámetros de los atributos establecidos.
    public CursoEntity(int grado, String nombre, UserEntity profesor) {
        this.grado = grado;
        this.estudiantes = new ArrayList<>();
        this.nombre = nombre;
        this.profesor = profesor;
    }

    //Método setter para añadir un estudiante en el arreglo de estudiantes existentes dentro del curso.
    public void AddEstudiante(UserEntity estudiante) {
        this.estudiantes.add(estudiante);
    }

    //Método getter para mostrar información de los cursos para una de las opciones de los menús.
    public String[] ShowInfo() {
        return new String[]{
            Integer.toString(this.id), this.nombre, Integer.toString(this.grado), (this.profesor.name + " " + this.profesor.lastname), Integer.toString(this.estudiantes.size())
        };
    }

    //Setter público del atributo de identificación.
    public void SetId(int id) {
        this.id = id;
    }

    //Getter público del atributo de identificación.
    public int GetId() {
        return this.id;
    }

    @Override
    //Sobreescribir en forma String la información completa de los cursos existentes.
    public String toString() {
        return this.id + "," + this.nombre + "," + this.grado + "," + this.profesor.GetUsername();
    }
}
