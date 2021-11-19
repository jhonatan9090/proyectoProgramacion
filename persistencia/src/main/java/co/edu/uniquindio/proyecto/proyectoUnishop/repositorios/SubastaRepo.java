package co.edu.uniquindio.proyecto.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubastaRepo extends JpaRepository<Subasta,Integer> {
}
