package si.gemma.demo.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (!request.getRequestURI().contains("/logout") || !request.getRequestURI().contains("/signout")){
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken("test", "");

            SecurityContextHolder.getContext().setAuthentication(authToken);

            log.info("LoginFilter");
            log.info(request.getRequestURI());
        }




        filterChain.doFilter(request, response);
    }
}
