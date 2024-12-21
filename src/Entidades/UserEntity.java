/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author juand
 */
//Clase contenedora de métodos para la entidad de usuarios.
public class UserEntity {

    //Se establecen atributos privados integrados en la entidad.
    protected int id;
    public String username;
    protected String password;
    public String name;
    public String lastname;
    public RoleEntity role;

    //Constructor de objetos tipo entidad usuario con parámetros de los atributos establecidos.
    public UserEntity(String username, String password, String name, String lastname, RoleEntity role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
    }

    //Método getter para mostrar información de los usuarios para una de las opciones de los menús.
    //Notese la protección de la contraseña del usuario para mantener la privacidad.
    public String[] ShowInfo() {
        return new String[]{
            Integer.toString(this.id), this.username, "*****", this.name, this.lastname,
            this.role.GetRole()
        };
    }

    //Método booleano con parámetro de contraseña quién simplemente retorna si el usuario es existente o no.
    //Verdadero o falso.
    public boolean ValidatePassword(String password) {
        return this.password.equals(password);
    }


    //Setter público para el atributo de identificación.
    public void setUserId(int id) {
        this.id = id;
    }

    //Getter público para el atributo nombre de usuario.
    public String GetUsername() {
        return this.username;
    }

    //Getter público para el atributo contraseña.
    public String GetPassword(){
        return this.password;
    }

    //Getter público para retornar en un arreglo atributos de tipo String.
    public String[] GetInfo() {
        return new String[]{ 
            this.username, this.name, this.lastname
        };
    }


    //Getter público para el atributo de identificación.
    public int GetID() {
        return this.id;
    }
}
