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
    private int id;

    private String name;
    private String surname;
    private String email;
    private String password;



}
