package co.edu.uniquindio.proyecto.proyectoUnishop.test;

import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyecto.proyectoUnishop.repositorios.CategoriaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaRepoTest {

    @Autowired
    private CategoriaRepo miCategoria;

    /**
     * metodo para registrar una categoria
     */
    @Test
    public void CrearCatergoriaTest() {

        Categoria categoria1 = new Categoria("Electrodomestico");

        //Guarda la nueva categoria
        Categoria guardarCategoria = miCategoria.save(categoria1);
        Assertions.assertNotNull(guardarCategoria);

    }


    /**
     * metodo para eliminar una categoria desde el Sql
     */
    @Test
    @Sql("classpath:Categoria.sql")
    public void EliminarCategoriaTestSql() {

        miCategoria.deleteById(2);
        Categoria categoriaBuscada = miCategoria.findById(2).orElse(null);
        Assertions.assertNull(categoriaBuscada);

    }


    /**
     * Metodo que sirve para actualizar los datos de una Categoria
     */
    @Test
    @Sql("classpath:Categoria.sql")
    public void ActualizarCategoriaTestSql() {

        Categoria categoriaGuardada = miCategoria.findById(1).orElse(null);

        //actualiza el nombre de la categoria
        categoriaGuardada.setNombre("Video Juegos");
        miCategoria.save(categoriaGuardada);

        Categoria categoriaBuscada = miCategoria.findById(1).orElse(null);
        Assertions.assertEquals("Video Juegos", categoriaBuscada.getNombre());

    }


    /**
     * metodo que sirve para listar las categorias guardados en el sql
     */
    @Test
    @Sql("classpath:Categoria.sql")
    public void ListarCategoriaTestSql() {

        //se guardan los datos del sql en una lista
        List<Categoria> listaCategoria = miCategoria.findAll();

        //el for se usa para mostrar los datos guardados en la lista
        for (Categoria misCategorias : listaCategoria) {
            System.out.println(misCategorias);
        }
    }

    //Metodo que elimina una categoria (sin sql)
    /*@Test
    public void EliminarCategoriaTest() {
        Categoria categoria1 = new Categoria("Electrodomestico");
        Categoria guardarCategoria = miCategoria.save(categoria1);
        miCategoria.delete(guardarCategoria);
        Categoria categoriaBuscada = miCategoria.findById(1).orElse(null);
        Assertions.assertNull(categoriaBuscada);

    }*/

    //Metodo que actualiza una categoria (sin sql)
    /*  @Test
    public void ActualizarCategoriaTest() {
        Categoria categoria1 = new Categoria("Electrodomestico");
        Categoria guardarCategoria = miCategoria.save(categoria1);
        guardarCategoria.setNombre("Video Juegos");
        miCategoria.save(guardarCategoria);
        Categoria categoriaBuscada = miCategoria.findById(1).orElse(null);
        Assertions.assertEquals("Video Juegos", categoriaBuscada.getNombre());

    }*/

    //Metodo que lista las categorias (sin sql)
    /*@Test
    public void ListarCategoriaTest() {
        Categoria categoria1 = new Categoria("Electrodomestico");
        miCategoria.save(categoria1);
        List<Categoria> listaCategoria = miCategoria.findAll();
        for (Categoria misCategorias : listaCategoria) {
            System.out.println(misCategorias);
        }
    }*/

}
