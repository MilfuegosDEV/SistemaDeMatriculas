
import Entidades.*;
import Servicios.*;

public class SistemaDeMatriculas {

    public static void main(String[] args) {
        UserService userservice = new UserService();
        UserEntity user = new UserEntity(1, "milfuegosdev", "admin", "Daniel", "Luna", userservice.Admin);
        userservice.AddUser(user);
        System.out.println(userservice.GetUsers());
    }
}
