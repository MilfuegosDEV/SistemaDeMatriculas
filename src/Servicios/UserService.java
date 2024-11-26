package Servicios;

import Entidades.*;

public class UserService {

    private final UserEntity[] users;

    public RoleEntity Admin;

    public RoleEntity Student;

    public UserService() {
        this.users = new UserEntity[1000];
        this.Admin = new RoleEntity(1, "Admin");
        this.Student = new RoleEntity(2, "Estudiante");
    }

    public UserEntity AddUser(UserEntity user) {
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] == null) {
                this.users[i] = user;
                break;
            }
        }
        return user;
    }

    public UserEntity GetUser(String username) {
        for (UserEntity user : this.users) {
            if (user != null && user.GetUsername().equals(username)) {
                return user;
            }

            return user;
        }
        return null;
    }

    public String GetUsers() {
        String result = "id\tusername\tpassword\tname\tlastname\trole\n";
        for (UserEntity user : this.users) {
            if (user != null) {
                result += user.ShowInfo() + "\n";
            }
        }
        return result;
    }

}
