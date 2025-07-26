package carrasco.edu.pe.proyectoTiendaHenry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // aqui va todas las configuraciones de seguridad
                .anyRequest().permitAll()
            )
            .formLogin(form -> form // Nueva sintaxis Lambda DSL
                .permitAll()
            );
        return http.build();
    }
}
