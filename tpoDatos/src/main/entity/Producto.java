import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import jakarta.annotation.Generated;
import lombok.Data;

@Data
@Table("producto")
public class Producto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column("nombre")
    private String nombre;

    @Column("categoria")
    private String categoria;

    @Column("precio")
    private double precio;

    @Column("imagen")
    private String image;


}
