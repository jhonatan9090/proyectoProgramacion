package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.LoguinServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


@Component
@ViewScoped
public class LoguinBean {


    private final UsuarioServicio usuarioServicio;

    @Getter
    @Setter
    private Persona persona;

    @Getter
    @Setter
    private String correo;

    @Getter
    @Setter
    private String password;

    public LoguinBean(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }


    public String loguearPersona() {

        if (correo != null && password != null) {

            try {

                persona = usuarioServicio.recuperarPassword(correo, password);


                return "/index.xhtml?faces-redirect=true";

            } catch (Exception e) {


                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje-sesion", m);


            }


        }

        return null;
    }


}
