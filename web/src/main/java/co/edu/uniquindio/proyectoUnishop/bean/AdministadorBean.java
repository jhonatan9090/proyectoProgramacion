package co.edu.uniquindio.proyectoUnishop.bean;


import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.servicios.CiudadServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.DetalleCompraServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class AdministadorBean {


    @Getter
    @Setter
    private PieChartModel pieChartModel;

    @Getter
    @Setter
    private DetalleCompra detalleCompra;

    @Autowired
    DetalleCompraServicio detalleCompraServicio;

    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    CiudadServicio ciudadServicio;

    @Getter
    @Setter
    List<DetalleCompra> detalleCompras;

    @Getter
    @Setter
    List<Producto> productos;

    @Getter
    @Setter
    List<Ciudad> ciudades;


    @PostConstruct
    public void inicializar() {


        detalleCompras = detalleCompraServicio.listarcompras();
        productos = productoServicio.listarTodosporProductos();
        ciudades=ciudadServicio.listaCiudad();


    }


    public void listar() {


        graficarReporteVentas(detalleCompras);


    }


    public void listar2() {


        graficarPreciosProductos(productos);


    }

    public void listar3() {


        graficarProductosEnStock(productos);


    }

    public void listar4() {


        graficarDescuentos(productos);


    }

    public void listar5() {


       graficarCiudades(detalleCompras);


    }


    public void graficarReporteVentas(List<DetalleCompra> listaUsuario) {


        pieChartModel = new PieChartModel();
        for (DetalleCompra d : listaUsuario) {

            pieChartModel.set(d.getProductoDetalle().getNombre(), d.getUnidades());
        }

        pieChartModel.setTitle("Graficos de Ventas");
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(false);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(150);
    }


    public void graficarPreciosProductos(List<Producto> listaProductos) {


        pieChartModel = new PieChartModel();
        for (Producto p : listaProductos) {

            pieChartModel.set(p.getNombre(), p.getPrecio());
        }

        pieChartModel.setTitle("Grafico de Precios");
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(false);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(150);
    }


    public void graficarProductosEnStock(List<Producto> listaProductos) {


        pieChartModel = new PieChartModel();
        for (Producto p : listaProductos) {

            pieChartModel.set(p.getNombre(), p.getUnidades());
        }

        pieChartModel.setTitle("Grafico de Precios");
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(false);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(150);
    }

    public void graficarDescuentos(List<Producto> listaProductos) {


        pieChartModel = new PieChartModel();
        for (Producto p : listaProductos) {

            pieChartModel.set(p.getNombre(), p.getDescuento());
        }

        pieChartModel.setTitle("Grafico de Descuentos");
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(false);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(150);
    }


    public void graficarCiudades(List<DetalleCompra> detalleCompras) {


        pieChartModel = new PieChartModel();
        for (DetalleCompra dc : detalleCompras) {

            pieChartModel.set(dc.getProductoDetalle().getCiudadProducto().getNombre(),dc.getUnidades());
        }

        pieChartModel.setTitle("Ciudades con mas Ventas");
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(false);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(150);
    }

}
