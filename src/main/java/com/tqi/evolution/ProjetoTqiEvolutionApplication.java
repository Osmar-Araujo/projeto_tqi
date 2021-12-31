package com.tqi.evolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjetoTqiEvolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTqiEvolutionApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
		
	}

}
