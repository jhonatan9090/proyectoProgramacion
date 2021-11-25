package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.CategoriaServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class ProductoBean implements Serializable {

    @Getter
    @Setter
    private Producto producto;



    private final CategoriaServicio categoriaServicio;

    private final ProductoServicio productoServicio;

    private final UsuarioServicio usuarioServicio;

    @Getter
    @Setter
    private List<Categoria> listaCategorias;

    public ProductoBean(ProductoServicio productoServicio, UsuarioServicio usuarioServicio, CategoriaServicio categoriaServicio) {
        this.productoServicio = productoServicio;
        this.usuarioServicio = usuarioServicio;
        this.categoriaServicio = categoriaServicio;
    }

    @PostConstruct
    public void inicializar(){

        this.producto = new Producto();
        listaCategorias= categoriaServicio.listarCategorias();
    }

    public String crearProducto(){
        try {
            Usuario usuario = usuarioServicio.obtenerUsuario("1");
            producto.setUsuarioVendedor(usuario);
            productoServicio.publicarProducto(producto);
            return "productoCreado?faces-redirect=true";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return  null;
    }
}
