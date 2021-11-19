package co.edu.uniquindio.proyecto.proyectoUnishop.repositorios;


<<<<<<< HEAD:persistencia/src/main/java/co/edu/uniquindio/proyectoUnishop/repositorios/ChatRepo.java
import co.edu.uniquindio.proyectoUnishop.entidades.Chat;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
=======
import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Chat;
>>>>>>> eb13b040f81a8eeeb3a579a8d178a80e958efeb8:persistencia/src/main/java/co/edu/uniquindio/proyecto/proyectoUnishop/repositorios/ChatRepo.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Integer> {

    @Query("select c from  Chat c where c.chatProductoCompra.usuarioVendedor.codPersona=:codPersona")
    List<Chat> obtenerChatPorCodigo(String codPersona);
}
