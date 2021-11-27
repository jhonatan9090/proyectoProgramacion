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


@Component
@ViewScoped
public class detalleProductoBean implements Serializable {


    @Autowired
    private ProductoServicio productoServicio;


    @Value("#{param['producto']}")
    private String codProducto;


    @Getter
    @Setter
    private Producto producto;


    @PostConstruct
    public void inicializar() {

        if (codProducto != null && !codProducto.isEmpty()) {

            try {
                producto = productoServicio.buscarProducto(Integer.parseInt(codProducto));
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }

}
