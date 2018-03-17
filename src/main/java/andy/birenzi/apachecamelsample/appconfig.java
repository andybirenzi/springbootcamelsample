package andy.birenzi.apachecamelsample;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appconfig {
    @Autowired
    CamelContext camelContext;
    @Bean
    CamelContextConfiguration contextConfiguration(
            @Value("${route.autostartup}") Boolean autoStartup) {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                context.setAutoStartup(autoStartup);
            }

            @Override
            public void afterApplicationStart(CamelContext context) {

            }
        };
    }
}
