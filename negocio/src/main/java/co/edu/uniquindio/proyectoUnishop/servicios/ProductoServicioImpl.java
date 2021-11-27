package co.edu.uniquindio.proyectoUnishop.servicios;


import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyectoUnishop.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final CategoriaRepo categoriaRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo, CategoriaRepo categoriaRepo) {
        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
    }


    @Override
    public Producto publicarProducto(Producto p) throws Exception {


        try {

            return productoRepo.save(p);

        }catch (Exception e){

            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Producto actualizarProducto(Producto p) throws Exception {


        Optional<Producto> buscado = productoRepo.findById(p.getCodProducto());

        if(buscado.isEmpty()){

            throw new Exception("El Producto con codigo " + p.getCodProducto() + " no está registrado.");
        }

        return productoRepo.save(p);
    }

    @Override
    public void eliminarProducto(Integer idProdcuto) throws Exception {


        Optional<Producto>buscado=productoRepo.findById(idProdcuto);

        if(buscado.isEmpty()){
            throw new Exception("El codigo del producto no existe");
        }
        productoRepo.deleteById(idProdcuto);

    }

    @Override
    public Producto buscarProducto(Integer idProducto) throws Exception {

        Optional<Producto> producto = productoRepo.findById(idProducto);

        if(producto.isEmpty()){

            throw new Exception("No existe un usuario con el id dado");
        }

        return producto.get();
    }

    @Override
    public List<Producto> listarporCategoria(Categoria categoria) throws Exception {

        Optional<Categoria> categoriaBuscada= categoriaRepo.findByNombreContains(categoria.getNombre());

        if(categoriaBuscada.isEmpty()){
            throw new Exception("La categoria no existe");
        }


        return productoRepo.ListarProductosPorCategoria(categoria.getNombre());
    }

    @Override
    public List<Producto> listarTodosporProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void comentarProducto(Comentario comentario) throws Exception {

    }

    @Override
    public void guardarProductoFavorito(Usuario usuario, Producto producto) throws Exception {

    }

    @Override
    public void eliminarProductoFavorito(Usuario usuario, Producto producto) throws Exception {

    }

    @Override
    public List<Producto> buscarProductoFiltro(String nonbre, String[] filtro)  {
        return productoRepo.listarProductoNombre(nonbre);
    }


}
