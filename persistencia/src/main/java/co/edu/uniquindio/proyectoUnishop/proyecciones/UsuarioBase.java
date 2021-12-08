package co.edu.uniquindio.proyectoUnishop.proyecciones;

import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;


import java.util.List;


public interface UsuarioBase {
    String getNombre();
    String getEmail();
    List<String> getTelefonos();
}
