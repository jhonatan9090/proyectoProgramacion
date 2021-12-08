package co.edu.uniquindio.proyectoUnishop.rest;


import co.edu.uniquindio.proyectoUnishop.dto.Mensaje;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    public List<Usuario> listar(){
            return usuarioServicio.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable("id") String  idUsuario) {
        try {
            Usuario usuario = usuarioServicio.obtenerUsuario(idUsuario);
            return ResponseEntity.status(200).body(usuario);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearUsuario(@RequestBody Usuario usuario){
        try {
            usuarioServicio.registrarUsuario(usuario);
            return ResponseEntity.status(201).body(new Mensaje("El usuario se creó correctamente"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<Mensaje> actualizarUsuario(@RequestBody Usuario usuario) {
        try {
             usuarioServicio.actualizarUsuario(usuario);
            return ResponseEntity.status(200).body(new Mensaje("El usuario se actualizo correctamente"));

        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") String id) {
        try {
            usuarioServicio.eliminarUsuario(id);
            return ResponseEntity.status(200).body(new Mensaje("El usuario se eliminó correctamente"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/favoritos/{email}")
    public ResponseEntity<?> obtenerProductosFavoritos(@PathVariable("email") String email){
        try {
            List<Producto> lista = usuarioServicio.listarProductosFavoritos(email);
            return ResponseEntity.status(200).body(lista);
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }

    }
}
