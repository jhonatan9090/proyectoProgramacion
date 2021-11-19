package co.edu.uniquindio.proyecto.proyecto.servicios;

import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;

    Usuario actualizarUsuario(Usuario u) throws Exception;

    void eliminarUsuario(String codigo) throws Exception;

    List<Usuario> listarUsuarios();

    Usuario obtenerUsuario(String codigo) throws Exception;

}
