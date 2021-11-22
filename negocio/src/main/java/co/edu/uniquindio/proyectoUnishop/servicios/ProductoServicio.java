package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;

import java.util.List;

public interface ProductoServicio {


    Producto publicarProducto(Producto p) throws  Exception;
    void  actualizarProducto(Producto p) throws Exception;
    void eliminarProducto(Integer idProdcuto) throws Exception;
    Producto buscarProducto(Integer idProducto)throws Exception;
    List<Object[]> listarporCategoria(Categoria categoria) throws Exception;
    void comentarProducto(Comentario comentario) throws Exception;
    void guardarProductoFavorito(Usuario usuario,Producto producto) throws Exception;
    void eliminarProductoFavorito(Usuario usuario,Producto producto) throws Exception;
    List<Object[]>buscarProductoFiltro(String nonbre,String [] filtro) throws Exception;


}
