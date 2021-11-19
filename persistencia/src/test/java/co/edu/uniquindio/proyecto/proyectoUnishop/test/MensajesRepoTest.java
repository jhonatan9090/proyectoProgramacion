package co.edu.uniquindio.proyecto.proyectoUnishop.test;

import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.*;
import co.edu.uniquindio.proyecto.proyectoUnishop.repositorios.*;
import co.edu.uniquindio.proyectoUnishop.entidades.*;
import co.edu.uniquindio.proyectoUnishop.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)


public class MensajesRepoTest {

    @Autowired//instancia variables componentes de springboo
    private ChatRepo miChatRepo;

    @Autowired//instancia variables componentes de springboo
    private ProductoRepo miProductoRepo;

    @Autowired//instancia variables componentes de springboo
    private UsuarioRepo miUsuarioRepo;

    @Autowired//instancia variables componentes de springboo
    private CiudadRepo miCiudadRepo;

    @Autowired//instancia variables componentes de springboo
    private MensajesRepo miMensajesRepo;


    /**
     * metodo que crea un mensaje nuevo
     */
    @Test
    public void crearMensajeTest() {

        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);

        //Crea un Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario usuario = miUsuarioRepo.save(usuario1);

        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022, 6, 25), 5.5, imagenes, usuario, miCiudad);
        Producto productoVender = miProductoRepo.save(miProducto);


        //comprador producto
        Ciudad miCiudad2 = new Ciudad("armenia");
        miCiudadRepo.save(miCiudad2);

        //Crea un comprador
        Map<String, String> telefonos2 = new HashMap<>();
        telefonos2.put("casa", "32140014");
        telefonos2.put("celular", "32100452514");
        Usuario usuario2 = new Usuario("222", "carlos velez", "jiji@", "123485", telefonos2, miCiudad);
        usuario2.setTelefono(telefonos2);
        usuario2.setCiudadUsuario(miCiudad);
        Usuario comprador = miUsuarioRepo.save(usuario2);

        //Crea un chat
        Chat miChat = new Chat(comprador, productoVender);
        Chat miChatGuardado = miChatRepo.save(miChat);

        //crea un mensaje
        Mensajes miMensajes = new Mensajes("hola", "andres perez", LocalDateTime.now(), miChatGuardado);

        Mensajes mensajeGuardado = miMensajesRepo.save(miMensajes);
        Assertions.assertNotNull(mensajeGuardado);
    }



    /**
     * metodo para eliminar un mensaje desde el Sql
     */
    @Test
    @Sql("classpath:mensaje.sql")
    public void eliminarMensajeTestSql() {

        //se elimina el mensaje por medio del id
        miMensajesRepo.deleteById(1);

        //se busca para comprobar que si se elimino
        Mensajes mensajeBuscado = miMensajesRepo.findById(1).orElse(null);
        Assertions.assertNull(mensajeBuscado);

    }


    /**
     * metodo que actualiza un mensaje
     */
    @Test
    @Sql("classpath:mensaje.sql")
    public void actualizarMensajeTestSql() {

        //trae el mensaje desde del sql
        Mensajes mensajeBuscado = miMensajesRepo.findById(3).orElse(null);

        //se seteamos el cambio que le queremos hacer
        mensajeBuscado.setMensaje("el producto llego ya");

        //se guarda la modificacion
        miMensajesRepo.save(mensajeBuscado);

        //se busca para comprobar si se realizo los cambios
        Assertions.assertEquals("el producto llego ya", mensajeBuscado.getMensaje());
    }


    /**
     * metodo que lista los mensajes
     */
    @Test
    @Sql("classpath:mensaje.sql")
    public void listarMensajeTestSql() {

        //busca los mensajes desde el sql por medio del id y los guarda en una list
        List<Mensajes> listaMensajes = miMensajesRepo.findAll();

        //imprime los mensajes de la lista
        for (Mensajes misMensajes : listaMensajes) {
            System.out.println(misMensajes);
        }
    }

    //Metodo para eliminar un mensaje (sin sql)
    /*@Test
    public void eliminarMensajeTest(){

        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);

        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario usuario = miUsuarioRepo.save(usuario1);

        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, miCiudad);
        Producto productoVender = miProductoRepo.save(miProducto);


        //comprador producto
        Ciudad miCiudad2 = new Ciudad("armenia");
        miCiudadRepo.save(miCiudad2);

        Map<String, String> telefonos2 = new HashMap<>();
        telefonos2.put("casa", "32140014");
        telefonos2.put("celular", "32100452514");
        Usuario usuario2 = new Usuario("222", "carlos velez", "jiji@", "123485", telefonos2, miCiudad);
        usuario2.setTelefono(telefonos2);
        usuario2.setCiudadUsuario(miCiudad);

        Usuario comprador = miUsuarioRepo.save(usuario2);

        //chat creado
        Chat miChat = new Chat(comprador, productoVender);
        Chat miChatGuardado=miChatRepo.save(miChat);
        //mensaje creado
        Mensajes miMensajes=new Mensajes("hola","andres perez", LocalDateTime.now(),miChatGuardado);
        //eliminar mensaje
        Mensajes mensajeGuardado=miMensajesRepo.save(miMensajes);
        miMensajesRepo.delete(mensajeGuardado);
        Mensajes mensajeBuscado=miMensajesRepo.findById(1).orElse(null);
        Assertions.assertNull(mensajeBuscado);

    }*/

    //Metodo para actualizar un mensaje (sin sql)
    /* @Test
     public void actualizarMensajeTest(){


         Ciudad miCiudad = new Ciudad("Cali");
         miCiudadRepo.save(miCiudad);

         //Vendedor producto
         Map<String, String> telefonos = new HashMap<>();
         telefonos.put("casa", "321414");
         telefonos.put("celular", "321452514");
         Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, miCiudad);
         usuario1.setTelefono(telefonos);
         usuario1.setCiudadUsuario(miCiudad);
         Usuario usuario = miUsuarioRepo.save(usuario1);

         //Producto  Vender
         List<String> imagenes = new ArrayList<>();
         imagenes.add("1");
         imagenes.add("2");
         Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, miCiudad);
         Producto productoVender = miProductoRepo.save(miProducto);


         //comprador producto
         Ciudad miCiudad2 = new Ciudad("armenia");
         miCiudadRepo.save(miCiudad2);

         Map<String, String> telefonos2 = new HashMap<>();
         telefonos2.put("casa", "32140014");
         telefonos2.put("celular", "32100452514");
         Usuario usuario2 = new Usuario("222", "carlos velez", "jiji@", "123485", telefonos2, miCiudad);
         usuario2.setTelefono(telefonos2);
         usuario2.setCiudadUsuario(miCiudad);

         Usuario comprador = miUsuarioRepo.save(usuario2);


         Chat miChat = new Chat(comprador, productoVender);
         Chat miChatGuardado=miChatRepo.save(miChat);


         Mensajes miMensajes=new Mensajes("hola","andres perez", LocalDateTime.now(),miChatGuardado);
        Mensajes mensajeGuardado=miMensajesRepo.save(miMensajes);

         mensajeGuardado.setEmisor("jhonatan uribe");
         miMensajesRepo.save(mensajeGuardado);

         //se busca el mensaje
         Mensajes mesajeBuscado=miMensajesRepo.findById(1).orElse(null);
         Assertions.assertEquals("jhonatan uribe",mesajeBuscado.getEmisor());

     }*/

    //Metodo paralistar los mensajes (sin sql)
    /* @Test
    public void listarMensajeTest(){


        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);

        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario usuario = miUsuarioRepo.save(usuario1);

        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, usuario, miCiudad);
        Producto productoVender = miProductoRepo.save(miProducto);


        //comprador producto
        Ciudad miCiudad2 = new Ciudad("armenia");
        miCiudadRepo.save(miCiudad2);

        Map<String, String> telefonos2 = new HashMap<>();
        telefonos2.put("casa", "32140014");
        telefonos2.put("celular", "32100452514");
        Usuario usuario2 = new Usuario("222", "carlos velez", "jiji@", "123485", telefonos2, miCiudad);
        usuario2.setTelefono(telefonos2);
        usuario2.setCiudadUsuario(miCiudad);

        Usuario comprador = miUsuarioRepo.save(usuario2);


        Chat miChat = new Chat(comprador, productoVender);
        Chat miChatGuardado=miChatRepo.save(miChat);


        Mensajes miMensajes=new Mensajes("hola","andres perez", LocalDateTime.now(),miChatGuardado);
        Mensajes mensajeGuardado=miMensajesRepo.save(miMensajes);


        List<Mensajes>listaMensajes=miMensajesRepo.findAll();

        for (Mensajes misMensajes : listaMensajes) {
            System.out.println(misMensajes);
        }
    }*/
}
