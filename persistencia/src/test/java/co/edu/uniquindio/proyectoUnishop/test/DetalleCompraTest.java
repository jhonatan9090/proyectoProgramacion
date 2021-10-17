package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.*;
import co.edu.uniquindio.proyectoUnishop.repositorios.*;
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

public class DetalleCompraTest {

    @Autowired//instancia variables componentes de springboot
    private DetalleCompraRepo miDetalleCompraRepo;

    @Autowired//instancia variables componentes de springboot
    private ProductoRepo miProductoRepo;

    @Autowired//instancia variables componentes de springboot
    private UsuarioRepo miUsuarioRepo;

    @Autowired//instancia variables componentes de springboot
    private CiudadRepo miCiudadRepo;

    @Autowired//instancia variables componentes de springboot
    private CompraRepo miCompraRepo;

    /**
     * metodo que crea un detalleCompra
     */
    @Test
    public void crearDetalleCompraTest(){

        Ciudad ciudad=new Ciudad("armenia");
        miCiudadRepo.save(ciudad);
        //Crear un Usuario
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Usuario usuario=new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad);
        miUsuarioRepo.save(usuario);

        //Crear una Compra
        Compra compra1 = new Compra(LocalDate.of(2022,6,25), "Efectivo", usuario );
        miCompraRepo.save(compra1);

        //Crear un Producto
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, ciudad);
        miProductoRepo.save(miProducto);

        //crea la compra detallada
        DetalleCompra detalleCompra= new DetalleCompra(4, 600000.0, miProducto, compra1);

        //guarda la compra detallada
        DetalleCompra detalleCompraGuardado=miDetalleCompraRepo.save(detalleCompra);
        //verifica que la compra detallada no sea null
        Assertions.assertNotNull(detalleCompraGuardado);

    }

    /**
     * metodo para eliminar un detalle de la compra desde el Sql
     */
    @Test
    @Sql("classpath:detalleCompra.sql")
    public void eliminarDetalleCompraTestSql(){

        //elimina una compra detallada desde el sql por el id
        miDetalleCompraRepo.deleteById(1);

        //buscamos para comprobar que el detalle compra fue eliminado
        DetalleCompra detalleBuscado=miDetalleCompraRepo.findById(1).orElse(null);
        Assertions.assertNull(detalleBuscado);
    }




    /**
     * metodo para actualizar un detalle de la compra
     */
    @Test
    @Sql("classpath:detalleCompra.sql")
    public void actualizarDetalleCompraTestSql(){

        //trae una compra detallada del sql por el id
        DetalleCompra miDetalleCompra=miDetalleCompraRepo.findById(1).orElse(null);

        //setteamos el cambio a la compra
        miDetalleCompra.setUnidades(40);

        //guardamos el cambio realizado
        miDetalleCompraRepo.save(miDetalleCompra);

        //buscamos para comprobar si se realizan los cambios
        Assertions.assertEquals(40,miDetalleCompra.getUnidades());

    }


    /**
     *  metodo que lista los detalles de compras
     */
    @Test
    @Sql("classpath:detalleCompra.sql")
    public void listarDetalleCompraTestSql(){

        //trae los datos desde el sql por el id y los guarda en una lista
        List<DetalleCompra>listaDetalleCompra=miDetalleCompraRepo.findAll();

        //imprime los datos de la lista
        for (DetalleCompra misDetalles : listaDetalleCompra) {
            System.out.println(misDetalles);
        }
    }

    //Metodo para eliminar un detalle de compra (sin sql)
    /*  @Test
    public void eliminarDetalleCompraTest(){

        Ciudad ciudad=new Ciudad("armenia");
        miCiudadRepo.save(ciudad);

        //Usuario
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Usuario usuario=new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad);
        miUsuarioRepo.save(usuario);

        //Compra
        Compra compra1 = new Compra(LocalDate.of(2022,6,25), "Efectivo", usuario );
        Compra compraGuardado=miCompraRepo.save(compra1);

        //Producto
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, ciudad);
        Producto productoVender = miProductoRepo.save(miProducto);

        DetalleCompra detalleCompra= new DetalleCompra(4, 600000.0, miProducto, compra1);

        DetalleCompra detalleCompraGuardado=miDetalleCompraRepo.save(detalleCompra);

        miDetalleCompraRepo.delete(detalleCompraGuardado);
        DetalleCompra detalleBuscado=miDetalleCompraRepo.findById(1).orElse(null);
        Assertions.assertNull(detalleBuscado);
    }*/

    //Metodo para actualizar un detalle de compra (sin sql)
    /*   @Test
    public void actualizarDetalleCompraTest(){

        Ciudad ciudad=new Ciudad("armenia");
        miCiudadRepo.save(ciudad);

        //Usuario
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Usuario usuario=new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad);
        miUsuarioRepo.save(usuario);

        //Compra
        Compra compra1 = new Compra(LocalDate.of(2022,6,25), "Efectivo", usuario );
        Compra compraGuardado=miCompraRepo.save(compra1);

        //Producto
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, ciudad);
        Producto productoVender = miProductoRepo.save(miProducto);

        //Detalle
        DetalleCompra detalleCompra= new DetalleCompra(4, 600000.0, miProducto, compra1);
        DetalleCompra detalleCompraGuardado=miDetalleCompraRepo.save(detalleCompra);
        detalleCompraGuardado.setPrecioProducto(666000.9);
        //miDetalleCompraRepo.save(detalleCompraGuardado);
        DetalleCompra detalleBuscado=miDetalleCompraRepo.save(detalleCompra);

        //se busca el DetalleCompra
        Assertions.assertEquals(666000.9,detalleBuscado.getPrecioProducto());
    }*/

    //Metodo para listar los detalle de compras (sin sql)
    /* @Test
    public void listarDetalleCompraTest(){


        Ciudad ciudad=new Ciudad("armenia");
        miCiudadRepo.save(ciudad);

        //Usuario
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Usuario usuario=new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad);
        miUsuarioRepo.save(usuario);

        //Compra
        Compra compra1 = new Compra(LocalDate.of(2022,6,25), "Efectivo", usuario );
        Compra compraGuardado=miCompraRepo.save(compra1);

        //Producto
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, ciudad);
        Producto productoVender = miProductoRepo.save(miProducto);

        DetalleCompra detalleCompra= new DetalleCompra(4, 600000.0, miProducto, compra1);

        DetalleCompra detalleCompraGuardado=miDetalleCompraRepo.save(detalleCompra);


        List<DetalleCompra>listaDetalleCompra=miDetalleCompraRepo.findAll();

        for (DetalleCompra misDetalles : listaDetalleCompra) {
            System.out.println(misDetalles);
        }
    }*/
}
