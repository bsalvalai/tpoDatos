import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.Generated;

@Data
@Entity
//Se podria hacer en MongoDB o Cassandra
@Document(collection = "Usuarios")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private int dni;
    private String category;

    


}
