package co.edu.uniquindio.proyectoUnishop.servicios;

import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import co.edu.uniquindio.proyectoUnishop.repositorios.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class PersonaServicioImpl implements PersonaServicio{


    @Autowired
    private PersonaRepo personaRepo;
    @Override
    public Persona recuperarPassword(String codigoPersona, String correo) throws Exception {


        return personaRepo.findAllByCodPersonaAndEmail(codigoPersona, correo).orElseThrow(() -> new Exception("los datos de autenticación son incorrectos"));
    }

    @Override
    public Persona iniciarSesion(String email, String password) throws Exception {
        return personaRepo.findAllByEmailAndPassword(email, password).orElseThrow(() -> new Exception("los datos de autenticación son incorrectos"));
    }
}