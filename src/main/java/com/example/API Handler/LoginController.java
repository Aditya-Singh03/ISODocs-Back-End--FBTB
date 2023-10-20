import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Model.loginRequest;
import com.example.Model.loginReturn;

@RestController
@CrossOrigin
public class LoginController {
    @PostMapping("/logIn")
    public ResponseEntity<loginReturn> logIn(@RequestBody loginRequest login) {
        return ResponseEntity.ok(new loginReturn(true, "Log-in successful")); // will return call to service (return success object(key, value))
    }
}
