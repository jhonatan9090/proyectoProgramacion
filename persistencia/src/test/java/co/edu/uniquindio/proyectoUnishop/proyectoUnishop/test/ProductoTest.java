package co.edu.uniquindio.proyectoUnishop.proyectoUnishop.test;


import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.ProductoRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {


    @Autowired
    private ProductoRepo miProductoRepo;

    @Autowired
    private UsuarioRepo miUsuarioRepo;

    @Autowired
    private CiudadRepo miCiudadRepo;

    /**
     * metodo que crea un producto
     */
    @Test
    public void crearProductoTest(){

        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);

        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Maria Perez", "mariaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario usuario = miUsuarioRepo.save(usuario1);

        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("televisor", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, miCiudad);
        Producto productoVender = miProductoRepo.save(miProducto);

        Producto productoGuardado=miProductoRepo.save( productoVender);
        Assertions.assertNotNull(productoGuardado);

    }


    /**
     * metodo para eliminar un producto desde el Sql
     */
    @Test
    @Sql("classpath:producto.sql")
    public void eliminarProductoTestSql(){

        miProductoRepo.deleteById(3);
        Producto productoBuscado=miProductoRepo.findById(3).orElse(null);
        Assertions.assertNull(productoBuscado);

    }


    /**
     * Metodo para actualizar los datos de un producto
     */
    @Test
    @Sql("classpath:producto.sql")
    public void actualizarProductoTestSql(){

        //Vendedor producto
        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);

        //Crea un usuario
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("151", "Maria Perez", "mariaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario usuario = miUsuarioRepo.save(usuario1);

        //Busca el producto mediante el codigo
        Producto productoBuscado=miProductoRepo.findById(1).orElse(null);
        productoBuscado.setUsuarioVendedor(usuario);
        Assertions.assertEquals("151",productoBuscado.getUsuarioVendedor().getCodPersona());


    }


    /**
     * Metodo para listar los mensajes guardados en sql
     */
    @Test
    @Sql("classpath:producto.sql")
    public void listarProductosTestSql(){

        //se guardan los datos del sql en una lista
        List<Producto>listaProductos=miProductoRepo.findAll();

        //el for se usa para mostrar los datos guardados en la lista
        for (Producto misProductos: listaProductos) {
            System.out.println(misProductos);
        }
    }

    @Test
    @Sql("classpath:producto.sql")
    public void listarCategoria(){

        //se guardan los datos del sql en una lista

        List<Object[]> listaProductos=miProductoRepo.ListarProductosPorCategoria("Tecnologia");

        //el for se usa para mostrar los datos guardados en la lista
        for (Object[] misProductos: listaProductos) {
            System.out.println(misProductos[0]+" "+misProductos[1]);
        }
    }

    @Test
    @Sql("classpath:producto.sql")
    public void listarCompras(){

        //se guardan los datos del sql en una lista

        List<Object[]> listaProductos=miProductoRepo.ListarComprasUsuario("123");

        //el for se usa para mostrar los datos guardados en la lista
        for (Object[] misProductos: listaProductos) {
            System.out.println(misProductos[0]+" "+misProductos[1]+" "+misProductos[2]);
        }
    }

    @Test
    @Sql("classpath:producto.sql")
    public void listarVentas(){

        //se guardan los datos del sql en una lista

        List<Object[]> listaProductos=miProductoRepo.ListarProductosDelUsuario("123");

        //el for se usa para mostrar los datos guardados en la lista
        for (Object[] misProductos: listaProductos) {
            System.out.println(misProductos[0]+" "+misProductos[1]+" "+misProductos[2]);
        }
    }
    //Metodo para eliminar un producto (sin sql)
    /* @Test
    public void eliminarProductoTest(){

        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);

        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Maria Perez", "mariaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario usuario = miUsuarioRepo.save(usuario1);

        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("televisor", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, miCiudad);
        //eliminar producto
        Producto productoGuardado=miProductoRepo.save(miProducto);
        miProductoRepo.delete(productoGuardado);
        Producto productoBuscado=miProductoRepo.findById(1).orElse(null);
        Assertions.assertNull(productoBuscado);
    }*/

    //Metodo para actualizar un producto (sin sql)
    /*@Test
    public void actualizarProductoTest(){

        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);

        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Maria Perez", "mariaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario usuario = miUsuarioRepo.save(usuario1);

        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("televisor", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, miCiudad);
        Producto productoGuardado=miProductoRepo.save(miProducto);

        productoGuardado.setNombre("Computador");
        Producto productoBuscado = miProductoRepo.save(productoGuardado);

        Assertions.assertEquals("Computador",productoBuscado.getNombre());
    }*/

    //Metodo para listar productos (sin sql)
    /* @Test
    public void listarProductosTest(){

        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);

        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Maria Perez", "mariaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario usuario = miUsuarioRepo.save(usuario1);

        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("televisor", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, miCiudad);
        Producto productoGuardado=miProductoRepo.save(miProducto);

        productoGuardado.setNombre("Computador");
        miProductoRepo.save(productoGuardado);

        List<Producto>listaProductos=miProductoRepo.findAll();

        for (Producto misProductos: listaProductos) {
            System.out.println(misProductos);
        }
    }*/
}