import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
    System.out.print("Crear");
       return userService.crearUsuario(user);
    }

    @GetMapping("/login")
    public ResponseEntity<String> loguearUsuario(@RequestBody Login login) {
        System.out.print("Loguear");
        return userService.loguearUsuario(login);
    }
}
