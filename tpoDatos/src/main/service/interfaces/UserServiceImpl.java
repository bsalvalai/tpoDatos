import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;

public interface UserServiceImpl {

    public ResponseEntity<String> crearUsuario(User user);

    public ResponseEntity<String> loguearUsuario(Login login);
    
}
