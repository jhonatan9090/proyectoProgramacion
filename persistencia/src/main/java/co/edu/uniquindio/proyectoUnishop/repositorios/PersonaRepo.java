package co.edu.uniquindio.proyectoUnishop.repositorios;


import co.edu.uniquindio.proyectoUnishop.entidades.Persona;
import co.edu.uniquindio.proyectoUnishop.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepo extends JpaRepository<Persona,String> {




    Optional<Persona> findAllByEmailAndPassword(String email, String password);

    Optional<Persona>findAllByCodPersonaAndEmail(String idPersona,String email);
}
