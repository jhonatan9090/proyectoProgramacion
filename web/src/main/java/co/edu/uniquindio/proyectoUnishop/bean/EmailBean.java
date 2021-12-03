package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.DetalleCompraServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.PersonaServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.ServicioEmail;

import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@RequestScope
public class EmailBean implements Serializable {


    @Autowired
    private ServicioEmail emailServico;

    @Autowired
    private PersonaServicio usuarioServicio;

    @Autowired
    private DetalleCompraServicio detalleCompraServicio;

    @Getter
    @Setter
    private Persona persona;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private DetalleCompra detalleCompra;


    @Getter
    @Setter
    private String idPersona;

    private String asunto;

    private String mensaje;




    public String enviarCorreo() {

        if (idPersona != null && email != null) {
            try{
                persona = usuarioServicio.recuperarPassword(idPersona, email);
                asunto = "Recuperar contraseña";

                mensaje = "Estos son sus datos de login en Unishop. No comparta la información con ningún tercero\n\n"
                        + "Email: " + email + "\nContraseña: " + persona.getPassword() + "\n\nHasta luego.";

                emailServico.SendSimpleMessage(email, asunto, mensaje);
                return "/index.xhtml?faces-redirect=true";
            } catch (Exception e){
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje-recuperar", m);
            }
        }
        return null;
    }

    public String enviarCorreoCompra() {

        //detalleCompra=detalleCompraServicio.buscarDetalleId()


        if (idPersona != null && email != null) {
            try{
                persona = usuarioServicio.recuperarPassword(idPersona, email);
                asunto = "Recuperar contraseña";

                mensaje = "Estos son sus datos de login en Unishop. No comparta la información con ningún tercero\n\n"
                        + "Email: " + email + "\nContraseña: " + persona.getPassword() + "\n\nHasta luego.";

                emailServico.SendSimpleMessage(email, asunto, mensaje);
                return "/index.xhtml?faces-redirect=true";
            } catch (Exception e){
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje-recuperar", m);
            }
        }
        return null;
    }

}
