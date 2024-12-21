package Entidades;

//Clase contenedora de métodos para la entidad de roles.

public class RoleEntity {

    //Se establecen atributos privados integrados en la entidad.
    private final int id;
    private final String name;

    //Constructor de objetos tipo entidad rol con parámetros de los atributos establecidos.
    public RoleEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getter público del atributo nombre.
    public String GetRole() {
        return this.name;
    }

    //Setter público del atributo identificación.
    public int GetId() {
        return this.id;
    }
}
