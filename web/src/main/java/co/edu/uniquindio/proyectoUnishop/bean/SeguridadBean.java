package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.Administrador;
import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.PersonaServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Scope("session")
@Component
public class SeguridadBean implements Serializable {

    @Getter
    @Setter
    private boolean autenticado;

    @Getter
    @Setter
    private String email, password;
    @Getter
    @Setter
    private Persona persona;
    @Getter
    @Setter
    String rol;

    @Autowired
    private PersonaServicio personaServicio;


    public String iniciarSesion() {
        if (!email.isEmpty() && !password.isEmpty()) {
            try {
                persona = personaServicio.iniciarSesion(email, password);
                if(persona instanceof Usuario){
                    rol = "usuario";
                } else if(persona instanceof Administrador){
                    rol = "administrador";
                }

                autenticado = true;
                return "index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }

        return null;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public String recuperar() {
        return "/recuperarContrasenia.xhtml?faces-redirect=true";
    }
}
