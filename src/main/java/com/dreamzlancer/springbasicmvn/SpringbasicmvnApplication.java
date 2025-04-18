package com.dreamzlancer.springbasicmvn;

import com.dreamzlancer.springbasicmvn.config.PizzaConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class SpringbasicmvnApplication implements CommandLineRunner {

	public SpringbasicmvnApplication(PizzaConfig pizzaConfig) {
		this.pizzaConfig = pizzaConfig;
	}

	private PizzaConfig pizzaConfig;

	public static void main(String[] args) {
		SpringApplication.run(SpringbasicmvnApplication.class, args);
	}

	@Override
	public void run(final String... args){


		log.info(
				String.format("I want a %s crust pizza, with %s and %s sauce",
						pizzaConfig.getCrust(),
						pizzaConfig.getToppings(),
						pizzaConfig.getSauce())
		);

	}
}