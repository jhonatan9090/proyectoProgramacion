package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.repositorios.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class LoguinImpl implements  LoguinServicio{




    @Autowired
    private PersonaRepo personaRepo;




    @Override
    public Persona loguinPersona(String correo, String password) throws Exception {

        Optional<Persona> buscarPersona=personaRepo.findAllByEmailAndPassword(correo,password);
        if(buscarPersona.isEmpty()){
            throw new Exception("Los datos de no son correctos o no pertenecen a un usuario registrado");
        }

        return buscarPersona.get();
    }

    @Override
    public Persona recuperarPassword(String correo, String codigo) throws Exception {
        Optional<Persona>personaBuscada=personaRepo.findAllByEmailAndCodPersona(correo,codigo);

        if(personaBuscada.isEmpty()){
            throw new Exception("Los datos son incorrectos");

        }


        return personaBuscada.get();
    }
}
