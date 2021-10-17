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
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Guarda nuestra prueba en la Base de datos
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {

    @Autowired    //instancia variables componentes de springboot
    private AdministradorRepo miAdministradorRepo;


    /**
     * metodo para registrar un arministrador
     */
    @Test
    public void registrarAdministradorTestSql(){

        //crea un administrador
        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");
        Administrador administrador1 = new Administrador("123", "Ana", "ana@gmail.com", "2323", telefonos);

        Administrador administradorGuardado=miAdministradorRepo.save(administrador1);
        Assertions.assertNotNull(administradorGuardado);

    }

    /**
     * metodo para eliminar un administrador desde el Sql
     */
    @Test
    @Sql("classpath:administrador.sql")
    public void eliminarUsuarioSql(){

        //se elimina el administrado deseado buscandolo por su id
        miAdministradorRepo.deleteById("1340");
        Administrador administradorBuscado= miAdministradorRepo.findById("1340").orElse(null);

        //se verifica que se haya eliminado el administrador deseado
        Assertions.assertNull(administradorBuscado);

    }


    /**
     * Metodo que sirve para actualizar los datos de un administrador
     */
    @Test
    @Sql("classpath:administrador.sql")
    public void actualizarUsuarioSql() {

        //desde aqui se busca al administrador del sql con su id y se modifica el
        Administrador administradorBuscado=miAdministradorRepo.findById("1340").orElse(null);
        administradorBuscado.setNombre("Maria");

        //en la linea de abajo se Guardan los cambios realizados al administrador buscado
        miAdministradorRepo.save(administradorBuscado);

        //aqui se busca si se guardaron correctamente los cambios
        Assertions.assertEquals("Maria",administradorBuscado.getNombre());
    }


    /**
     * metodo que sirve para listar los administradores guardados en el sql
     */
    @Test
    @Sql("classpath:administrador.sql")
    public void listarUsuariosTesSql() {
        //se traen los datos de el sql y se guarda en la lista
        List<Administrador>listaAdministradores=miAdministradorRepo.findAll();

        //en este for se imprimen los datos guardados en la lista
        for(Administrador miAdministrador: listaAdministradores){
            System.out.println(miAdministrador);
        }
    }

    //Metodo que elimina un administrador (sin sql)
    /* @Test
    public void eliminarUsuario(){

        Map<String,String>telefonos=new HashMap<>();
        telefonos.put("casa","321414");
        telefonos.put("celular","321452514");

        Administrador administrador1 = new Administrador("123", "Ana", "ana@gmail.com", "2323", telefonos);
        miAdministradorRepo.save(administrador1);

        miAdministradorRepo.deleteById("123");

        Administrador administradorBuscado= miAdministradorRepo.findById("123").orElse(null);
        Assertions.assertNull(administradorBuscado);
    }*/

    //Metodo que actualiza un administrador (sin sql)
    /*@Test
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

    }*/

    //Metodo que lista los administrador (sin sql)
    /*@Test
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
    */
}
