package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.Administrador;
import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.AdministradorRepo;
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
public class AdministradorTest {

    @Autowired    //instancia variables componentes de springboot
    private AdministradorRepo miAdministradorRepo;

    //metodo para registrar un arministrador
    @Test
    public void registrarAdministradorTest(){

        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Administrador administrador1 = new Administrador("123", "Ana", "ana@gmail.com", "2323", telefonos);

        Administrador administradorGuardado=miAdministradorRepo.save(administrador1);
        Assertions.assertNotNull(administradorGuardado);

    }

    //metodo que elimina un administrador
    @Test
    public void eliminarUsuario(){

        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Administrador administrador1 = new Administrador("123", "Ana", "ana@gmail.com", "2323", telefonos);
        miAdministradorRepo.save(administrador1);

        miAdministradorRepo.deleteById("123");

        Administrador administradorBuscado= miAdministradorRepo.findById("123").orElse(null);
        Assertions.assertNull(administradorBuscado);
    }


    //metodo que actualiza un administrador
    @Test
    public void actualizarUsuario(){

    //se guarda el administrador
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Administrador administrador1 = new Administrador("123", "Ana", "ana@gmail.com", "2323", telefonos);
        Administrador administradorGuardado=miAdministradorRepo.save(administrador1);

        //se modifiaca el dato a cambiar
        administradorGuardado.setNombre("Maria");
        //se vuelve a gurdar
        miAdministradorRepo.save(administradorGuardado);

        Administrador administradorBuscado=miAdministradorRepo.findById("123").orElse(null);
        Assertions.assertEquals("Maria",administradorBuscado.getNombre());

    }
    //metodo que busca los administradores
    @Test
    public void listarUsuariosTes(){

        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Administrador administrador1 = new Administrador("123", "Ana", "ana@gmail.com", "2323", telefonos);
        //usuario1.setCiudadUsuario(ciudad1);
        miAdministradorRepo.save(administrador1);
        List<Administrador>listaAdministradores=miAdministradorRepo.findAll();
        System.out.println(listaAdministradores);

    }

}
