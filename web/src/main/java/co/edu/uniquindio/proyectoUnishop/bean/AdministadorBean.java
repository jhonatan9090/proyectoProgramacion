package co.edu.uniquindio.proyectoUnishop.bean;


import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.DetalleCompraServicio;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
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

    @Getter
    @Setter
    List<DetalleCompra> detalleCompras;

    @PostConstruct
    public void inicializar() {


        detalleCompras = detalleCompraServicio.listarcompras();


    }


    public  void listar(){


        graficarReporte(detalleCompras);


    }

    public void graficarReporte(List<DetalleCompra> listaUsuario) {


        pieChartModel = new PieChartModel();
        for (DetalleCompra d : listaUsuario) {

           pieChartModel.set(d.getProductoDetalle().getNombre(), d.getUnidades());
        }

        pieChartModel.setTitle("Ventas Realizadas");
        pieChartModel.setLegendPosition("e");
        pieChartModel.setFill(false);
        pieChartModel.setShowDataLabels(true);
        pieChartModel.setDiameter(150);
    }

}
