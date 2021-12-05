package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.repositorios.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    /**
     * este metodo es para listar la categoria
     */
    @Autowired
    private CategoriaRepo categoriaRepo;

    @Override
    public List<Categoria> listarCategorias() {

        return  categoriaRepo.findAll();
    }

    /**
     *
     * @param codCategoria es el codigo de la lista de cada categoria
     * @return la categoria listada por la id ingresada
     * @throws Exception si no encunetra la id de la categoria ingresada
     */
    @Override
    public Categoria obtenerCategoria(Integer codCategoria) throws Exception {


        return categoriaRepo.findById(codCategoria).orElseThrow(() -> new Exception("No existe una categoria con el id dado"));


    }


}
