package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.*;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.CompraRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
//Guarda nuestra prueba en la Base de datos
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired    //instancia variables componentes de springboot
    private CompraRepo miCompraRepo;

    @Autowired    //instancia variables componentes de springboot
    private UsuarioRepo miUsuarioRepo;
    @Autowired
    private CiudadRepo miCiudadRepo;


    //metodo para registrar una Compra
    @Test
    public void registroCompraTest(){

        Ciudad ciudad1=new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);

        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Usuario usuario=new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad1);
        miUsuarioRepo.save(usuario);

        Compra miCompra = new Compra( LocalDate.of(2022,6,25), "Efectivo", usuario );
        Compra compraGuardado=miCompraRepo.save(miCompra);
        Assertions.assertNotNull(compraGuardado);

    }

    //metodo que elimina una Compra
    @Test
    public void eliminarCompraTest(){

        Ciudad ciudad1=new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);

        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Usuario usuario=new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad1);
        miUsuarioRepo.save(usuario);

        Compra compra1 = new Compra(LocalDate.of(2022,6,25), "Efectivo", usuario );
        Compra compraGuardado=miCompraRepo.save(compra1);
        Assertions.assertNotNull(compraGuardado);

        miCompraRepo.delete(compraGuardado);

        Compra compraBuscada= miCompraRepo.findById(1).orElse(null);
        Assertions.assertNull(compraBuscada);
    }


    //metodo que actualiza una Compra
    @Test
    public void actualizarCompraTest(){

        Ciudad ciudad1=new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);

        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Usuario usuario=new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad1);
        miUsuarioRepo.save(usuario);

        Compra compra1 = new Compra(LocalDate.of(2022,6,25), "Efectivo", usuario );
        Compra compraGuardado=miCompraRepo.save(compra1);

        //se modifiaca el dato a cambiar
        compraGuardado.setMedioPago("tarjeta");
        //se vuelve a gurdar
        Compra compraBuscada=miCompraRepo.save(compraGuardado);

        Assertions.assertEquals("tarjeta",compraBuscada.getMedioPago());
    }
    //metodo que busca las Compras
    @Test
    public void listarCompraTest(){

        Ciudad ciudad1=new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);

        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Usuario usuario=new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad1);
        miUsuarioRepo.save(usuario);

        Compra compra1 = new Compra(LocalDate.of(2022,6,25), "Efectivo", usuario );
        Compra compraGuardado=miCompraRepo.save(compra1);

        //se modifiaca el dato a cambiar
        compraGuardado.setMedioPago("tarjeta");
        //se vuelve a gurdar
        miCompraRepo.save(compraGuardado);
        Compra compraEncontrada=miCompraRepo.save(compra1);
        Assertions.assertNotNull(compraEncontrada);

        List<Compra>listaCompra=miCompraRepo.findAll();
        System.out.println(listaCompra);

    }

}
