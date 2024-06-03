import org.springframework.data.annotation.Id;

import jakarta.annotation.Generated;
import lombok.Data;

@Data
@Entity
//Hacer en Cassandra
public class Producto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String categoria;
    private double precio;
    private String image;
}
