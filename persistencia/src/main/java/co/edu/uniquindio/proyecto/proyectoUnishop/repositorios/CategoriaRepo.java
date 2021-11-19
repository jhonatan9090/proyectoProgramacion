package co.edu.uniquindio.proyecto.proyectoUnishop.repositorios;


<<<<<<< HEAD:persistencia/src/main/java/co/edu/uniquindio/proyectoUnishop/repositorios/CategoriaRepo.java
import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.entidades.Chat;
=======
import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Categoria;
>>>>>>> eb13b040f81a8eeeb3a579a8d178a80e958efeb8:persistencia/src/main/java/co/edu/uniquindio/proyecto/proyectoUnishop/repositorios/CategoriaRepo.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoriaRepo extends JpaRepository<Categoria,Integer> {

    @Query("select ca.codCategoria , max(d.ProductoDetalle) from Compra c join c.listaDetalleCompra d join d.ProductoDetalle.listaCategoria ca where ca.codCategoria = :codCategoria")
    List<Categoria> obtenerProducto(int codCategoria);
}
