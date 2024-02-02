package si.gemma.demo.controlers;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.http.auth.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Log4j2
public class MainControler {

    @Autowired
    private AuthenticationManager authManager;

    @GetMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response) {
        log.info("index");
        return "index";
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        log.info("hello");
        return "hello";
    }

   /* @GetMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        log.info("login");
        log.info(request.getRequestURI());

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken("test", "test");

        SecurityContextHolder.getContext()
                .setAuthentication(authToken);
    }*/

    @PostMapping("/login")
    public void login(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken("EIKS_USER_TEST", "");

        Authentication authentication = authManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);


    }





}
