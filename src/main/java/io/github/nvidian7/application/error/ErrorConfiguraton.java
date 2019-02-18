package styx.link.app.error;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ErrorConfiguraton
 */
@Configuration
public class ErrorConfiguraton {

    @Bean
    @ConfigurationProperties("server.error")
    ErrorProperties errorProperties() {
        return new ErrorProperties();
    }
    
}