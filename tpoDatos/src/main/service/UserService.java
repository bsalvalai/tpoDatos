import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

@Service
public class UserService implements UserServiceImpl{ 
    
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> crearUsuario(User user){
        try {
            if (userRepository.findByUsername(user.getUsername())!=null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("userError");
            } else if (userRepository.findByMail(user.getEmail())!=null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("mailError");
            }
            else{
                userRepository.save(user);
            }           
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al crear usuario", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<String> loguearUsuario(Login login){

        List<User> usuarios = userRepository.findAll();
        for(User u: usuarios){
            if(u.getUsername().endsWith(login.getUsername) && u.getPassword().equals(login.getPassword)){
                return new ResponseEntity<String>("Usuario autenticado correctamente");
            }
        }
        return new ResponseEntity<String>("Error al encontrar usurio");
    }
}
