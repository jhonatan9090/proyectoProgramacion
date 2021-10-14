package co.edu.uniquindio.proyectoUnishop.test;


import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadRepoTest {

    @Autowired
    private CiudadRepo miCiudad;
    @Test
    public void CrearCiudad(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        Ciudad guardarCiudad = miCiudad.save(ciudad1);
        Assertions.assertNotNull(guardarCiudad);
    }

    @Test
    public void EliminarCiudad(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        Ciudad guardarCiudad = miCiudad.save(ciudad1);
        miCiudad.delete(guardarCiudad);
        Ciudad buscarCiudad = miCiudad.findById(1).orElse(null);
        Assertions.assertNull(buscarCiudad);
    }

    @Test
    public void ActualizarCiudad(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        Ciudad guardarCiudad = miCiudad.save(ciudad1);
        guardarCiudad.setNombre("Calarca");
        miCiudad.save(guardarCiudad);
        Ciudad buscarCiudad = miCiudad.findById(1).orElse(null);
        Assertions.assertEquals("Calarca",buscarCiudad.getNombre());

    }

    @Test
    public void ListarCiudad(){
        Ciudad ciudad1 = new Ciudad("Armenia");
        miCiudad.save(ciudad1);
        List<Ciudad> listaCiudad = miCiudad.findAll();
        for (Ciudad misCiudad: listaCiudad){
            System.out.println(misCiudad);
        }
    }

}
