import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("/user")
public class UserController {

    @PostMapping("/create")
    public String createUser(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
    
    @GetMapping("login")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

}
