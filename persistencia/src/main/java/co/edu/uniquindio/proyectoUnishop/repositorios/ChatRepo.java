package co.edu.uniquindio.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyectoUnishop.entidades.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Integer> {

   /* @Query("select c from  Chat c where c.chatProductoCompra.usuarioVendedor.codPersona=:codPersona")
    List<Chat> obtenerChatPorCodigo(String codPersona);*/
}
