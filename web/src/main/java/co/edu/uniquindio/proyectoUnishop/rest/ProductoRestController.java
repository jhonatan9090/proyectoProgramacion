package co.edu.uniquindio.proyectoUnishop.rest;


import co.edu.uniquindio.proyectoUnishop.dto.Mensaje;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoRestController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public List<Producto> listar(){
            return productoServicio.listarTodosporProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable("id") Integer codProducto) {
        try {
            Producto  producto = productoServicio.buscarProducto(codProducto);
            return ResponseEntity.status(200).body(producto);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearProducto(@RequestBody Producto producto){
        try {
            productoServicio.publicarProducto(producto);
            return ResponseEntity.status(201).body(new Mensaje("El producto se creó correctamente"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<Mensaje> actualizarProducto(@RequestBody Producto producto) {
        try {
            productoServicio.actualizarProducto(producto);
            return ResponseEntity.status(200).body(new Mensaje("El producto se actualizo correctamente"));

        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("/{codPersona}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("codPersona") Integer codPersona) {
        try {
            productoServicio.eliminarProducto(codPersona);
            return ResponseEntity.status(200).body(new Mensaje("El producto se eliminó correctamente"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?> buscarPorCategoria(@PathVariable("categoria") String categoria){
        try {
            List<Producto> lista = productoServicio.listarporCategoria(categoria);
            return ResponseEntity.status(200).body(lista);
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<?> buscarPorCiudad(@PathVariable("ciudad") String ciudad){
        try {
            List<Producto> lista = productoServicio.listarporCiudad(ciudad);
            return ResponseEntity.status(200).body(lista);
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/descripcion/{descripcion}")
    public ResponseEntity<?> buscarPorDescripcion(@PathVariable("descripcion") String descripcion){
        try {
            List<Producto> lista = productoServicio.listarporDescripcion(descripcion);
            return ResponseEntity.status(200).body(lista);
        }catch (Exception e){
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }
}
