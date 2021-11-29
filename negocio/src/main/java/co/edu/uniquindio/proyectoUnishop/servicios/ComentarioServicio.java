package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;

import java.util.List;

public interface ComentarioServicio {


    List<Comentario> calificacionPromedio(Integer codProducto) throws Exception;
}
