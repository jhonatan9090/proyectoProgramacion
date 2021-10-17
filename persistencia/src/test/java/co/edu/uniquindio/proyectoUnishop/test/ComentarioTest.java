package co.edu.uniquindio.proyectoUnishop.test;


import co.edu.uniquindio.proyectoUnishop.entidades.*;
import co.edu.uniquindio.proyectoUnishop.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ComentarioTest {

    @Autowired
    private ComentarioRepo miComentarioRepo;

    @Autowired
    private ProductoRepo miProductoRepo;

    @Autowired
    private UsuarioRepo miUsuarioRepo;

    @Autowired

    private CiudadRepo miCiudadRepo;

    /**
     * metodo para crear un comentario
     */
    @Test
    public void crearComentarioTest() {

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
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022, 6, 25), 5.5, imagenes, usuario, miCiudad);
        miProductoRepo.save(miProducto);
        // se crea el comentarios
        Comentario comentario = new Comentario("disponible?", "yes", LocalDate.of(2022, 6, 25), 3
                , usuario1, miProducto);

        //se guarda el comentario
        Comentario comentarioGuardado = miComentarioRepo.save(comentario);
        Assertions.assertNotNull(comentarioGuardado);


    }

    /*  @Test
      public void eliminarComentarioTest() {

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
          Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022, 6, 25), 5.5, imagenes, usuario, miCiudad);
          Producto productoVender = miProductoRepo.save(miProducto);

          Comentario comentario = new Comentario("disponible?", "yes", LocalDate.of(2022, 6, 25), 3
                  , usuario1, miProducto);

          Comentario comentarioGuardado = miComentarioRepo.save(comentario);

          miComentarioRepo.delete(comentarioGuardado);
          Comentario comentarioBuscado = miComentarioRepo.findById(1).orElse(null);
          Assertions.assertNull(comentarioBuscado);

      }*/
    /**
     * metodo para eliminar un comentario desde el Sql
     */
    @Test
    @Sql("classpath:comentario.sql")
    public void eliminarComentarioTestSql() {

        //elimina el comentario desde el sql por el codigo
        miComentarioRepo.deleteById(2);
        //busca si el comentario no fue eliminado por el codigo
        Comentario comentarioBuscado = miComentarioRepo.findById(2).orElse(null);
        Assertions.assertNull(comentarioBuscado);


    }

    /*@Test
    public void actualizarComentarioTest() {
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
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022, 6, 25), 5.5, imagenes, usuario, miCiudad);
        Producto productoVender = miProductoRepo.save(miProducto);

        Comentario comentario = new Comentario("disponible?", "yes", LocalDate.of(2022, 6, 25), 3
                , usuario1, miProducto);

        Comentario comentarioGuardado = miComentarioRepo.save(comentario);

        comentarioGuardado.setRespuesta("No");
        Comentario comentarioBuscado = miComentarioRepo.save(comentarioGuardado);

        Assertions.assertEquals("No", comentarioBuscado.getRespuesta());

    }*/

    /**
     *metodo para actualizar un comentario
     */
    @Test
    @Sql("classpath:comentario.sql")
    public void actualizarComentarioTestSql() {

        //usuario a editar
        Usuario usuarioComentario = miUsuarioRepo.findById("435").orElse(null);

        // buscamos comentario a editar
        Comentario miComentario = miComentarioRepo.findById(1).orElse(null);

        //le seteamos el nuevo dato al al usuario
        usuarioComentario.setNombre("jhonatan uribe");

        //seteamos el nuevo dato al comentario
        miComentario.setUsuarioComentario(usuarioComentario);
        Comentario comentarioEditado = miComentarioRepo.save(miComentario);
        Assertions.assertEquals("jhonatan uribe", comentarioEditado.getUsuarioComentario().getNombre());

    }

    /*@Test
    public void listarComentariosTest() {


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
        Producto miProducto = new Producto("play 5", 10, "es bueno", 12.02, LocalDate.of(2022, 6, 25), 5.5, imagenes, usuario, miCiudad);
        Producto productoVender = miProductoRepo.save(miProducto);

        Comentario comentario = new Comentario("disponible?", "yes", LocalDate.of(2022, 6, 25), 3
                , usuario1, miProducto);

        Comentario comentarioGuardado = miComentarioRepo.save(comentario);

        List<Comentario> listaComentarios = miComentarioRepo.findAll();

        for (Comentario misComentarios : listaComentarios) {
            System.out.println(misComentarios);
        }
    }*/

    /**
     * Metodo para listar los comentarios guardados en sql
     */
    @Test
    @Sql("classpath:comentario.sql")
    public void listarComentariosTestSql() {
        //trae la lista de comentarios
        List<Comentario> listaComentarios = miComentarioRepo.findAll();
        // imprime la lista de comentarios
        for (Comentario misComentarios : listaComentarios) {
            System.out.println(misComentarios);
        }

    }
}
