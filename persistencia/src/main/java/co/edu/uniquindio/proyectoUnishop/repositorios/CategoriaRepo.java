package co.edu.uniquindio.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoriaRepo extends JpaRepository<Categoria,Integer> {

    @Query("select ca.codCategoria , max(d.ProductoDetalle) from Compra c join c.listaDetalleCompra d join d.ProductoDetalle.listaCategoria ca where ca.codCategoria = :codCategoria")
    List<Categoria> obtenerProducto(int codCategoria);
}
