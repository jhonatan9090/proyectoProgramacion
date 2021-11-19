package co.edu.uniquindio.proyecto.proyectoUnishop.repositorios;

<<<<<<< HEAD:persistencia/src/main/java/co/edu/uniquindio/proyectoUnishop/repositorios/ComentarioRepo.java
import co.edu.uniquindio.proyectoUnishop.entidades.Chat;
import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
=======
import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Comentario;
>>>>>>> eb13b040f81a8eeeb3a579a8d178a80e958efeb8:persistencia/src/main/java/co/edu/uniquindio/proyecto/proyectoUnishop/repositorios/ComentarioRepo.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario,Integer> {


    @Query("Select c from Comentario c where c.comentarioProducto.codProducto = :codProducto and c.respuesta is null")
    List<Comentario> obtenerChatPorCodigo(int codProducto);
}
