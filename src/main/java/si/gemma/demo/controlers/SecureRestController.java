package si.gemma.demo.controlers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secure")
public class SecureRestController {

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<String>("Secure", HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {

        String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return new ResponseEntity<String>("Hello World secure: " + user, HttpStatus.OK);
    }
}
