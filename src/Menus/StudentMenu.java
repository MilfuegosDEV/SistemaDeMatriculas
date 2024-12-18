package Menus;

import Entidades.CursoEntity;
import Entidades.UserEntity;
import Servicios.CursoService;
import Servicios.UserService;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class StudentMenu {

    UserService userService;
    CursoService cursoService;

    public StudentMenu(UserEntity user, UserService userService, CursoService cursoService) {
        this.userService = userService;
        this.cursoService = cursoService;
        String[] Options = {"MATRICULAR", "HORARIO", "Salir"};
        do {
            int option = JOptionPane.showOptionDialog(null, "Bienvenido " + user.GetUsername(), "Sistema de matrículas\nSeleccione una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
            switch (option) {
                case 0 ->
                    Matricular();
                case 1 -> {
                    return;
                }
                case 2 -> {
                    return;
                }
                default -> {
                }
            }
        } while (true);
    }

    public void close() {
        JOptionPane.showMessageDialog(null, "Sesión cerrada", "Logout", JOptionPane.INFORMATION_MESSAGE);
    }


    
    public void Matricular(){


        String [] cursosdisponibles = new String[this.cursoService.contador];
        for (int i = 0; i < this.cursoService.cursostudents.length; i++){
            if(this.cursoService.cursostudents[i] != null){
                cursosdisponibles[i] = this.cursoService.cursostudents[i].getNombre()+" del Grado "+this.cursoService.cursostudents[i].getGrado();
            }

        }
  
        

        JComboBox<String> currentcourses = new JComboBox<>(cursosdisponibles);

        Object[] message = {
            "Cursos", currentcourses
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Matricular", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            for(int i = 0; i < cursoService.cursostudents.length; i++){
                if(cursoService.cursostudents[i] != null && currentcourses.getSelectedItem().equals(cursoService.cursostudents[i].getNombre()) && cursoService.cursostudents[i].GetEstudiante(i)!=null){
                    JOptionPane.showMessageDialog(null, "No se puede joven");

                }
                if(cursoService.cursostudents[i] != null && currentcourses.getSelectedItem().equals(cursoService.cursostudents[i].getNombre())){
                    cursoService.cursostudents[i].setEstudiantes(i);
                }   

            }
        
        }


    }


}
