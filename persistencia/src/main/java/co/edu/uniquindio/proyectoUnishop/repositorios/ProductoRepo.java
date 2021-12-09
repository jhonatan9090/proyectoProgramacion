package co.edu.uniquindio.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {


    //lista los productos por categoria

    @Query("select p from Producto p join p.listaCategoria  c where c.nombre=:nombre")
    List<Producto>ListarProductosPorCategoria(String nombre);

    @Query("select p from Producto p join p.ciudadProducto  c where c.nombre=:nombre")
    List<Producto>ListarProductosPorCiudad(String nombre);

    Optional<Producto>findByDescripcionContains(String descripcion);

    @Query("select p from Producto p where p.descripcion like concat('%',:descripcion,'%' ) ")
    List<Producto> ListarProductosPorDescripcion(Optional<Producto> descripcion);

   /* //lista las compras del usuario
    @Query("Select p.nombre,dc.,c.medioPago from Producto p join p.listaDetalles dc join dc.compradetalle c where c.UsuarioCompra.codPersona=:idUsuario")
    List<Object[]> ListarComprasUsuario(String idUsuario);

    //listra los productos que el usuario vende
    @Query("Select p.nombre,p.unidades,p.descripcion from Producto p join p.usuarioVendedor v where v.codPersona=:idUsuario")
    List<Object[]> ListarProductosDelUsuario(String idUsuario);*/

    @Query("select AVG (c.calificacion) from Producto p join p.ListaComentariosProductos c  where c.comentarioProducto.codProducto=:codProducto")
    Float obtenerPromedioCalificacion(Integer codProducto);

    //listar producto por nombre
    @Query("select p from Producto p where p.nombre like concat('%',:nombreProducto,'%' ) ")
    List<Producto>listarProductoNombre(String nombreProducto);





}
