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
    public RoleEntity role;

    public UserEntity(String username, String password, String name, String lastname, RoleEntity role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
    }

    public String[] ShowInfo() {
        return new String[]{
            Integer.toString(this.id), this.username, "*****", this.name, this.lastname,
            this.role.GetRole()
        };
    }

    public boolean ValidatePassword(String password) {
        return this.password.equals(password);
    }


    public void setUserId(int id) {
        this.id = id;
    }

    public String GetUsername() {
        return this.username;
    }

    public String GetPassword(){
        return this.password;
    }

    public String[] GetInfo() {
        return new String[]{ 
            this.username, this.name, this.lastname
        };
    }


    public int GetID() {
        return this.id;
    }
}
