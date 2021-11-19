package co.edu.uniquindio.proyecto.proyectoUnishop.test;

import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyecto.proyectoUnishop.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.proyectoUnishop.repositorios.UsuarioRepo;
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

    /**
     * metodo para registrar un usuario
     */
    @Test
    public void registroUsuarioTest(){

        //Se crea una ciudad
        Ciudad ciudad1=new Ciudad("armenia");
        miCiudadRepo.save(ciudad1);

        //Se crea un usuario
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Usuario usuario1=new Usuario("111","Luisa Perez","luisaPe@","12345",telefonos,ciudad1);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(ciudad1);
        Usuario usuarioGuardado=miUsuarioRepo.save(usuario1);

        Assertions.assertNotNull(usuarioGuardado);

    }



    /**
     * Metodo para eliminar un usuario desde Sql
     */
    @Test
    @Sql("classpath:usuarios.sql")
    public void eliminarUsuarioTestSql(){

        miUsuarioRepo.deleteById("123");

        Usuario usuarioBuscado= miUsuarioRepo.findById("123").orElse(null);
        Assertions.assertNull(usuarioBuscado);
    }


    /**
     * Metodo para actualizar los datos de un usuario
     */
    @Test
    @Sql("classpath:usuarios.sql")
    public void actualizarUsuarioTestSql(){

        Usuario usuarioGuardado=miUsuarioRepo.findById("123").orElse(null);

        //se actualiza el nombre del Usuario
        usuarioGuardado.setNombre("Claudia perez");
        miUsuarioRepo.save(usuarioGuardado);

        //Se busca el usuario para confirmar la actualizacion
        Usuario usuarioBuscado=miUsuarioRepo.findById("123").orElse(null);
        Assertions.assertEquals("Claudia perez",usuarioBuscado.getNombre());

    }


    /**
     * Metodo para listar los usuarios guardados en sql
     */
    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosTestSql(){

        List<Usuario>listaUsuarios=miUsuarioRepo.findAll();

        // for se usa para mostrar los datos guardados en la lista
        for(Usuario miUsuario:listaUsuarios) {
            System.out.println(miUsuario);
        }
    }

    //metodo que elimina un usuario (sin sql)
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

    //metodo que actualiza un usario (sin sql)
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

    //metodo que lista los usarios (sin sql)
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
}
