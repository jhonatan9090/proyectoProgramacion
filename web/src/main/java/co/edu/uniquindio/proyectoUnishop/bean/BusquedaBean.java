package co.edu.uniquindio.proyectoUnishop.bean;

import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;


@Component
@ViewScoped
public class BusquedaBean implements Serializable {

    //escribo el paramentro que envio a la url
    @Getter
    @Setter
    private String busqueda;

    //captura parametro que viene por la url
    @Getter
    @Setter
    @Value("#{ param['busqueda']}")
    private String busquedaParam;

    @Getter
    @Setter
    private List<Producto>productosBuscados;

    @Autowired
    ProductoServicio productoServicio;


    @PostConstruct
    public  void inicializar(){

    if (busquedaParam!=null&& !busquedaParam.isEmpty()){

        productosBuscados=productoServicio.buscarProductoFiltro(busquedaParam,null);

    }

    }
    public String buscar(){


        return "resultadoBusqueda?faces-redirect=true&amp;busqueda="+busqueda;
    }
}
