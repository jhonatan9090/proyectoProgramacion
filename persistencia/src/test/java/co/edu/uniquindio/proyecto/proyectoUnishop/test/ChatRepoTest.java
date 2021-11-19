package co.edu.uniquindio.proyecto.proyectoUnishop.test;

import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Chat;
import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyecto.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyecto.proyectoUnishop.repositorios.ChatRepo;
import co.edu.uniquindio.proyecto.proyectoUnishop.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.proyectoUnishop.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.proyectoUnishop.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ChatRepoTest {

    @Autowired//instancia variables componentes de springboot
    private ChatRepo miChatRepo;

    @Autowired//instancia variables componentes de springboot
    private ProductoRepo miProductoRepo;

    @Autowired//instancia variables componentes de springboot
    private UsuarioRepo miUsuarioRepo;

    @Autowired//instancia variables componentes de springboot
    private CiudadRepo miCiudadRepo;


    /**
     * metodo para crear un chat
     */
    @Test
    public void crearChat() {

        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);


        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario vendedor = miUsuarioRepo.save(usuario1);


        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, vendedor, miCiudad);
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
        Chat chatGuardado=miChatRepo.save(miChat);
        Assertions.assertNotNull(chatGuardado);

    }


    /**
     * metodo para eliminar un chat desde el Sql
     */
    @Test
    @Sql("classpath:chat.sql")
    public void eliminarChatSql(){
        miChatRepo.deleteById(3);
        Chat chatBuscado=miChatRepo.findById(3).orElse(null);
        Assertions.assertNull(chatBuscado);

    }


    /**
     * Metodo para actualizar los datos del chat desde sql
     */
    @Test
    @Sql("classpath:chat.sql")
    public void actualizarChatSql(){


        Producto miProductoVender=miProductoRepo.findById(2).orElse(null);
        Usuario usuarioComprador=miUsuarioRepo.findById("435").orElse(null);
        Chat chat=new Chat(usuarioComprador,miProductoVender);
        Chat miChatGuardado=miChatRepo.save(chat);
        Usuario usuarioCompradorEditado=miUsuarioRepo.findById("123").orElse(null);
        miChatGuardado.setUsuarioComprador(usuarioCompradorEditado);
        Chat chatBuscado=miChatRepo.findById(1).orElse(null);
        Assertions.assertEquals("123",chatBuscado.getUsuarioComprador().getCodPersona());


    }


    /**
     * metodo que sirve para listar los chat guardados en el sql
     */
    @Test
    @Sql("classpath:chat.sql")
    public void listarChatSql(){

        //se guardan los datos del sql en una lista
        List<Chat>listaChats=miChatRepo.findAll();

        //el for se usa para mostrar los datos guardados en la lista
        for (Chat misChat : listaChats) {
            System.out.println(misChat);
        }
    }

    @Test
    @Sql("classpath:chat.sql")
    public void listarChatTestSql(){

        List<Chat>listaChats=miChatRepo.obtenerChatPorCodigo("123");

        // for se usa para mostrar los datos guardados en la lista
        for(Chat miChat:listaChats) {
            System.out.println(listaChats);
        }
    }

    //metodo que elimina un chat (sin sql)
   /* @Test
    public void eliminarChat(){

        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);


        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario vendedor = miUsuarioRepo.save(usuario1);


        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, vendedor, miCiudad);
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
        Chat chatGuardado=miChatRepo.save(miChat);
        miChatRepo.delete(chatGuardado);

        Chat chatBuscado=miChatRepo.findById(1).orElse(null);
        Assertions.assertNull(chatBuscado);

    }*/

    //metodo que actualiza un chat (sin sql)
    /* @Test
    public void actualizarChat(){


        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);
        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario vendedor = miUsuarioRepo.save(usuario1);
        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, vendedor, miCiudad);
        Producto productoVender = miProductoRepo.save(miProducto);


        //Producto  Vender editado
        List<String> imagenes2 = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto2 = new Producto("nevera", 11, "es nice", 12.02, LocalDate.of(2022,6,28), 7.0, imagenes, vendedor, miCiudad);
        Producto productoVender2 = miProductoRepo.save(miProducto2);


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
        Chat chatGuardado=miChatRepo.save(miChat);

        //se modifiaca el dato a cambiar
        chatGuardado.setChatProductoCompra(miProducto2);
        //se vuelve a guardar
        miChatRepo.save(chatGuardado);

        //se busca el producto
        Chat chatBuscado=miChatRepo.findById(1).orElse(null);
        Assertions.assertEquals("nevera",chatBuscado.getChatProductoCompra().getNombre());

    }*/

    //Metoto para listar los chat (sin sql)
    /*  @Test
    public void listarChat(){

        Ciudad miCiudad = new Ciudad("Cali");
        miCiudadRepo.save(miCiudad);


        //Vendedor producto
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("casa", "321414");
        telefonos.put("celular", "321452514");
        Usuario usuario1 = new Usuario("111", "Luisa Perez", "luisaPe@", "12345", telefonos, miCiudad);
        usuario1.setTelefono(telefonos);
        usuario1.setCiudadUsuario(miCiudad);
        Usuario vendedor = miUsuarioRepo.save(usuario1);


        //Producto  Vender
        List<String> imagenes = new ArrayList<>();
        imagenes.add("1");
        imagenes.add("2");
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022,6,25), 5.5, imagenes, vendedor, miCiudad);
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
        Chat chatGuardado=miChatRepo.save(miChat);
        Assertions.assertNotNull(chatGuardado);

        List<Chat>listaChats=miChatRepo.findAll();


        for (Chat misChat : listaChats) {
            System.out.println(misChat);
        }

    }*/
}
