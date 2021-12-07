package co.edu.uniquindio.proyectoUnishop.servicios;


import co.edu.uniquindio.proyectoUnishop.entidades.Ciudad;
import co.edu.uniquindio.proyectoUnishop.entidades.Producto;
import co.edu.uniquindio.proyectoUnishop.repositorios.CiudadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CiudadServicioImpl implements CiudadServicio{

    @Autowired
    private CiudadRepo ciudadRepo;

    /**
     * se listan las ciudades guardadas en la listaCiudad
     * @return este retorna toda la lista de ciudad
     */
    @Override
    public List<Ciudad> listaCiudad() {
        return ciudadRepo.findAll();
    }

    /**
     *
     * @param codCiudad parametro por el cual se buscara el codigo de la ciudad ingresado
     * @return la ciudad buscada por su codigo
     * @throws Exception si no se encuentra la ciudad nos avisara de que no esta en la lista
     */
    @Override
    public Ciudad ObtenerCiudadCodigo(Integer codCiudad) throws Exception {


        return ciudadRepo.findById(codCiudad).orElseThrow(() -> new Exception("el id no corresponde a ninguna ciudad"));


    }
}
