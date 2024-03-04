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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Controller
@Log4j2
public class MainControler {


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

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        log.info("login");
        log.info("sicas_cert " + request.getHeader("sicas_cert"));
        log.info("certificate" + request.getHeader("certificate"));
        log.info(request.getHeader("host"));


        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            log.info(headerName+ ": " + headerValue);
        }

        return "redirect:/";
    }

    @GetMapping("/signout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        log.info("signout");
        return "logout";
    }

   @GetMapping("/signin")
    public void signin(HttpServletRequest request, HttpServletResponse response) {
        log.info("login");

        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            log.info("already authenticated");
            return;
        }

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken("test", "test");

        SecurityContextHolder.getContext()
                .setAuthentication(authToken);
    }

   /* @PostMapping("/login")
    public void login(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken("EIKS_USER_TEST", "");

        Authentication authentication = authManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }*/





}
