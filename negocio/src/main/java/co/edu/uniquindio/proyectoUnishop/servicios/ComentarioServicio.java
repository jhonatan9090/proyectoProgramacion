package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;

import java.util.List;

public interface ComentarioServicio {

    /**
     *
     * @param codProducto Se utiliza para listar todos los comentarios de un producto buscado pro su codigo
     * @return el comentario del producrto
     * @throws Exception
     */
    List<Comentario> calificacionPromedio(Integer codProducto) throws Exception;
}
