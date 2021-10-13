package co.edu.uniquindio.proyectoUnishop.test;

import co.edu.uniquindio.proyectoUnishop.entidades.Chat;
import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.ChatRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.ProductoRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
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
public class ChatRepoTest {

    @Autowired
    private ChatRepo miChatRepo;

    @Autowired
    private ProductoRepo miProductoRepo;

    @Autowired
    private UsuarioRepo miUsuarioRepo;

    @Autowired

    private CiudadRepo miCiudadRepo;
    //metodo para crear un chat
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
    //metodo que elimina un chat
    @Test
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

    }
    @Test
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
        //se vuelve a gurdar
        miChatRepo.save(chatGuardado);

        //se busca el prodcto
        Chat chatBuscado=miChatRepo.findById(1).orElse(null);
        Assertions.assertEquals("nevera",chatBuscado.getChatProductoCompra().getNombre());

    }
    @Test
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

    }

}
