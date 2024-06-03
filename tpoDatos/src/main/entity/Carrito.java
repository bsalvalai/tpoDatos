import org.springframework.data.annotation.Id;

import jakarta.annotation.Generated;
import lombok.Data;

@Data
@Entity
//Puede ser en Redis o Cassandra
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private List<Producto> productos;
    
}
