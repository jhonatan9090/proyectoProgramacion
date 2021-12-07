package co.edu.uniquindio.proyectoUnishop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * este metodo se encarga de configurar la pagina de incio de la aplicacion de unshop organizando todos los datos
 * de manera correcta
 */
@Configuration
public class PaginaPrincipalConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("forward:/index.xhtml");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
