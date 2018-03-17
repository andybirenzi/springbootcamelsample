package andy.birenzi.apachecamelsample;

import io.hawt.config.ConfigFacade;
import io.hawt.springboot.HawtPlugin;
import io.hawt.web.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContext;

@SpringBootApplication
public class ApachecamelsampleApplication {
	@Autowired
	private ServletContext servletContext;
	public static void main(String[] args) {
		System.setProperty(AuthenticationFilter.HAWTIO_AUTHENTICATION_ENABLED, "false");
		SpringApplication app = new SpringApplication(ApachecamelsampleApplication.class);
		app.addListeners(new ApplicationPidFileWriter("./app.pid"));
		app.run(args);
	}
	@Bean
	public HawtPlugin samplePlugin() {
		return new HawtPlugin("sample-plugin",
				"/hawtio/plugins",
				"",
				new String[] { "sample-plugin/js/sample-plugin.js" });
	}

	/**
	 * Set things up to be in offline mode.
	 */
	@Bean
	public ConfigFacade configFacade() {
		System.setProperty("hawtio.offline", "true");
		return ConfigFacade.getSingleton();
	}
}
