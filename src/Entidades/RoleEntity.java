
package Entidades;

public class RoleEntity {

    private final int id;
    private final String name;

    public RoleEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String GetRole() {
        return this.name;
    }

    public int GetId() {
        return this.id;
    }
}
