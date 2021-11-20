package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
    private UsuarioRepo usuarioRepo;

    public void UsuarioServicioImplf(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }


    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCodPersona());

        if(buscado.isPresent()) throw new Exception("El codigo " + u.getCodPersona() + " ya está registrado.");

        buscado = usuarioRepo.findByEmail(u.getEmail());

        if(buscado.isPresent()) throw new Exception("El correo " + u.getEmail() + " ya está registrado.");

        return usuarioRepo.save(u);
    }

    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCodPersona());

        if(buscado.isEmpty()) throw new Exception("El usuario con codigo " + u.getCodPersona() + " no está registrado.");

        return usuarioRepo.save(u);
    }

    @Override
    public void eliminarUsuario(String codigo) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(codigo);
        if(buscado.isEmpty()){
            throw new Exception("El codigo del usuario no existe");
        }
        usuarioRepo.deleteById(codigo);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(codigo);
        if(buscado.isPresent()){
            throw new Exception("El codigo del usuario ya existe");
        }
        return buscado.get();
    }
}
