package co.edu.uniquindio.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyectoUnishop.entidades.DetalleCompra;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {

    List<Usuario> findAllByNombreContains(String nombre);

    Optional<Usuario> findByEmail(String email);

    Page<Usuario> findAll(Pageable paginador);

    @Query("select p from Usuario u, in (u.listaProductoFavorito) p where u.email =: email ")
    List<Producto> obtenerProductosFavoritos(String email);

    @Query("select l from Usuario p,IN (p.listaProductos) l where l.usuarioVendedor.email=:email ")
    List<Producto>listarProductosUsuario(String email);


    @Query("select dc from Usuario u, in (u.listaCompras) l,in(l.listaDetalleCompra) dc where l.UsuarioCompra.email=:email")
    List<DetalleCompra> listarComprasUsuario(String email);


}
