package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;

import java.util.List;
/**
 *En esta parte se crea la lista categoria
 */
public interface CategoriaServicio {
    List<Categoria> listarCategorias();
    Categoria obtenerCategoria(Integer codCategoria)throws Exception;
}
