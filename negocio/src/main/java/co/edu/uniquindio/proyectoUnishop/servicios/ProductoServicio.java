package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.dto.ProductoCarrito;
import co.edu.uniquindio.proyectoUnishop.entidades.*;

import java.util.ArrayList;
import java.util.List;

/**
 * este metodo se conecta con el crud de los produtos para trabajar con sus datos
 */
public interface ProductoServicio {


    Producto publicarProducto(Producto p) throws  Exception;
    Producto actualizarProducto(Producto p) throws Exception;
    void eliminarProducto(Integer idProdcuto) throws Exception;
    Producto buscarProducto(Integer idProducto)throws Exception;
    List<Producto> listarporCategoria(String categoriaNombre) throws Exception;
    List<Producto> listarTodosporProductos();
    void comentarProducto(Comentario comentario) throws Exception;
    Float obtenerPromedioProducto(Integer codProducto);
    void guardarProductoFavorito(Usuario usuario,Producto producto) throws Exception;
    void eliminarProductoFavorito(Usuario usuario,Producto producto) throws Exception;
    List<Producto>buscarProductoFiltro(String nonbre,String [] filtro) ;
    Compra compraProductos(Usuario usuarioCompra, ArrayList<ProductoCarrito>productoCarritos,String medioPago) throws Exception;



}
