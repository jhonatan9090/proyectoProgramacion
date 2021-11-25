package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Categoria;
import co.edu.uniquindio.proyectoUnishop.repositorios.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    private CategoriaRepo categoriaRepo;

    @Override
    public List<Categoria> listarCategorias() {




        return  categoriaRepo.findAll();
    }

    @Override
    public Categoria obtenerCategoria(Integer codCategoria) throws Exception {


        return categoriaRepo.findById(codCategoria).orElseThrow(() -> new Exception("No existe una categoria con el id dado"));


    }


}
