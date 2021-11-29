package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
import co.edu.uniquindio.proyectoUnishop.repositorios.ComentarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServicioimpl implements ComentarioServicio{


    private final ComentarioRepo comentarioRepo;

    public ComentarioServicioimpl(ComentarioRepo comentarioRepo) {
        this.comentarioRepo = comentarioRepo;
    }

    @Override
    public List<Comentario> calificacionPromedio(Integer codProducto) throws Exception {
       return comentarioRepo.obtenerPromedioCalificacion(codProducto);
    }
}
