package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.faces.context.FacesContext;
import java.io.Serializable;

@Scope("session")
@Component
public class SeguridadBean implements Serializable {

    @Getter @Setter
    private boolean autenticado;

    @Getter @Setter
    private String email, password;
    @Getter
    @Setter
    private Usuario usuarioSesion;
    @Autowired
    private UsuarioServicio usuarioServicio;

    public  String iniciarSesion(){
        if(!email.isEmpty() && !password.isEmpty()){
            try {
                autenticado=true;
                usuarioSesion= usuarioServicio.iniciarSesion(email, password);
                return "index?faces-redirect=true";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

}
