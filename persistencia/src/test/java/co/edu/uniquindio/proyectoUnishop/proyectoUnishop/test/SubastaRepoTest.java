package co.edu.uniquindio.proyectoUnishop.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Subasta;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.ProductoRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.SubastaRepo;
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
public class SubastaRepoTest {

    @Autowired
    private SubastaRepo miSubasta;

    @Autowired
    private ProductoRepo miProducto;

    @Autowired
    private CiudadRepo miCiudad;

    @Autowired
    private UsuarioRepo miUsuario;

    /**
     *  metodo para crear una nueva subasta
     */
    @Test
    public void CrearSubastaTest() {
        Ciudad ciudad1 = new Ciudad("Armenia");
        miCiudad.save(ciudad1);
        //este es el usuario que se crea para la subasta
        Ciudad ciudad2 = new Ciudad("Pereira");
        miCiudad.save(ciudad2);
        List<String> listaImagenes = new ArrayList<>();
        listaImagenes.add("loquesea");

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, ciudad2);
        usuario1.setTelefono(telefonos);
        Usuario usuarioGuardado = miUsuario.save(usuario1);

        Producto producto1 = new Producto("computador", 2, "Muy rapido", 20000.00, LocalDate.of(2022, 12, 2), 19.0, listaImagenes, usuarioGuardado, ciudad1);
        Producto productoGuardado = miProducto.save(producto1);

        Subasta subasta1 = new Subasta(LocalDate.of(2022, 9, 21), productoGuardado);
        Subasta subastaGuardada = miSubasta.save(subasta1);
        Assertions.assertNotNull(subastaGuardada);
    }


    /**
     * metodo para eliminar una subasta desde el Sql
     */
    @Test
    @Sql("classpath:subasta.sql")
    public void EliminaSubastaTestSql() {

        //sebusca la subasta en el sql por su codigo para eliminar
        miSubasta.deleteById(3);
        //se verifica que la subasta fue eliminada
        Subasta subastaBuscar = miSubasta.findById(3).orElse(null);
        Assertions.assertNull(subastaBuscar);

    }


    /**
     * metodo para actualizar la informacon de las subastas
     */
    @Test
    @Sql("classpath:subasta.sql")
    public void ActualizarSubastaTest() {

        //se trae una subasta desde el sql por medio del id
        Subasta subastaBuscar = miSubasta.findById(1).orElse(null);
        //se modifica la fecha de la subasta en el sql por la escrita abajo
        subastaBuscar.setFechaLimite(LocalDate.of(2023,2,3));
        //se guardan los cambios realizados a la subasta en el sql
        miSubasta.save(subastaBuscar);
        //se verifica que se hayan echs los cambios pertinentes en el sql
        Assertions.assertEquals(LocalDate.of(2023, 2, 3),subastaBuscar.getFechaLimite());
    }


    /**
     * metodo para listar las subastas guardadas en el sql
     */
    @Test
    @Sql("classpath:subasta.sql")
    public void ListarSubastaTestSql() {

        //Se guardan los datos del sql en una lista
        List<Subasta> listaSubasta = miSubasta.findAll();

        //el for se usa para mostrar los datos guardados en la lista
        for (Subasta misubasta : listaSubasta) {
            System.out.println(misubasta);
        }
    }

    //Metodo para eliminar una subasta (sin sql)
    /*@Test
    public void EliminaSubastaTest() {
        Ciudad ciudad1 = new Ciudad("Armenia");
        miCiudad.save(ciudad1);
        //este es el usuario que se crea para la subasta
        Ciudad ciudad2 = new Ciudad("Pereira");
        miCiudad.save(ciudad2);
        List<String> listaImagenes = new ArrayList<>();
        listaImagenes.add("loquesea");

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, ciudad2);
        usuario1.setTelefono(telefonos);
        Usuario usuarioGuardado = miUsuario.save(usuario1);

        Producto producto1 = new Producto("computador", 2, "Muy rapido", 20000.00, LocalDate.of(2022, 12, 2), 19.0, listaImagenes, usuarioGuardado, ciudad1);
        Producto productoGuardado = miProducto.save(producto1);

        Subasta subasta1 = new Subasta(LocalDate.of(2022, 9, 21), productoGuardado);
        Subasta subastaGuardada = miSubasta.save(subasta1);
        miSubasta.delete(subastaGuardada);
        Subasta subastaBuscar = miSubasta.findById(1).orElse(null);
        Assertions.assertNull(subastaBuscar);
    }*/

    //Metodo para actualizar una subasta (sin sql)
    /*@Test
    public void ActualizarSubastaTest() {
        Ciudad ciudad1 = new Ciudad("Armenia");
        miCiudad.save(ciudad1);
        //este es el usuario que se crea para la subasta
        Ciudad ciudad2 = new Ciudad("Pereira");
        miCiudad.save(ciudad2);
        List<String> listaImagenes = new ArrayList<>();
        listaImagenes.add("loquesea");

        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, ciudad2);
        usuario1.setTelefono(telefonos);
        Usuario usuarioGuardado = miUsuario.save(usuario1);

        Producto producto1 = new Producto("computador", 2, "Muy rapido", 20000.00, LocalDate.of(2022, 12, 2), 19.0, listaImagenes, usuarioGuardado, ciudad1);
        Producto productoGuardado = miProducto.save(producto1);

        Subasta subasta1 = new Subasta(LocalDate.of(2022, 9, 21), productoGuardado);
        Subasta subastaGuardada = miSubasta.save(subasta1);

        subastaGuardada.setFechaLimite(LocalDate.of(2023, 2, 3));
        Subasta subastaBuscada = miSubasta.save(subastaGuardada);

        Assertions.assertEquals(LocalDate.of(2023, 2, 3), subastaBuscada.getFechaLimite());
    }
*/

    //Metodo para listar las subastas (sin sql)
    /* @Test
     public void ListarSubastaTest(){
         Ciudad ciudad1 = new Ciudad("Armenia");
         miCiudad.save(ciudad1);
         //este es el usuario que se crea para la subasta
         Ciudad ciudad2=new Ciudad("Pereira");
         miCiudad.save(ciudad2);
         List<String> listaImagenes = new ArrayList<>();
         listaImagenes.add("loquesea");

         Map<String,String> telefonos=new HashMap<>();
         telefonos.put("casa","321414");
         telefonos.put("celular","321452514");
         Usuario usuario1=new Usuario("111","Luisa Perez","luisaPe@","12345",telefonos,ciudad2);
         usuario1.setTelefono(telefonos);
         Usuario usuarioGuardado=miUsuario.save(usuario1);

         Producto producto1 = new Producto("computador",2,"Muy rapido",20000.00, LocalDate.of(2022,12,2),19.0,listaImagenes,usuarioGuardado,ciudad1);
         Producto productoGuardado = miProducto.save(producto1);

         Subasta subasta1 = new Subasta(LocalDate.of(2022,9,21),productoGuardado);
         miSubasta.save(subasta1);
         List<Subasta> listaSubasta = miSubasta.findAll();
         for (Subasta misubasta: listaSubasta){
             System.out.println(misubasta);
         }
     }
     */
}