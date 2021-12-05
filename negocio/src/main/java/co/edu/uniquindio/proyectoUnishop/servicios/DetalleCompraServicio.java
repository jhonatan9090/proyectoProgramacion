package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * este metodo es para lbuscar los detalles de la compra
 */
public interface DetalleCompraServicio {

DetalleCompra buscarDetalleId(Integer idDetalle) throws Exception;

}
