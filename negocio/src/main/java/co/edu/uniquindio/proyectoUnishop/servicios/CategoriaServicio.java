package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;

import java.util.List;

public interface CategoriaServicio {


    List<Categoria> listarCategorias();
    Categoria obtenerCategoria(Integer codCategoria)throws Exception;
}
