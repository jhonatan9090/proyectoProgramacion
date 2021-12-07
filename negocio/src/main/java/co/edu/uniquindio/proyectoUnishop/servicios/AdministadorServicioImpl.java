package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class AdministadorServicioImpl implements AdministradoServicio {

    @Autowired
    UsuarioRepo usuarioRepo;

    @Override
    public List<Usuario> reporteUsuarios() {
        return usuarioRepo.findAll();
    }
}
