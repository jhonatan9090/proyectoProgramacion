package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.*;
import co.edu.uniquindio.proyectoUnishop.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubastaUsuarioTest {

    @Autowired
    private SubastaUsuarioRepo miUsuarioSubasta;

    @Autowired
    private SubastaRepo miSubasta;

    @Autowired
    private ProductoRepo miProducto;

    @Autowired
    private CiudadRepo miCiudad;

    @Autowired
    private UsuarioRepo miUsuario;



    @Test
    public void CrearSubastaUsuarioRepoTest(){
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

        SubastaUsuario subastaUsuario1 = new SubastaUsuario(20000.3,LocalDateTime.now(),usuarioGuardado,subastaGuardada);
        SubastaUsuario subUSGuardada = miUsuarioSubasta.save(subastaUsuario1);
        Assertions.assertNotNull(subUSGuardada);

    }
    @Test
    public void EliminarSubastaUsuarioTest(){
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

        SubastaUsuario subastaUsuario1 = new SubastaUsuario(20000.3,LocalDateTime.now(),usuarioGuardado,subastaGuardada);
        SubastaUsuario subUSGuardada = miUsuarioSubasta.save(subastaUsuario1);
        miUsuarioSubasta.delete(subUSGuardada);
        SubastaUsuario buscarsubUs = miUsuarioSubasta.findById(1).orElse(null);
        Assertions.assertNull(buscarsubUs);
    }

    @Test
    public void ActualizarSubastaUsuarioTest(){
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

        SubastaUsuario subastaUsuario1 = new SubastaUsuario(20000.3,LocalDateTime.now(),usuarioGuardado,subastaGuardada);
        SubastaUsuario subUSGuardada = miUsuarioSubasta.save(subastaUsuario1);


        Map<String,String> telefonos2=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Usuario usuario2=new Usuario("123","Manolo Casas","manolito@","123455",telefonos,ciudad2);
        usuario2.setTelefono(telefonos);
        Usuario usuarioGuardado2=miUsuario.save(usuario2);

        subUSGuardada.setUsuarioSubasta(usuarioGuardado2);
        miUsuarioSubasta.save(subUSGuardada);
        SubastaUsuario subUsBuscada = miUsuarioSubasta.findById(1).orElse(null);
        Assertions.assertEquals("123",subUsBuscada.getUsuarioSubasta().getCodPersona());

    }

    @Test
    public void ListarSubastaUsuarioTest(){
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

        SubastaUsuario subastaUsuario1 = new SubastaUsuario(20000.3,LocalDateTime.now(),usuarioGuardado,subastaGuardada);
        miUsuarioSubasta.save(subastaUsuario1);
        List<SubastaUsuario> listaSubastaUsuario = miUsuarioSubasta.findAll();
        for (SubastaUsuario miUsarioSubasta: listaSubastaUsuario){
            System.out.println(miUsarioSubasta);
        }

    }
}
