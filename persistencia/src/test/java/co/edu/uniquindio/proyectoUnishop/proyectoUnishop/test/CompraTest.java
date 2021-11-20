package co.edu.uniquindio.proyectoUnishop.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Compra;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.CompraRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * metodo para registrar una Compra
     */
    @Test
    public void registroCompraTest() {

        // se inicializa una ciudad
        Ciudad ciudad1 = new Ciudad("armenia");

        //se guarda la ciudad
        miCiudadRepo.save(ciudad1);

        // se inicializa un cliente
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");

        Usuario usuario = new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad1);

        //se guarda el usurio
        miUsuarioRepo.save(usuario);

        //se crea la compra
        Compra miCompra = new Compra(LocalDate.of(2022, 6, 25), "Efectivo", usuario);

        // se guarda la compra
        Compra compraGuardado = miCompraRepo.save(miCompra);
        Assertions.assertNotNull(compraGuardado);

    }


    /**
     * metodo para eliminar una compra desde el Sql
     */
    @Test
    @Sql("classpath:compra.sql")
    public void eliminarCompraTestSql() {

        //se eliminla compra por medio del id
        miCompraRepo.deleteById(2);

        //se busca para comprobar si ya se elimino
        Compra compraBuscada = miCompraRepo.findById(2).orElse(null);
        Assertions.assertNull(compraBuscada);

    }


    /**
     * metodo que actualiza una Compra
     */
    @Test
    @Sql("classpath:compra.sql")
    public void actualizarCompraTestSql() {

        //trae la compra del sql por el id
        Compra compraRealizada = miCompraRepo.findById(1).orElse(null);

        //se le settea la nueva info
        compraRealizada.setMedioPago("daviplata");

        //se guarda el cambio realizado
        Compra compraBuscada = miCompraRepo.save(compraRealizada);

        //se busca si el cambio fue hecho correctamente
        Assertions.assertEquals("daviplata", compraBuscada.getMedioPago());


    }

    /**
     * Metodo para listar las compras guardadas en sql
     */
    @Test
    @Sql("classpath:compra.sql")
    public void listarCompraTestSql() {

        //busca las compras y las guarda en una lisy
        List<Compra> listaCompra = miCompraRepo.findAll();

        //imprime las compras
        for (Compra misCompras : listaCompra) {
            System.out.println(misCompras);
        }
    }

    //Metodo para eliminar una compra (sin sql)
    /*@Test
    public void eliminarCompraTest() {

        Ciudad ciudad1 = new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");

        Usuario usuario = new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad1);
        miUsuarioRepo.save(usuario);

        Compra compra1 = new Compra(LocalDate.of(2022, 6, 25), "Efectivo", usuario);
        Compra compraGuardado = miCompraRepo.save(compra1);
        Assertions.assertNotNull(compraGuardado);

        miCompraRepo.delete(compraGuardado);

        Compra compraBuscada = miCompraRepo.findById(1).orElse(null);
        Assertions.assertNull(compraBuscada);
    }*/

    //Metodo para eliminar una compra (sin sql)
    /*@Test
    public void actualizarCompraTest() {

        Ciudad ciudad1 = new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");

        Usuario usuario = new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad1);
        miUsuarioRepo.save(usuario);

        Compra compra1 = new Compra(LocalDate.of(2022, 6, 25), "Efectivo", usuario);
        Compra compraGuardado = miCompraRepo.save(compra1);

        //se modifiaca el dato a cambiar
        compraGuardado.setMedioPago("tarjeta");
        //se vuelve a gurdar
        Compra compraBuscada = miCompraRepo.save(compraGuardado);

        Assertions.assertEquals("tarjeta", compraBuscada.getMedioPago());
    }*/

    //Metodo para listar las compras (sin sql)
    /*  @Test
      public void listarCompraTest() {

          Ciudad ciudad1 = new Ciudad("armenia");
          miCiudadRepo.save(ciudad1);

          Map<String, String> telefonos = new HashMap<>();
          telefonos.put("casa", "321414");
          telefonos.put("celular", "321452514");

          Usuario usuario = new Usuario("123", "Aleja", "aleja@gmail.com", "3456", telefonos, ciudad1);
          miUsuarioRepo.save(usuario);

          Compra compra1 = new Compra(LocalDate.of(2022, 6, 25), "Efectivo", usuario);
          Compra compraGuardado = miCompraRepo.save(compra1);

          //se modifiaca el dato a cambiar
          compraGuardado.setMedioPago("tarjeta");
          //se vuelve a gurdar
          miCompraRepo.save(compraGuardado);
          Compra compraEncontrada = miCompraRepo.save(compra1);
          Assertions.assertNotNull(compraEncontrada);

          List<Compra> listaCompra = miCompraRepo.findAll();
          System.out.println(listaCompra);

      }*/

}
