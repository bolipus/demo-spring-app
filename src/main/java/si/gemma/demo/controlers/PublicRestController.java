package si.gemma.demo.controlers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.gemma.demo.models.User;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/public")
public class PublicRestController {

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<String>("Public", HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("Hello World Public", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> user() {
        User user = new User();

        user.setName("user");
        user.setDate(LocalDateTime.now());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
