package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
import co.edu.uniquindio.proyectoUnishop.repositorios.ComentarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ComentarioServicioimpl implements ComentarioServicio{


    private final ComentarioRepo comentarioRepo;

    /**
     *
     * @param comentarioRepo este parametro se utiliza para dar los comentarios
     */
    public ComentarioServicioimpl(ComentarioRepo comentarioRepo) {
        this.comentarioRepo = comentarioRepo;
    }

    /**
     *
     * @param codProducto Se utiliza para listar todos los comentarios de un producto buscado pro su codigo
     * @return retorna los comentarios del producto buscado
     * @throws Exception
     */
    @Override
    public List<Comentario> calificacionPromedio(Integer codProducto) throws Exception {
       return comentarioRepo.obtenerPromedioCalificacion(codProducto);
    }
}
