package Servicios;

import Entidades.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<UserEntity> users;

    public RoleEntity Admin;
    public RoleEntity Teacher;
    public RoleEntity Student;

    public UserService(List<UserEntity> UserList) {  
        this.users = UserList;
        this.Admin = new RoleEntity(1, "Admin");
        this.Teacher = new RoleEntity(2, "Teacher");
        this.Student = new RoleEntity(3, "Student");
    }

    public int CreateUser(UserEntity user) {
        int next_id = 1 + this.users.size();
        user.setUserId(next_id);
        this.users.add(user);
        return user.GetID();
    }


    public String[][] GetUsers() {
        String[][] data = new String[this.users.size()][6];
        for (int i = 0; i < this.users.size(); i++) {
            data[i] = this.users.get(i).ShowInfo();
        }
        return data;
    }

    public UserEntity GetUser(String username) {
        for (UserEntity user : this.users) {
            if (username.equals(user.GetUsername())) {
                return user;
            }
        }       
        return null;
    }


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
