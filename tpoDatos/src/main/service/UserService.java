import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

@Service
public class UserService implements UserServiceImpl{ 
    
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> crearUsuario(User user){

    }

    public ResponseEntity<String> loguearUsuario(Login login){

    }
}
