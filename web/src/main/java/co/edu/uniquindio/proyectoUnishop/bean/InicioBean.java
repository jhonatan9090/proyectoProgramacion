package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@RequestScope
public class InicioBean implements Serializable {



    @Autowired
    private ProductoServicio productoServicio;

    @Getter
    @Setter
    private List<Producto> listaProductos;


    @PostConstruct
    public  void  inicializar(){


        this.listaProductos=productoServicio.listarTodosporProductos();
    }

    /**
     * metodo que muestra los detalles del producto
     * @param idProducto el id del producto
     * @return
     */
    public String irDetalle(Integer idProducto){

      return "detalleProducto?faces-redirect=true&amp;producto="+idProducto;

    }
}
