package co.edu.uniquindio.proyectoUnishop.test;


import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
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
    @Test
    public void CrearCiudadTest(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        Ciudad guardarCiudad = miCiudad.save(ciudad1);
        Assertions.assertNotNull(guardarCiudad);
    }

   /* @Test
    public void EliminarCiudadTest(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        Ciudad guardarCiudad = miCiudad.save(ciudad1);
        miCiudad.delete(guardarCiudad);
        Ciudad buscarCiudad = miCiudad.findById(1).orElse(null);
        Assertions.assertNull(buscarCiudad);
    }*/

    @Test
    @Sql("classpath:ciudad.sql")
    public void EliminarCiudadTestSql(){
        miCiudad.deleteById(2);
        Ciudad miCiudadBuscada=miCiudad.findById(2).orElse(null);
        Assertions.assertNull(miCiudadBuscada);

    }

   /* @Test
    public void ActualizarCiudadTest(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        Ciudad guardarCiudad = miCiudad.save(ciudad1);
        guardarCiudad.setNombre("Calarca");
       Ciudad ciudadBuscada= miCiudad.save(guardarCiudad);

        Assertions.assertEquals("Calarca",ciudadBuscada.getNombre());

    }*/
    @Test
    @Sql("classpath:ciudad.sql")
    public void ActualizarCiudadTestSql(){

        Ciudad ciudad1 =miCiudad.findById(1).orElse(null);
        ciudad1.setNombre("Calarca");
        Ciudad ciudadBuscada= miCiudad.save(ciudad1);
        Assertions.assertEquals("Calarca",ciudadBuscada.getNombre());

    }
    /*@Test
    public void ListarCiudadTest(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        miCiudad.save(ciudad1);
        List<Ciudad> listaCiudad = miCiudad.findAll();
        for (Ciudad misCiudad: listaCiudad){
            System.out.println(misCiudad);
        }
    }*/
    @Test
    @Sql("classpath:ciudad.sql")
    public void ListarCiudadTestSql(){

        List<Ciudad> listaCiudad = miCiudad.findAll();
        for (Ciudad misCiudad: listaCiudad){
            System.out.println(misCiudad);
        }

    }

}
