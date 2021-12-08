package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.*;
import co.edu.uniquindio.proyectoUnishop.servicios.CiudadServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@RequestScope
public class UsuarioPrBean implements Serializable {






    private final UsuarioServicio usuServicio;
    private final ProductoServicio productoServicio;

    @Getter
    @Setter
    private Usuario usuario;

    @Getter
    @Setter
    private Ciudad ciudad;



    @Getter
    @Setter
    private List<Ciudad> ciudades;


    @Getter
    @Setter
    private List<Producto> productoList;

    @Getter
    @Setter
    private  List<DetalleCompra>detalleCompras;







    @Value(value = "#{seguridadBean.email}")
    private String email;

    public UsuarioPrBean(UsuarioServicio usuServicio, ProductoServicio productoServicio) {
        this.usuServicio = usuServicio;
        this.productoServicio = productoServicio;
    }


    @PostConstruct
    public void inicializar() {


       productoList = usuServicio.listarProductoUsuario(email);
    ;
    }

    /*public void modificarUsuario() {

        FacesMessage msg;
        try {
            usuServicio.actualizarUsuario(usuario);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Alerta", "Se actualizo con exito");
            FacesContext.getCurrentInstance().addMessage("mensaje-usuario", msg);
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-usuario", msg);
        }
    }

    public String irAlDetalleCreador(Integer id){
        return "/usuario/detalleLugarCreador.xhtml?faces-redirect=true&amp;lugar=" + id;
    }*/
}
