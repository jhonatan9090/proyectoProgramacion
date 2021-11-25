package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;

import java.util.List;

public interface CiudadServicio {



    List<Ciudad>listaCiudad();

    Ciudad ObtenerCiudadCodigo(Integer codCiudad) throws Exception;
}
