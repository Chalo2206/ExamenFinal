package Procesos;

import CMR.Controlador.UserRegistrationJpaController;
import CMR.Modelo.UserRegistration;
import java.util.List;

public class Registro {
    UserRegistrationJpaController CUser = new UserRegistrationJpaController();
    
    public void cargar_Usuarios(){
        try {
            Object o[] = null;
            List<UserRegistration> listU = CUser.findUserRegistrationEntities();
            for(int i = 0; i < listU.size(); i++){
                System.out.println("--> "+listU.get(i).getUserID()+" "+listU.get(i).getName()+" "+listU.get(i).getEmail());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
