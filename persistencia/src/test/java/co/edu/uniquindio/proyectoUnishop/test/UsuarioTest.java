package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
//Guarda nuestra prueba en la Base de datos
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired    //instancia variables componentes de springboot
    private UsuarioRepo miUsuarioRepo;
    @Autowired
    private CiudadRepo miCiudadRepo;


    //metodo para registrar un usuario
    @Test
    public void registroUsuarioTest(){

        Ciudad ciudad1=new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);

        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Usuario usuario1=new Usuario("111","Luisa Perez","luisaPe@","12345",telefonos,ciudad1);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(ciudad1);
        Usuario usuarioGuardado=miUsuarioRepo.save(usuario1);
        Assertions.assertNotNull(usuarioGuardado);

    }

    //metodo que elimina un usuario
   /* @Test
    public void eliminarUsuarioTest(){

        Ciudad ciudad1=new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);


        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Usuario usuario1=new Usuario("111","Luisa Perez","luisaPe@","12345",telefonos,ciudad1);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(ciudad1);
        Usuario usuarioGuardado=miUsuarioRepo.save(usuario1);
        Assertions.assertNotNull(usuarioGuardado);


        miUsuarioRepo.deleteById("111");

        Usuario usuarioBuscado= miUsuarioRepo.findById("111").orElse(null);
        Assertions.assertNull(usuarioBuscado);
    }*/
    @Test
    @Sql("classpath:usuarios.sql")
    public void eliminarUsuarioTestSql(){

        miUsuarioRepo.deleteById("123");

        Usuario usuarioBuscado= miUsuarioRepo.findById("123").orElse(null);
        Assertions.assertNull(usuarioBuscado);
    }


    //metodo que actualiza un usario
    /*@Test
    public void actualizarUsuarioTest(){

    //se guarda usuario

        Ciudad ciudad1=new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);


        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Usuario usuario1=new Usuario("111","Luisa Perez","luisaPe@","12345",telefonos,ciudad1);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(ciudad1);
        Usuario usuarioGuardado=miUsuarioRepo.save(usuario1);
        Assertions.assertNotNull(usuarioGuardado);

        //se modifiaca el dato a cambiar
        usuarioGuardado.setNombre("Claudia perez");
        //se vuelve a gurdar
        miUsuarioRepo.save(usuarioGuardado);

        Usuario usuarioBuscado=miUsuarioRepo.findById("111").orElse(null);
        Assertions.assertEquals("Claudia perez",usuarioBuscado.getNombre());

    }*/
    @Test
    @Sql("classpath:usuarios.sql")
    public void actualizarUsuarioTestSql(){

        Usuario usuarioGuardado=miUsuarioRepo.findById("123").orElse(null);
        usuarioGuardado.setNombre("Claudia perez");
        miUsuarioRepo.save(usuarioGuardado);
        Usuario usuarioBuscado=miUsuarioRepo.findById("123").orElse(null);
        Assertions.assertEquals("Claudia perez",usuarioBuscado.getNombre());

    }
    //metodo que busca los usarios
    /*@Test
    public void listarUsuariosTest(){


        Ciudad ciudad1=new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);


        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Usuario usuario1=new Usuario("111","Luisa Perez","luisaPe@","12345",telefonos,ciudad1);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(ciudad1);
        Usuario usuarioGuardado=miUsuarioRepo.save(usuario1);
        Assertions.assertNotNull(usuarioGuardado);

        List<Usuario>listaUsuarios=miUsuarioRepo.findAll();
        System.out.println(listaUsuarios);

    }*/
    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosTestSql(){


        List<Usuario>listaUsuarios=miUsuarioRepo.findAll();
        for(Usuario miUsuario:listaUsuarios) {
            System.out.println(miUsuario);
        }
    }

}
