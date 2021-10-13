package co.edu.uniquindio.proyectoUnishop.repositorios;


import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepo extends JpaRepository<Categoria,Integer> {
}
