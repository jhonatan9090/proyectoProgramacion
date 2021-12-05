package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;

import java.util.List;

/**
 * este metodo se encarga de listar los usuarios registrados
 */
public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;
    Usuario actualizarUsuario(Usuario u) throws Exception;
    void eliminarUsuario(String codigo) throws Exception;
    List<Usuario> listarUsuarios();
    Usuario obtenerUsuario(String codigo) throws Exception;
    List<Producto>listarProductosFavoritos(String email) throws Exception;
    List<Producto>listarProductoUsuario(String email);
    List<DetalleCompra>listarComprasUsuario(String email);


}
