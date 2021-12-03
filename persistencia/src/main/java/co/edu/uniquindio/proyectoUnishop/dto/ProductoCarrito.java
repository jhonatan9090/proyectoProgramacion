package co.edu.uniquindio.proyectoUnishop.dto;


import lombok.*;

@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoCarrito {


    @EqualsAndHashCode.Include
    private Integer idProducto;
    private String nombreProducto,imagenProducto;
    private Integer unidades;
    private Double precio;
}
