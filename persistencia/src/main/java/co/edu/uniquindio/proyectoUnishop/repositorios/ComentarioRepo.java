package co.edu.uniquindio.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario,Integer> {
}
