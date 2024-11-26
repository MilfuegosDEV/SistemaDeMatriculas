/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author juand
 */
public class UserEntity {

    protected int id;
    public String username;
    protected String password;
    public String name;
    public String lastname;
    protected RoleEntity role;

    public UserEntity(int id, String username, String password, String name, String lastname, RoleEntity role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
    }

    public String ShowInfo() {
        return this.id + "\t" + this.username + "\t" + "*************" + "\t" + this.name
                + "\t" + this.lastname + "\t" + this.role.GetRole();
    }

    public boolean ValidatePassword(String password) {
        return this.password.equals(password);
    }

    public String GetUsername() {
        return this.username;
    }

    @Override
    public String toString() {
        return this.id + "," + this.username + "," + this.password + "," + this.name + "," + this.lastname + ","
                + this.role.GetId();
    }
}
