package co.edu.uniquindio.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    @Query("Select p.nombre,c.nombre from Producto p join p.listaCategoria c where c.nombre=:nombreCategoria")
    List<Object[]> ListarProductosPorCategoria(String nombreCategoria);
}
