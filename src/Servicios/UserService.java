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
                user.setUserId(i);
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
        }
        return null;
    }

    public String[][] GetUsers() {
        String[][] userInfos = new String[5][1000];
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i] != null) {
                userInfos[i] = this.users[i].ShowInfo();
            }
        }
        return userInfos;
    }
}
