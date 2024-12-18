package Entidades;

public class CursoEntity {

    private final int id;
    private final UserEntity[] estudiantes;
    private final int grado;
    private final String nombre;
    private final UserEntity profesor;

    public CursoEntity(int id, int grado, String nombre, UserEntity profesor) {
        this.id = id;
        this.grado = grado;
        this.estudiantes = new UserEntity[30];
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public void AddEstudiante(UserEntity estudiante) {
        for (int i = 0; i < this.estudiantes.length; i++) {
            if (this.estudiantes[i] == null) {
                this.estudiantes[i] = estudiante;
                break;
            }
        }
    }

    public void RemoveEstudiante(UserEntity estudiante) {
        for (int i = 0; i < this.estudiantes.length; i++) {
            if (this.estudiantes[i] == estudiante) {
                this.estudiantes[i] = null;
                break;
            }
        }
    }

    public UserEntity[] GetEstudiantes() {
        return this.estudiantes;
    }

    public String[] ShowInfo() {
        return new String[]{
            Integer.toString(this.id), this.nombre, Integer.toString(this.grado)
        };
    }

    public int GetId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id + "," + this.nombre + "," + this.grado + "," + this.profesor.GetUsername();
    }

    public String getNombre(){
        return nombre;
    } 
    
    public int getGrado(){
        return grado;
    } 

    public UserEntity GetEstudiante(int position){
        return estudiantes[position];
    }
    
    public void setEstudiantes(int position){
        this.estudiantes[position] = estudiantes[position];
    }

    public UserEntity GetProfesor() {
        return this.profesor;
    }
    
    public String GetNombre() {
        return this.nombre;
    }
    
    public int GetGrado() {
        return this.grado;
    }
}
