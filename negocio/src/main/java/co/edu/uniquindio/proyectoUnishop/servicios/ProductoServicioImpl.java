package co.edu.uniquindio.proyectoUnishop.servicios;


import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.entidades.Comentario;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
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
    public void actualizarProducto(Producto p) throws Exception {

    }

    @Override
    public void eliminarProducto(Integer idProdcuto) throws Exception {

    }

    @Override
    public Producto buscarProducto(Integer idProducto) throws Exception {
        return null;
    }

    @Override
    public List<Object[]> listarporCategoria(Categoria categoria) throws Exception {
        return null;
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
    public List<Object[]> buscarProductoFiltro(String nonbre, String[] filtro) throws Exception {
        return null;
    }
}
