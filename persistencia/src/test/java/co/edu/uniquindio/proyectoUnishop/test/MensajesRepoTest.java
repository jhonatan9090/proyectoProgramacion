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



public class MensajesRepoTest {

    @Autowired
    private ChatRepo miChatRepo;

    @Autowired
    private ProductoRepo miProductoRepo;

    @Autowired
    private UsuarioRepo miUsuarioRepo;

    @Autowired

    private CiudadRepo miCiudadRepo;

    @Autowired
    private MensajesRepo miMensajesRepo;

    @Test
    public void crearMensajeTest(){

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
        Assertions.assertNotNull(mensajeGuardado);


    }

    @Test
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


    }


    @Test
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

    }

    @Test
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
    }
}
