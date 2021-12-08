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
import org.springframework.beans.factory.annotation.Value;
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
    @Value("#{seguridadBean.email}")
    private String email;

    @Getter
    @Setter
    private List<DetalleCompra> detalleCompras;


    @Getter
    @Setter
    private String idPersona;

    private String asunto;

    private String mensaje;


    /**
     * este metodo sirve para enviar el correo al usuario que a perdido su contraseña u puedda recuperar su contraseña
     *
     * @return
     */
    public String enviarCorreo() {

        if (idPersona != null && email != null) {
            try {
                persona = personaServicio.recuperarPassword(idPersona, email);
                asunto = "Recuperar contraseña";

                mensaje = "Hemos recibido una solicitud tuya para recuperar tu contraeña. No compartas tu informacion \n\n"
                        + "Email: " + email + "\nContraseña: " + persona.getPassword() + "\n\nHasta luego.";

                emailServico.SendSimpleMessage(email, asunto, mensaje);
                return "/index.xhtml?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje-recuperar", m);
            }
        }
        return null;
    }

    /**
     * este metodo sirve para recuperar la contraseña y los datos del usuario
     *
     * @return
     */
    public String enviarCorreoCompra() {

        //detalleCompra=detalleCompraServicio.buscarDetalleId()


        try {
            detalleCompras = usuarioServicio.listarComprasUsuario(email);

            String salida=" ";
            asunto = "Registro de compras";
            for (DetalleCompra dc : detalleCompras) {


                salida+=("Su producto:"+dc.getProductoDetalle().getNombre()+"           "+"Unidades:"+dc.getUnidades())+"           "+"Precio: "+dc.getProductoDetalle().getPrecio()+"\n";

                mensaje = "Lista de productos\n\n"
                            +salida;
            }


            emailServico.SendSimpleMessage(email, asunto, mensaje);
            return "/index.xhtml?faces-redirect=true";

        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-recuperar", m);

        }


        return null;
    }

}
