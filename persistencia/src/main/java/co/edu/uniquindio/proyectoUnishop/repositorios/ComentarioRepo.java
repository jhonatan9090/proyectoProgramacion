package co.edu.uniquindio.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyectoUnishop.entidades.Chat;
import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario,Integer> {


    @Query("Select c from Comentario c where c.comentarioProducto.codProducto = :codProducto and c.respuesta is null")
    List<Comentario> obtenerChatPorCodigo(int codProducto);
}
