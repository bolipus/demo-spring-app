package si.gemma.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import si.gemma.demo.security.CustomAuthenticationProvider;
import si.gemma.demo.security.LoginFilter;
import si.gemma.demo.security.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

    private final LoginSuccessHandler loginSuccessHandler;

    private final CustomAuthenticationProvider authProvider;

    private final LoginFilter loginFilter;

    @Autowired
    public WebSecurityConfig(LoginSuccessHandler loginSuccessHandler, CustomAuthenticationProvider authProvider, LoginFilter loginFilter) {
        this.loginSuccessHandler = loginSuccessHandler;
        this.authProvider = authProvider;
        this.loginFilter = loginFilter;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests((authz) -> {
                    authz
                            .antMatchers("/").permitAll()
                            .antMatchers("/signin").permitAll()
                            .antMatchers("/login").permitAll()
                            .antMatchers("/signout").permitAll()
                            .antMatchers("/error").permitAll()
                            .antMatchers("/api/public").permitAll()
                            .antMatchers("/api/secure").authenticated()
                            .anyRequest().permitAll();
                })
                .httpBasic(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .securityContext((context) -> context
                .requireExplicitSave(true)
                ).sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
        return http.build();
    }



}
