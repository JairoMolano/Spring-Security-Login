package co.usco.users_roles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import co.usco.users_roles.services.DataInitializerService;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	@Bean
	CommandLineRunner run(DataInitializerService dataInitializerService) {
		return (args) -> {
			dataInitializerService.initializeData();
		};
	}

}
