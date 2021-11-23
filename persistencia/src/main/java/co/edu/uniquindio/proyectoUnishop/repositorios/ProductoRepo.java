package co.edu.uniquindio.proyectoUnishop.repositorios;

import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {


    //lista los productos por categoria
    @Query("Select p from Producto p join p.listaCategoria c where c.nombre=:nombreCategoria")
    List<Producto> ListarProductosPorCategoria(String nombreCategoria);

    //lista las compras del usuario
    @Query("Select p.nombre,dc.unidades,c.medioPago from Producto p join p.listaDetalles dc join dc.compradetalle c where c.UsuarioCompra.codPersona=:idUsuario")
    List<Object[]> ListarComprasUsuario(String idUsuario);

    //listra los productos que el usuario vende
    @Query("Select p.nombre,p.unidades,p.descripcion from Producto p join p.usuarioVendedor v where v.codPersona=:idUsuario")
    List<Object[]> ListarProductosDelUsuario(String idUsuario);


    //listar producto por nombre
    @Query("select p from Producto p where p.nombre like concat('%',:nombreProducto,'%' ) ")
    List<Producto>listarProductoNombre(String nombreProducto);





}
