package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Map;


@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Administrador extends Persona implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    String codigoAdmin;




    public Administrador() {
    super();

    }


    public Administrador(String codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }
}
