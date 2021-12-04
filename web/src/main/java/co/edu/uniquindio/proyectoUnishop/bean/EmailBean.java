package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
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
import java.util.List;

@Component
@RequestScope
public class EmailBean implements Serializable {


    @Autowired
    private ServicioEmail emailServico;

    @Autowired
    private PersonaServicio personaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

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
    private List<DetalleCompra> detalleCompras;


    @Getter
    @Setter
    private String idPersona;

    private String asunto;

    private String mensaje;




    public String enviarCorreo() {

        if (idPersona != null && email != null) {
            try{
                persona = personaServicio.recuperarPassword(idPersona, email);
                asunto = "Recuperar contraseña";

                mensaje = "Hemos recibido una solicitud tuya para recuperar tu contraeña. No compartas tu informacion \n\n"
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



            try{
               detalleCompras=usuarioServicio.listarComprasUsuario(email);
                asunto = "Recuperar contraseña";

                mensaje = "Estos son sus datos de login en Unishop. No comparta la información con ningún tercero\n\n"
                        + "Email: " + email + "\nContraseña: " + detalleCompras.toString() + "\n\nHasta luego.";

                emailServico.SendSimpleMessage(email, asunto, mensaje);
                return "/index.xhtml?faces-redirect=true";
            } catch (Exception e){
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje-recuperar", m);
            }

        return null;
    }

}
