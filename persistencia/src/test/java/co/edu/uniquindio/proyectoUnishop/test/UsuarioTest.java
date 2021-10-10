package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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

    //metodo para registrar un usuario
    @Test
    public void registroUsuarioTest(){

        Ciudad ciudad1=new Ciudad();
        ciudad1.setNombre("Armenia");

        Usuario usuario1=new Usuario();
        usuario1.setCodPersona("111");
        usuario1.setNombre("Luisa perez");
        usuario1.setEmail("luisaPe@");
        usuario1.setPassword("12345");
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(ciudad1);
        Usuario usuarioGuardado=miUsuarioRepo.save(usuario1);
        Assertions.assertNotNull(usuarioGuardado);

    }

    //metodo que elimina un usuario
    @Test
    public void eliminarUsuario(){

        Ciudad ciudad1=new Ciudad();
        ciudad1.setNombre("Armenia");

        Usuario usuario1=new Usuario();
        usuario1.setCodPersona("111");
        usuario1.setNombre("Luisa perez");
        usuario1.setEmail("luisaPe@");
        usuario1.setPassword("12345");
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(ciudad1);
        miUsuarioRepo.save(usuario1);

        miUsuarioRepo.deleteById("111");

        Usuario usuarioBuscado= miUsuarioRepo.findById("111").orElse(null);
        Assertions.assertNull(usuarioBuscado);
    }


    //metodo que actualiza un usario
    @Test
    public void actualizarUsuario(){

    //se guarda usuario
        Ciudad ciudad1=new Ciudad();
        ciudad1.setNombre("Armenia");
        Usuario usuario1=new Usuario();
        usuario1.setCodPersona("111");
        usuario1.setNombre("Luisa perez");
        usuario1.setEmail("luisaPe@");
        usuario1.setPassword("12345");
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(ciudad1);
        Usuario usuarioGuardado=miUsuarioRepo.save(usuario1);
        //se modifiaca el dato a cambiar
        usuarioGuardado.setNombre("Claudia perez");
        //se vuelve a gurdar
        miUsuarioRepo.save(usuarioGuardado);

        Usuario usuarioBuscado=miUsuarioRepo.findById("111").orElse(null);
        Assertions.assertEquals("Claudia perez",usuarioBuscado.getNombre());

    }
    //metodo que busca los usarios
    @Test
    public void listarUsuariosTes(){

        //Ciudad ciudad1=new Ciudad();
        //ciudad1.setNombre("Armenia");
        Usuario usuario1=new Usuario();
        usuario1.setCodPersona("111");
        usuario1.setNombre("Luisa perez");
        usuario1.setEmail("luisaPe@");
        usuario1.setPassword("12345");
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        usuario1.setTelefono(telefonos);
        //usuario1.setCiudadUsuario(ciudad1);
        miUsuarioRepo.save(usuario1);
        List<Usuario>listaUsuarios=miUsuarioRepo.findAll();
        System.out.println(listaUsuarios);

    }

}
