package co.edu.uniquindio.proyecto.proyectoUnishop.test;


import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyecto.proyectoUnishop.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadRepoTest {

    @Autowired
    private CiudadRepo miCiudad;

    /**
     * metodo para crear una Ciudad
     */
    @Test
    public void CrearCiudadTest(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        Ciudad guardarCiudad = miCiudad.save(ciudad1);
        Assertions.assertNotNull(guardarCiudad);
    }


    /**
     * metodo para eliminar una ciudad desde el Sql
     */
    @Test
    @Sql("classpath:ciudad.sql")
    public void EliminarCiudadTestSql(){
        miCiudad.deleteById(2);
        Ciudad miCiudadBuscada=miCiudad.findById(2).orElse(null);
        Assertions.assertNull(miCiudadBuscada);

    }


    /**
     * Metodos para actualizar los datos de una ciudad
     */
    @Test
    @Sql("classpath:ciudad.sql")
    public void ActualizarCiudadTestSql(){

        Ciudad ciudad1 =miCiudad.findById(1).orElse(null);

        //actualiza el nombre de la ciudad
        ciudad1.setNombre("Calarca");
        Ciudad ciudadBuscada= miCiudad.save(ciudad1);

        Assertions.assertEquals("Calarca",ciudadBuscada.getNombre());

    }


    /**
     * metodo que sirve para listar las ciudades guardados en el sql
     */
    @Test
    @Sql("classpath:ciudad.sql")
    public void ListarCiudadTestSql(){

        //se guardan los datos del sql en una lista
        List<Ciudad> listaCiudad = miCiudad.findAll();

        //el for se usa para mostrar los datos guardados en la lista
        for (Ciudad misCiudad: listaCiudad){
            System.out.println(misCiudad);
        }
    }

    //Metodo para eliminar una ciudad (sin sql)
    /* @Test
    public void EliminarCiudadTest(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        Ciudad guardarCiudad = miCiudad.save(ciudad1);
        miCiudad.delete(guardarCiudad);
        Ciudad buscarCiudad = miCiudad.findById(1).orElse(null);
        Assertions.assertNull(buscarCiudad);
    }*/

    //Metodo para eliminar una ciudad (sin sql)
    /* @Test
    public void ActualizarCiudadTest(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        Ciudad guardarCiudad = miCiudad.save(ciudad1);
        guardarCiudad.setNombre("Calarca");
       Ciudad ciudadBuscada= miCiudad.save(guardarCiudad);

        Assertions.assertEquals("Calarca",ciudadBuscada.getNombre());

    }*/

    //Metodo para listar las ciudades (sin sql)
    /*@Test
    public void ListarCiudadTest(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        miCiudad.save(ciudad1);
        List<Ciudad> listaCiudad = miCiudad.findAll();
        for (Ciudad misCiudad: listaCiudad){
            System.out.println(misCiudad);
        }
    }*/

}
