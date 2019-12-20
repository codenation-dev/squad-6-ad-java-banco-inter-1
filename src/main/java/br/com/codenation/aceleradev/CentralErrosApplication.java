package br.com.codenation.aceleradev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-postgres.properties")
public class CentralErrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralErrosApplication.class, args);
	}

}
