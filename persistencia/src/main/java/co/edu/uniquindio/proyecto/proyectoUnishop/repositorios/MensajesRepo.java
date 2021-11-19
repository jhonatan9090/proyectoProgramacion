package co.edu.uniquindio.proyecto.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Mensajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajesRepo extends JpaRepository<Mensajes,Integer> {
}
