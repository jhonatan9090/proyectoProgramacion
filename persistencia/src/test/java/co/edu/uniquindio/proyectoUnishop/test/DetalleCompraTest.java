package co.edu.uniquindio.proyectoUnishop.test;


import co.edu.uniquindio.proyectoUnishop.entidades.*;
import co.edu.uniquindio.proyectoUnishop.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class DetalleCompraTest {

    @Autowired
    private DetalleCompraRepo miDetalleCompraRepo;

    @Autowired
    private ProductoRepo miProductoRepo;

    @Autowired
    private UsuarioRepo miUsuarioRepo;

    @Autowired

    private CiudadRepo miCiudadRepo;

    @Autowired
    private CompraRepo miCompraRepo;

    @Test
    public void crearDetalleCompraTest(){

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
        Assertions.assertNotNull(detalleCompraGuardado);


    }

    @Test
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
    }


    @Test
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
    }

    @Test
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
    }
}
