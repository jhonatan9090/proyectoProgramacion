package co.edu.uniquindio.proyecto.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra,Integer> {
}
