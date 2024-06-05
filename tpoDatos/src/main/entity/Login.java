import lombok.Data;

@Data
//Quizas se tenga que hacer en Redis
public class Login {
    private String username;
    private String password;
}
