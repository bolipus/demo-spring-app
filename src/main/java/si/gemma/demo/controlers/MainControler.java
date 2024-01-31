package si.gemma.demo.controlers;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
public class MainControler {

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }



    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        log.info("login");
        log.info(request.getRequestURI());

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken("test", null);

        SecurityContextHolder.getContext()
                .setAuthentication(authToken);

        return "redirect:/";
    }
}
