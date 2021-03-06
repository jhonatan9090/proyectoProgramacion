package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.servicios.CiudadServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;


@Component
@ViewScoped
@Controller
public class UsuarioBean {
    @Getter
    @Setter
    private Usuario usuario;



    private final UsuarioServicio usuarioServicio;
    private  final CiudadServicio ciudadServicio;
    private final ProductoServicio productoServicio;

    //trae la lista de las ciudades
    @Getter
    @Setter
    private List<Ciudad>listaCiudad;


    @Getter
    @Setter
    private List<Producto>listaProductosUsuario;


    public UsuarioBean(UsuarioServicio usuarioServicio, CiudadServicio ciudadServicio, ProductoServicio productoServicio) {
        this.usuarioServicio = usuarioServicio;
        this.ciudadServicio = ciudadServicio;
        this.productoServicio = productoServicio;
    }

    @PostConstruct
    public void inicializar() {

        usuario = new Usuario();
        listaCiudad=ciudadServicio.listaCiudad();


    }

    /**
     * este metodo sirve para registrar usuario y conectar la informacion registrado con la parte logica del programa
     */
    public void registrarUsuario() {
        try {
            usuarioServicio.registrarUsuario(usuario);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage("msj", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj", msg);
        }
    }
}
