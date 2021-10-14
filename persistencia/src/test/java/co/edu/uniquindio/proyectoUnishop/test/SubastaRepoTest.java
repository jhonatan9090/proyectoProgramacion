package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Subasta;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.ProductoRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.SubastaRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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

    @Test
    public void CrearSubastaTest(){
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
        Subasta subastaGuardada = miSubasta.save(subasta1);
        Assertions.assertNotNull(subastaGuardada);
    }

    @Test
    public void EliminaSubastaTest(){
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
        Subasta subastaGuardada = miSubasta.save(subasta1);
        miSubasta.delete(subastaGuardada);
        Subasta subastaBuscar = miSubasta.findById(1).orElse(null);
        Assertions.assertNull(subastaBuscar);
    }

    @Test
    public void ActualizarSubastaTest(){
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
        Subasta subastaGuardada = miSubasta.save(subasta1);

        subastaGuardada.setFechaLimite(LocalDate.of(2023,2,3));
        miSubasta.save(subastaGuardada);
        Subasta subastaBuscada = miSubasta.findById(1).orElse(null);
        Assertions.assertEquals(LocalDate.of(2023,2,3),subastaBuscada.getFechaLimite());
    }

    @Test
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
}
