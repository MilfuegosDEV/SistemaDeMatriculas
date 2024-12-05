package Servicios;

import javax.swing.JOptionPane;

public class PasswordService {
    
    public String PasswordVerifier(String password){
        boolean aprobacion = false;
        String pass = null;
        boolean secondtrun = false;
        
        while(aprobacion != true){
            
            if(secondtrun == true){
                password = JOptionPane.showInputDialog("Digite la contraseña deseada: ");
            }
            secondtrun = true;
            aprobacion = true;
            if (password.length() < 6 || password.length() > 12){
                JOptionPane.showMessageDialog(null, "La contraseña debe de tener una longitud de mínio 6 y máximo 12 caracteres.");
                aprobacion = false;
            }
            ////
            for(int i = 0; i <= password.length(); i++){
                if(i == password.length()){
                    JOptionPane.showMessageDialog(null, "La contraseña debe de tener al menos una letra en mayúscula");
                    aprobacion = false;
                    break;
                }
                if(Character.isUpperCase(password.charAt(i))){
                    break;
                }
            }
            ///
            for(int i = 0; i <= password.length(); i++){
                if(i == password.length()){
                    JOptionPane.showMessageDialog(null, "La contraseña debe de tener al menos una letra en minúscula");
                    aprobacion = false;
                    break;
                }
                if(Character.isLowerCase(password.charAt(i))){
                    break;
                }
            }
            ///
            for(int i = 0; i <= password.length(); i++){
                if(i == password.length()){
                    JOptionPane.showMessageDialog(null, "La contraseña debe de tener al menos un digito");
                    aprobacion = false;
                    break;
                }
                if(Character.isDigit(password.charAt(i))){
                    break;
                }
            }
            ////
            for(int i = 0; i <= password.length(); i++){
                if(i == password.length()){
                    JOptionPane.showMessageDialog(null, "La contraseña debe de tener al menos un caracter especial");
                    aprobacion = false;
                    break;
                }
                if(!Character.isLetterOrDigit(password.charAt(i))){
                    break;
                }
                if(aprobacion == true){
                    pass = password;
                }
            }
           
        
           
        }
        return pass;


        
    }


}
