package co.edu.uniquindio.proyectoUnishop.bean;


import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
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

    @Getter
    @Setter
    List<DetalleCompra> detalleCompras;

    @Getter
    @Setter
    List<Producto> productos;

    @PostConstruct
    public void inicializar() {


        detalleCompras = detalleCompraServicio.listarcompras();
        productos = productoServicio.listarTodosporProductos();


    }


    public void listar() {


        graficarReporteVentas(detalleCompras);


    }


    public void listar2() {


        graficarPreciosProductos(productos);


    }

    ;

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


}
