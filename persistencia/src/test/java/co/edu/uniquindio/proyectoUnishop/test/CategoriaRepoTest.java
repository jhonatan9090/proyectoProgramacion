package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.repositorios.CategoriaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.sound.sampled.Port;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaRepoTest {

    @Autowired
    private CategoriaRepo miCategoria;

    @Test
    public void CrearCatergoriaTest() {
        Categoria categoria1 = new Categoria("Electrodomestico");
        Categoria guardarCategoria = miCategoria.save(categoria1);
        Assertions.assertNotNull(guardarCategoria);

    }

    /*@Test
    public void EliminarCategoriaTest() {
        Categoria categoria1 = new Categoria("Electrodomestico");
        Categoria guardarCategoria = miCategoria.save(categoria1);
        miCategoria.delete(guardarCategoria);
        Categoria categoriaBuscada = miCategoria.findById(1).orElse(null);
        Assertions.assertNull(categoriaBuscada);

    }*/
    @Test
    @Sql("classpath:Categoria.sql")
    public void EliminarCategoriaTestSql() {

        miCategoria.deleteById(2);
        Categoria categoriaBuscada = miCategoria.findById(2).orElse(null);
        Assertions.assertNull(categoriaBuscada);

    }

  /*  @Test
    public void ActualizarCategoriaTest() {
        Categoria categoria1 = new Categoria("Electrodomestico");
        Categoria guardarCategoria = miCategoria.save(categoria1);
        guardarCategoria.setNombre("Video Juegos");
        miCategoria.save(guardarCategoria);
        Categoria categoriaBuscada = miCategoria.findById(1).orElse(null);
        Assertions.assertEquals("Video Juegos", categoriaBuscada.getNombre());

    }*/
    @Test
    @Sql("classpath:Categoria.sql")
    public void ActualizarCategoriaTestSql() {


        Categoria categoriaGuardada = miCategoria.findById(1).orElse(null);
        categoriaGuardada.setNombre("Video Juegos");
        miCategoria.save(categoriaGuardada);
        Categoria categoriaBuscada = miCategoria.findById(1).orElse(null);
        Assertions.assertEquals("Video Juegos", categoriaBuscada.getNombre());

    }

    /*@Test
    public void ListarCategoriaTest() {
        Categoria categoria1 = new Categoria("Electrodomestico");
        miCategoria.save(categoria1);
        List<Categoria> listaCategoria = miCategoria.findAll();
        for (Categoria misCategorias : listaCategoria) {
            System.out.println(misCategorias);
        }
    }*/
    @Test
    @Sql("classpath:Categoria.sql")
    public void ListarCategoriaTestSql() {


        List<Categoria> listaCategoria = miCategoria.findAll();
        for (Categoria misCategorias : listaCategoria) {
            System.out.println(misCategorias);
        }
    }


}
