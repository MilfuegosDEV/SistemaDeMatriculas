//Clase contenedora de métodos de uso exclusivo cuando una acción sea respectiva a la entidad de usuarios.
package Servicios;

import Entidades.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    //Arreglo o lista array contenedora de los usuarios disponibles.
    public List<UserEntity> users;

    public RoleEntity Admin;
    public RoleEntity Teacher;
    public RoleEntity Student;

    //Método de mismo tipo de los servicios de usuarios quién distingue cada usuario a través de un digito identificativo.
    public UserService(List<UserEntity> UserList) {  
        this.users = UserList;
        this.Admin = new RoleEntity(1, "Admin");
        this.Teacher = new RoleEntity(2, "Teacher");
        this.Student = new RoleEntity(3, "Student");
    }

    //Método para crear un usuario más una sola extensión del arreglo contenedor.
    public int CreateUser(UserEntity user) {
        int next_id = 1 + this.users.size();
        user.setUserId(next_id);
        this.users.add(user);
        //Retorna el número de identificador de rol para el usuario.
        return user.GetID();
    }


    ///Método de tipo arreglo bidemensional quién almacena información de los usuarios para retornarla.
    public String[][] GetUsers() {
        String[][] data = new String[this.users.size()][6];
        for (int i = 0; i < this.users.size(); i++) {
            data[i] = this.users.get(i).ShowInfo();
        }
        return data;
    }

    //Método de tipo entidad de usuario que por parámetro solicita el nombre de un usuario y retorna el usuario correspondiente.
    public UserEntity GetUser(String username) {
        for (UserEntity user : this.users) {
            if (username.equals(user.GetUsername())) {
                return user;
            }
        }       
        return null;
    }


    //Arreglo o lista array contenedora únicamente de usuarios con un rol en específico.
    public List<String> FilterByRole(RoleEntity role) {

        List<String> filteredUsers = new ArrayList<>();
        for (UserEntity user: this.users) {
            if (user.role == role){
                filteredUsers.addLast(user.username);
            }
        }
        return filteredUsers;
    }
}
