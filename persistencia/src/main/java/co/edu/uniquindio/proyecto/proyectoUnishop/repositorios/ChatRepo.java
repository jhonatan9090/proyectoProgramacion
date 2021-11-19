package co.edu.uniquindio.proyecto.proyectoUnishop.repositorios;


import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Integer> {
}
