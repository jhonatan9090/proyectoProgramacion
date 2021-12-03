package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;
    Usuario actualizarUsuario(Usuario u) throws Exception;
    void eliminarUsuario(String codigo) throws Exception;
    List<Usuario> listarUsuarios();
    Usuario obtenerUsuario(String codigo) throws Exception;
    List<Producto>listarProductosFavoritos(String email) throws Exception;
    List<Producto>listarProductoUsuario(String email);


}
