package co.edu.uniquindio.proyectoUnishop.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Subasta implements Serializable {

    /**
     * Atributos de la entidad Subasta
     * @param codSubasta
     * @param fechaLimite
     */
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codSubasta;

    @Future
    @Column(nullable = false)
    private LocalDate fechaLimite;

    /**
     * Relacion entre subasta y producto
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private  Producto subastaProducto;

    /**
     * Relacion inversa de lista de usarios que sabastaran
     */
    @ToString.Exclude
    @OneToMany(mappedBy = "subastaUsuario")
    private List<SubastaUsuario>listaSubastaUsuarios;

    /**
     * Metodo constructor sin parametros de la entidad Subasta
     */
    public Subasta(){
    super();
    }

    /**
     * Metodo constructor de la entidad Subasta
     * @param fechaLimite fecha limite de la subasta
     * @param subastaProducto producto a subastar
     */
    public Subasta(@Future LocalDate fechaLimite, Producto subastaProducto) {
        this.fechaLimite = fechaLimite;
        this.subastaProducto = subastaProducto;
        this.listaSubastaUsuarios = listaSubastaUsuarios;
    }
}
