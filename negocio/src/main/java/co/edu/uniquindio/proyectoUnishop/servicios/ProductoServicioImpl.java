package co.edu.uniquindio.proyectoUnishop.servicios;


import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final CategoriaRepo categoriaRepo;
    private final ComentarioRepo comentarioRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo, CategoriaRepo categoriaRepo, ComentarioRepo comentarioRepo) {
        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
        this.comentarioRepo = comentarioRepo;
    }


    @Override
    public Producto publicarProducto(Producto p) throws Exception {


        try {

            return productoRepo.save(p);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Producto actualizarProducto(Producto p) throws Exception {


        Optional<Producto> buscado = productoRepo.findById(p.getCodProducto());

        if (buscado.isEmpty()) {

            throw new Exception("El Producto con codigo " + p.getCodProducto() + " no está registrado.");
        }

        return productoRepo.save(p);
    }

    @Override
    public void eliminarProducto(Integer idProdcuto) throws Exception {


        Optional<Producto> buscado = productoRepo.findById(idProdcuto);

        if (buscado.isEmpty()) {
            throw new Exception("El codigo del producto no existe");
        }
        productoRepo.deleteById(idProdcuto);

    }

    @Override
    public Producto buscarProducto(Integer idProducto) throws Exception {

        Optional<Producto> producto = productoRepo.findById(idProducto);

        if (producto.isEmpty()) {

            throw new Exception("No existe un usuario con el id dado");
        }

        return producto.get();
    }

    @Override
    public List<Producto> listarporCategoria(Categoria categoria) throws Exception {

        Optional<Categoria> categoriaBuscada = categoriaRepo.findByNombreContains(categoria.getNombre());

        if (categoriaBuscada.isEmpty()) {
            throw new Exception("La categoria no existe");
        }


        return productoRepo.ListarProductosPorCategoria(categoria.getCodCategoria());
    }

    @Override
    public List<Producto> listarTodosporProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void comentarProducto(Comentario comentario) throws Exception {
        comentario.setFechaComentario(LocalDate.now());
        comentarioRepo.save(comentario);

    }

    @Override
    public Float obtenerPromedioProducto(Integer codProducto) {
        return productoRepo.obtenerPromedioCalificacion(codProducto);
    }


    @Override
    public void guardarProductoFavorito(Usuario usuario, Producto producto) throws Exception {

    }

    @Override
    public void eliminarProductoFavorito(Usuario usuario, Producto producto) throws Exception {

    }

    @Override
    public List<Producto> buscarProductoFiltro(String nombre, String[] filtro) {
        return productoRepo.listarProductoNombre(nombre);
    }


}
